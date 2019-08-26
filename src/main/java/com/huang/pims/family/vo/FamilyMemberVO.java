package com.huang.pims.family.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.huang.pims.base.enums.DataStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (FamilyMember)实体类
 *
 * @author huangj
 * @since 2019-06-09 17:54:23
 */
@Data
public class FamilyMemberVO implements Serializable {
    
    private static final long serialVersionUID = 183001908230490879L;
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 成员名称
     */
    private String memberName;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 记录状态 1-有效 0-无效
     */
    private String status;

    private DataStatusEnum statusEnum;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 修改人
     */
    private Long modifiedBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;
    

}