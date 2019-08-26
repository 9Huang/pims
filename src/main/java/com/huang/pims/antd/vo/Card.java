package com.huang.pims.antd.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Card implements Serializable {

    private static final long serialVersionUID = 4005700443763602099L;

    /**
     * 卡片封面
     */
    private String coverImageSrc;

    /**
     * 卡片标题
     * type: String | ReactNode
     */
    private String title;

    /**
     * 卡片类型，可设置为 inner 或 不设置
     */
    private String type;

}
