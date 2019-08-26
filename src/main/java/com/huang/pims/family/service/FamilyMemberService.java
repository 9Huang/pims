package com.huang.pims.family.service;

import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.family.model.FamilyMember;
import com.huang.pims.family.vo.FamilyMemberVO;

import java.util.List;

/**
 * (FamilyMember)表服务接口
 *
 * @author huangj
 * @since 2019-06-14 21:30:50
 */
public interface FamilyMemberService {

    /**
     * 根据id查询家庭成员的详细信息
     * @param id
     * @return
     */
    FamilyMember queryById(Long id);

    /**
     * 查询所有的家庭成员信息
     * @return
     */
    List<FamilyMemberVO> queryAll();

    /**
     * 查询所有的家庭成员信息（分页）
     * @param pageNum       页码
     * @param pageSize      每页显示的记录数
     * @return
     */
    List<FamilyMemberVO> queryAll(int pageNum, int pageSize);

    /**
     * 查询指定状态的家庭成员信息
     * @param status    1-有效 0-无效 else
     * @return
     */
    List<FamilyMemberVO> queryByStatus(String status);

    /**
     * 查询指定状态的家庭成员信息（分页）
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<FamilyMemberVO> queryByStatus(String status, int pageNum, int pageSize);

    List<SelectOption> queryByStatusForSelect(String status);

    /**
     * 新增数据
     *
     * @param familyMemberVO 实例对象
     * @return 实例对象
     */
    FamilyMember insert(FamilyMemberVO familyMemberVO);

    /**
     * 修改数据
     *
     * @param familyMemberVO 实例对象
     * @return 实例对象
     */
    FamilyMember update(FamilyMemberVO familyMemberVO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);
    
    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteByIdLogically(Long id);

}