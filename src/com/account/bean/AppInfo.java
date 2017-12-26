package com.account.bean;

import com.account.common.constant.DateConsts;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class AppInfo implements Serializable {
    private Long id;

    private String aAppName;

    private String aAppType;

    private String aPinyin;

    private String aDevelop10;

    private String aDevelop09;

    private String aDevelop08;

    private String aDevelop07;

    private String aDevelop06;

    private String aDevelop05;

    private String aDevelop04;

    private String aDevelop03;

    private String aDevelop01;

    private String aDevelop02;

    private Date aCreateTime;

    private String aCreator;

    private Date aModiftyTime;

    private String aModifier;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaAppName() {
        return aAppName;
    }

    public void setaAppName(String aAppName) {
        this.aAppName = aAppName == null ? null : aAppName.trim();
    }

    public String getaAppType() {
        return aAppType;
    }

    public void setaAppType(String aAppType) {
        this.aAppType = aAppType == null ? null : aAppType.trim();
    }

    public String getaPinyin() {
        return aPinyin;
    }

    public void setaPinyin(String aPinyin) {
        this.aPinyin = aPinyin == null ? null : aPinyin.trim();
    }

    public String getaDevelop10() {
        return aDevelop10;
    }

    public void setaDevelop10(String aDevelop10) {
        this.aDevelop10 = aDevelop10 == null ? null : aDevelop10.trim();
    }

    public String getaDevelop09() {
        return aDevelop09;
    }

    public void setaDevelop09(String aDevelop09) {
        this.aDevelop09 = aDevelop09 == null ? null : aDevelop09.trim();
    }

    public String getaDevelop08() {
        return aDevelop08;
    }

    public void setaDevelop08(String aDevelop08) {
        this.aDevelop08 = aDevelop08 == null ? null : aDevelop08.trim();
    }

    public String getaDevelop07() {
        return aDevelop07;
    }

    public void setaDevelop07(String aDevelop07) {
        this.aDevelop07 = aDevelop07 == null ? null : aDevelop07.trim();
    }

    public String getaDevelop06() {
        return aDevelop06;
    }

    public void setaDevelop06(String aDevelop06) {
        this.aDevelop06 = aDevelop06 == null ? null : aDevelop06.trim();
    }

    public String getaDevelop05() {
        return aDevelop05;
    }

    public void setaDevelop05(String aDevelop05) {
        this.aDevelop05 = aDevelop05 == null ? null : aDevelop05.trim();
    }

    public String getaDevelop04() {
        return aDevelop04;
    }

    public void setaDevelop04(String aDevelop04) {
        this.aDevelop04 = aDevelop04 == null ? null : aDevelop04.trim();
    }

    public String getaDevelop03() {
        return aDevelop03;
    }

    public void setaDevelop03(String aDevelop03) {
        this.aDevelop03 = aDevelop03 == null ? null : aDevelop03.trim();
    }

    public String getaDevelop01() {
        return aDevelop01;
    }

    public void setaDevelop01(String aDevelop01) {
        this.aDevelop01 = aDevelop01 == null ? null : aDevelop01.trim();
    }

    public String getaDevelop02() {
        return aDevelop02;
    }

    public void setaDevelop02(String aDevelop02) {
        this.aDevelop02 = aDevelop02 == null ? null : aDevelop02.trim();
    }
    @DateTimeFormat(pattern = DateConsts.TIME_PATTERN)
    @JsonFormat(pattern = DateConsts.TIME_PATTERN, timezone = DateConsts.TIME_ZERO)
    public Date getaCreateTime() {
        return aCreateTime;
    }

    public void setaCreateTime(Date aCreateTime) {
        this.aCreateTime = aCreateTime;
    }

    public String getaCreator() {
        return aCreator;
    }

    public void setaCreator(String aCreator) {
        this.aCreator = aCreator == null ? null : aCreator.trim();
    }
    @DateTimeFormat(pattern = DateConsts.TIME_PATTERN)
    @JsonFormat(pattern = DateConsts.TIME_PATTERN, timezone = DateConsts.TIME_ZERO)
    public Date getaModiftyTime() {
        return aModiftyTime;
    }

    public void setaModiftyTime(Date aModiftyTime) {
        this.aModiftyTime = aModiftyTime;
    }

    public String getaModifier() {
        return aModifier;
    }

    public void setaModifier(String aModifier) {
        this.aModifier = aModifier == null ? null : aModifier.trim();
    }
}