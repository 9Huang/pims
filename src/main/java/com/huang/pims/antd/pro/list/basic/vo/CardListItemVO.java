package com.huang.pims.antd.pro.list.basic.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class CardListItemVO implements Serializable {

    private String id;

    private String owner;

    private String title;

    private String cover;

    private String status;

    private Double percent;

    private String logo;

    private String href;

    private Object body;

    private Long updatedAt;

    private Long createdAt;

    private String subDescription;

    private String description;

    private Long activeUser;

    private Long newUser;

    private Long star;

    private Long like;

    private Long message;

    private String content;

    private List<MemberVO> members;

}
