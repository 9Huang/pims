package com.huang.pims.demo.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Demo {

    private String stringField;

    private int intField;

    private Date dateField;

    public Demo() {
        super();
    }

    public Demo(String stringField, int intField, Date dateField) {
        this.stringField = stringField;
        this.intField = intField;
        this.dateField = dateField;
    }

}
