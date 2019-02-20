package com.huang.pims.beans.base;

import com.huang.pims.enums.base.SexEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huang
 */
@Data
public class PersonalBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private Byte age;

    private SexEnum sex;

    private String idcard;

    private Date birthDate;
}