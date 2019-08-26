package com.huang.pims.family.mapper;

import com.huang.pims.family.model.FamilyMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (FamilyMember)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-14 21:27:17
 */
@Mapper
@Repository
public interface FamilyMemberMapper {

    FamilyMember selectByPrimaryKey(@Param("id") Long id);

    List<FamilyMember> selectAll();

    List<FamilyMember> selectByStatus(@Param("status") String status);

    int insert(FamilyMember familyMember);
    
    int insertSelective(FamilyMember familyMember);

    int updateByPrimaryKey(FamilyMember familyMember);

    int updateByPrimaryKeySelective(FamilyMember familyMember);

    int deleteByPrimaryKey(@Param("id") Long id);

}