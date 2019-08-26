package com.huang.pims.family.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (FamilyMember)实体类
 *
 * @author huangj
 * @since 2019-06-09 17:28:52
 */
@Entity
@Table(name = "base_family_member")
@Data
public class FamilyMember implements Serializable {
    
    private static final long serialVersionUID = -37896304431912766L;
    
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * 成员名称
     */
    @Column(name = "member_name")
    private String memberName;
    
    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    
    /**
     * 记录状态 1-有效 0-无效
     */
    @Column(name = "status")
    private String status;
    
    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    /**
     * 修改人
     */
    @Column(name = "modified_by")
    private Long modifiedBy;
    
    /**
     * 修改时间
     */
    @Column(name = "modified_at", updatable = false)
    private LocalDateTime modifiedAt;


}