package com.huang.pims.family.service.impl;

import com.github.pagehelper.PageHelper;
import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.constants.Constants;
import com.huang.pims.family.mapper.FamilyMemberMapper;
import com.huang.pims.family.model.FamilyMember;
import com.huang.pims.family.service.FamilyMemberService;
import com.huang.pims.family.vo.FamilyMemberVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * (FamilyMember)表服务实现类
 *
 * @author huangj
 * @since 2019-06-09 17:28:50
 */
@Service("familyMemberService")
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FamilyMemberServiceImpl.class);

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Override
    @Cacheable(value = "pims", key = "'family.member.'+#id")
    public FamilyMember queryById(@Min(value = 1, message = "主键ID必须大于0") Long id) {
        return familyMemberMapper.selectByPrimaryKey(id);
    }

    private List<FamilyMemberVO> convert(List<FamilyMember> familyMemberList) {
        List<FamilyMemberVO> familyMemberVOList = new ArrayList<>();
        if (!Objects.isNull(familyMemberList)) {
            for (FamilyMember familyMember : familyMemberList) {
                FamilyMemberVO familyMemberVO = new FamilyMemberVO();
                BeanUtils.copyProperties(familyMember, familyMemberVO);
                familyMemberVOList.add(familyMemberVO);
            }
        }
        return familyMemberVOList;
    }

    @Override
    public List<FamilyMemberVO> queryAll() {
        return convert(familyMemberMapper.selectAll());
    }

    @Override
    public List<FamilyMemberVO> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(familyMemberMapper.selectAll());
    }

    @Override
    public List<FamilyMemberVO> queryByStatus(String status) {
        return convert(familyMemberMapper.selectByStatus(status));
    }

    @Override
    public List<FamilyMemberVO> queryByStatus(String status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return convert(familyMemberMapper.selectByStatus(status));
    }

    @Override
    public List<SelectOption> queryByStatusForSelect(String status) {
        List<FamilyMember> familyMemberList;
        if (Constants.STATUS_INVALID.equals(status) || Constants.STATUS_VALID.equals(status)) {
            familyMemberList = familyMemberMapper.selectByStatus(status);
        } else {
            familyMemberList = familyMemberMapper.selectAll();
        }
        List<SelectOption> selectOptionList = new ArrayList<>();
        if (!Objects.isNull(familyMemberList)) {
            familyMemberList.stream().forEach(familyMember -> {
                SelectOption option = new SelectOption();
                option.setKey("" + familyMember.getId());
                // 如果设置了家庭成员的昵称，优先展示昵称
                option.setVal(StringUtils.isNotBlank(familyMember.getNickName()) ? familyMember.getNickName() : familyMember.getMemberName());
                selectOptionList.add(option);
            });
        }
        return selectOptionList;
    }

    @Override
    @CachePut(value = "pims", key = "'family.member.'+#familyMemberVO.id")
    public FamilyMember insert(@NotNull(message = "familyMember不能为null") FamilyMemberVO familyMemberVO) {
        FamilyMember familyMember = new FamilyMember();
        BeanUtils.copyProperties(familyMemberVO, familyMember);
        familyMemberMapper.insertSelective(familyMember);
        return queryById(familyMember.getId());
    }

    @Override
    @CachePut(value = "pims", key = "'family.member.'+#familyMemberVO.id")
    public FamilyMember update(@NotNull(message = "familyMember不能为null") FamilyMemberVO familyMemberVO) {
        FamilyMember familyMember = new FamilyMember();
        BeanUtils.copyProperties(familyMemberVO, familyMember);
        familyMemberMapper.updateByPrimaryKeySelective(familyMember);
        return queryById(familyMember.getId());
    }

    @Override
    public int deleteById(@Min(value = 1, message = "主键ID必须大于0") Long id) {
        return familyMemberMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = "pims", key = "'family.member.'+#id")
    public int deleteByIdLogically(@Min(value = 1, message = "主键ID必须大于0") Long id) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setId(id);
        familyMember.setStatus(Constants.STATUS_INVALID);
        return familyMemberMapper.updateByPrimaryKeySelective(familyMember);
    }

}