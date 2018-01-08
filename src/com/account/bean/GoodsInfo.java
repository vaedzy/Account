package com.account.bean;

import java.io.Serializable;

public class GoodsInfo  implements Serializable {

    private static final long serialVersionUID = 1L;
    private long gId;
    private long appId;
    private long quId;
    private String gName;
    private double gprice;
    private String gphotourl1;
    private String gphotourl2;
    private String gphotourl3;
    private String gphotourl4;
    private String gphotourl5;
    private String gphotourl6;
    private String gphotourl7;
    private String gphotourl8;
    private String gphotourl9;
    private String gphotourl10;
    private String remark;
    private Integer status;
    private String userName;
    private String passWord;
    private long userId;


    public long getUserId() {
        return userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getgId() {
        return gId;
    }

    public void setgId(long gId) {
        this.gId = gId;
    }

    public void setQuId(long quId) {
        this.quId = quId;
    }

    public long getQuId() {
        return quId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }


    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public String getGphotourl1() {
        return gphotourl1;
    }

    public void setGphotourl1(String gphotourl1) {
        this.gphotourl1 = gphotourl1;
    }

    public String getGphotourl2() {
        return gphotourl2;
    }

    public void setGphotourl2(String gphotourl2) {
        this.gphotourl2 = gphotourl2;
    }

    public String getGphotourl3() {
        return gphotourl3;
    }

    public void setGphotourl3(String gphotourl3) {
        this.gphotourl3 = gphotourl3;
    }

    public String getGphotourl4() {
        return gphotourl4;
    }

    public void setGphotourl4(String gphotourl4) {
        this.gphotourl4 = gphotourl4;
    }

    public String getGphotourl5() {
        return gphotourl5;
    }

    public void setGphotourl5(String gphotourl5) {
        this.gphotourl5 = gphotourl5;
    }

    public String getGphotourl6() {
        return gphotourl6;
    }

    public void setGphotourl6(String gphotourl6) {
        this.gphotourl6 = gphotourl6;
    }

    public String getGphotourl7() {
        return gphotourl7;
    }

    public void setGphotourl7(String gphotourl7) {
        this.gphotourl7 = gphotourl7;
    }

    public String getGphotourl8() {
        return gphotourl8;
    }

    public void setGphotourl8(String gphotourl8) {
        this.gphotourl8 = gphotourl8;
    }

    public String getGphotourl9() {
        return gphotourl9;
    }

    public void setGphotourl9(String gphotourl9) {
        this.gphotourl9 = gphotourl9;
    }

    public String getGphotourl10() {
        return gphotourl10;
    }

    public void setGphotourl10(String gphotourl10) {
        this.gphotourl10 = gphotourl10;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
