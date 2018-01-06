package com.account.bean;

import java.io.Serializable;
import java.util.Date;

public class Attachment implements Serializable {
    private Long id;

    private String atLinkTable;

    private Long atLinkId;

    private String atPath;

    private String atName;

    private String atType;

    private String atMimeType;

    private Date atUploadTime;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

    private String creator;

    private String atDevelop05;

    private String atDevelop04;

    private String atDevelop03;

    private String atDevelop02;

    private String atDevelop01;

    private String atDesc;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtLinkTable() {
        return atLinkTable;
    }

    public void setAtLinkTable(String atLinkTable) {
        this.atLinkTable = atLinkTable == null ? null : atLinkTable.trim();
    }

    public Long getAtLinkId() {
        return atLinkId;
    }

    public void setAtLinkId(Long atLinkId) {
        this.atLinkId = atLinkId;
    }

    public String getAtPath() {
        return atPath;
    }

    public void setAtPath(String atPath) {
        this.atPath = atPath == null ? null : atPath.trim();
    }

    public String getAtName() {
        return atName;
    }

    public void setAtName(String atName) {
        this.atName = atName == null ? null : atName.trim();
    }

    public String getAtType() {
        return atType;
    }

    public void setAtType(String atType) {
        this.atType = atType == null ? null : atType.trim();
    }

    public String getAtMimeType() {
        return atMimeType;
    }

    public void setAtMimeType(String atMimeType) {
        this.atMimeType = atMimeType == null ? null : atMimeType.trim();
    }

    public Date getAtUploadTime() {
        return atUploadTime;
    }

    public void setAtUploadTime(Date atUploadTime) {
        this.atUploadTime = atUploadTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getAtDevelop05() {
        return atDevelop05;
    }

    public void setAtDevelop05(String atDevelop05) {
        this.atDevelop05 = atDevelop05 == null ? null : atDevelop05.trim();
    }

    public String getAtDevelop04() {
        return atDevelop04;
    }

    public void setAtDevelop04(String atDevelop04) {
        this.atDevelop04 = atDevelop04 == null ? null : atDevelop04.trim();
    }

    public String getAtDevelop03() {
        return atDevelop03;
    }

    public void setAtDevelop03(String atDevelop03) {
        this.atDevelop03 = atDevelop03 == null ? null : atDevelop03.trim();
    }

    public String getAtDevelop02() {
        return atDevelop02;
    }

    public void setAtDevelop02(String atDevelop02) {
        this.atDevelop02 = atDevelop02 == null ? null : atDevelop02.trim();
    }

    public String getAtDevelop01() {
        return atDevelop01;
    }

    public void setAtDevelop01(String atDevelop01) {
        this.atDevelop01 = atDevelop01 == null ? null : atDevelop01.trim();
    }

    public String getAtDesc() {
        return atDesc;
    }

    public void setAtDesc(String atDesc) {
        this.atDesc = atDesc == null ? null : atDesc.trim();
    }
}