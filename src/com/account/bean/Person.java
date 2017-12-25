package com.account.bean;

import com.account.common.constant.DateConsts;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private Long id;

    private String pFullname;

    private String pSex;

    private String pCertificateType;

    private String pCertificateNumber;

    private String pPhone;

    private Date pBirthday;

    private String pNickname;

    private String pEmail;

    private Date pLastTime;

    private String pLastIp;

    private String pRegisteredAddress;

    private Date pRegisteredTime;

    private String pRegisteredIp;

    private Long pImage;

    private String pFormerPhone;

    private String pDevelop01;

    private String pIsRegistered;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpFullname() {
        return pFullname;
    }

    public void setpFullname(String pFullname) {
        this.pFullname = pFullname == null ? null : pFullname.trim();
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
    }

    public String getpCertificateType() {
        return pCertificateType;
    }

    public void setpCertificateType(String pCertificateType) {
        this.pCertificateType = pCertificateType == null ? null : pCertificateType.trim();
    }

    public String getpCertificateNumber() {
        return pCertificateNumber;
    }

    public void setpCertificateNumber(String pCertificateNumber) {
        this.pCertificateNumber = pCertificateNumber == null ? null : pCertificateNumber.trim();
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone == null ? null : pPhone.trim();
    }
    @DateTimeFormat(pattern = DateConsts.TIME_PATTERN)
    @JsonFormat(pattern = DateConsts.TIME_PATTERN, timezone = DateConsts.TIME_ZERO)
    public Date getpBirthday() {
        return pBirthday;
    }

    public void setpBirthday(Date pBirthday) {
        this.pBirthday = pBirthday;
    }

    public String getpNickname() {
        return pNickname;
    }

    public void setpNickname(String pNickname) {
        this.pNickname = pNickname == null ? null : pNickname.trim();
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail == null ? null : pEmail.trim();
    }
    @DateTimeFormat(pattern = DateConsts.TIME_PATTERN)
    @JsonFormat(pattern = DateConsts.TIME_PATTERN, timezone = DateConsts.TIME_ZERO)

    public Date getpLastTime() {
        return pLastTime;
    }

    public void setpLastTime(Date pLastTime) {
        this.pLastTime = pLastTime;
    }

    public String getpLastIp() {
        return pLastIp;
    }

    public void setpLastIp(String pLastIp) {
        this.pLastIp = pLastIp == null ? null : pLastIp.trim();
    }

    public String getpRegisteredAddress() {
        return pRegisteredAddress;
    }

    public void setpRegisteredAddress(String pRegisteredAddress) {
        this.pRegisteredAddress = pRegisteredAddress == null ? null : pRegisteredAddress.trim();
    }
    @DateTimeFormat(pattern = DateConsts.TIME_PATTERN)
    @JsonFormat(pattern = DateConsts.TIME_PATTERN, timezone = DateConsts.TIME_ZERO)
    public Date getpRegisteredTime() {
        return pRegisteredTime;
    }

    public void setpRegisteredTime(Date pRegisteredTime) {
        this.pRegisteredTime = pRegisteredTime;
    }

    public String getpRegisteredIp() {
        return pRegisteredIp;
    }

    public void setpRegisteredIp(String pRegisteredIp) {
        this.pRegisteredIp = pRegisteredIp == null ? null : pRegisteredIp.trim();
    }

    public Long getpImage() {
        return pImage;
    }

    public void setpImage(Long pImage) {
        this.pImage = pImage;
    }

    public String getpFormerPhone() {
        return pFormerPhone;
    }

    public void setpFormerPhone(String pFormerPhone) {
        this.pFormerPhone = pFormerPhone == null ? null : pFormerPhone.trim();
    }

    public String getpDevelop01() {
        return pDevelop01;
    }

    public void setpDevelop01(String pDevelop01) {
        this.pDevelop01 = pDevelop01;
    }

    public String getpIsRegistered() {
        return pIsRegistered;
    }

    public void setpIsRegistered(String pIsRegistered) {
        this.pIsRegistered = pIsRegistered;
    }
}