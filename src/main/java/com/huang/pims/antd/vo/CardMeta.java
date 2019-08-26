package com.huang.pims.antd.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CardMeta implements Serializable {
    private static final long serialVersionUID = 4052336901856071980L;

    /**
     * 头像/图标
     */
    private String avatar;

    /**
     * 描述内容
     */
    private String description;

    /**
     * 标题内容
     */
    private String title;


}
