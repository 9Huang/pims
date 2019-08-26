package com.huang.pims.family.repository;

import com.huang.pims.family.model.FamilyMember;
import com.huang.pims.family.repository.ext.FamilyMemberExtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (FamilyMember)表数据库访问层
 *
 * @author huangj
 * @since 2019-06-14 21:27:17
 */
@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long>, FamilyMemberExtRepository<FamilyMember, Long> {

    /**
     * 查询指定状态的家庭成员
     * @param status    有效家庭成员-Constants.STATUS_VALID
     *                  无效家庭成员-Constants.STATUS_INVALID
     * @return
     */
    List<FamilyMember> findByStatus(String status);

    /**
     * 更新家庭成员的状态
     * @param status    成员状态    1--有效  0--无效
     * @param id        家庭成员的主键id
     * @return          被修改的记录数
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update base_family_member set status=:status where id=:id", nativeQuery = true)
    int updateStatusById(String status, Long id);

}