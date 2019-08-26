package com.huang.pims.antd.pro.list.basic.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class MemberVO implements Serializable {
    private static final long serialVersionUID = -8215371759975896762L;

    private String id;

    private String name;

    private String avatar;

}
