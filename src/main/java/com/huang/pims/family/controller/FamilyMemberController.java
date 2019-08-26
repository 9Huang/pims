package com.huang.pims.family.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.base.enums.DataStatusEnum;
import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.constants.Constants;
import com.huang.pims.family.model.FamilyMember;
import com.huang.pims.family.service.FamilyMemberService;
import com.huang.pims.family.vo.FamilyMemberVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (FamilyMember)表控制层
 *
 * @author huangj
 * @since 2019-06-09 17:28:50
 */
@Controller
@RequestMapping("/familyMember")
public class FamilyMemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FamilyMemberController.class);

    /**
     * 服务对象
     */
    @Autowired
    private FamilyMemberService familyMemberService;
    
    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return 
     */
    @ResponseBody
    @GetMapping(value = "/queryById/{id}")
    public FamilyMember queryById(@PathVariable Long id) {
        return familyMemberService.queryById(id);
    }

    /**
     * 查询所有家庭成员
     * @param status
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/queryAll")
    public List<FamilyMemberVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<FamilyMemberVO> familyMemberVOList;
        if (Objects.isNull(status)) {
            familyMemberVOList = familyMemberService.queryAll();
        } else {
            familyMemberVOList = familyMemberService.queryByStatus(status);
        }
        return familyMemberVOList;
    }

    /**
     * 分页查询所有家庭成员
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/queryAllForPage")
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<FamilyMemberVO> familyMemberVOList;
        if (Objects.isNull(status)) {
            familyMemberVOList = familyMemberService.queryAll(pageNum, pageSize);
        } else {
            familyMemberVOList = familyMemberService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<FamilyMemberVO> pageInfo = PageInfo.of(familyMemberVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    /**
     * 获取家庭成员的下拉框数据
     * @param status
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/queryForSelect")
    public List<SelectOption> queryForSelect(@RequestParam(value = "status", required = false) String status) {
        if (StringUtils.isBlank(status)) {
            status = Constants.STATUS_ALL;
        }
        return familyMemberService.queryByStatusForSelect(status);
    }

    /**
     * 新增家庭成员
     *
     * @param familyMemberVO
     * @return 
     */
    @ResponseBody
    @PostMapping(value = "/insert")
    public FamilyMember insert(@RequestBody FamilyMemberVO familyMemberVO) {
        return familyMemberService.insert(familyMemberVO);
    }
    
    /**
     * 修改家庭成员信息
     *
     * @param familyMemberVO
     * @return 
     */
    @ResponseBody
    @PutMapping(value = "/update")
    public FamilyMember update(@RequestBody FamilyMemberVO familyMemberVO) {
        return familyMemberService.update(familyMemberVO);
    }

    /**
     * 逻辑删除家庭成员
     *
     * @param id 主键ID
     * @return
     */
    @ResponseBody
    @DeleteMapping(value = "/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return familyMemberService.deleteByIdLogically(id);
    }

    @GetMapping(value = "/toList")
    public String toList(Model model, @RequestParam(value = "status", required = false) String status) {
        List<FamilyMemberVO> familyMemberVOList;
        if (Objects.isNull(status)) {
            familyMemberVOList = familyMemberService.queryAll();
        } else {
            familyMemberVOList = familyMemberService.queryByStatus(status);
        }
        familyMemberVOList.stream().forEach(m -> m.setStatusEnum(DataStatusEnum.getByCode(m.getStatus())));
        model.addAttribute("familyMemberList", familyMemberVOList);
        return "family/member/familyMemberList";
    }


}