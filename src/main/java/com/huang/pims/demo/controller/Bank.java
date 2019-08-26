package com.huang.pims.demo.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bank {

    private String bin;

    private String binClass;

    private String binType;

    private String binLength;

    private Integer status;

    public void setBinLength(String binLength) {
        this.binLength = binLength;
        this.status = 1;
    }

    public Integer getStatus() {
        return this.status;
    }

}
