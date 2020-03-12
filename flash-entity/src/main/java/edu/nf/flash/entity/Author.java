package edu.nf.flash.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName: aUTHOR
 * @Author: Zachery
 * @Data: 20:28
 **/
public class Author {

    private String autId;
    private String autLogId;
    private String autLogPwd;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private String idCard;
    private String email;
    private String phone;
    private String address;

    public String getAutId() {
        return autId;
    }

    public void setAutId(String autId) {
        this.autId = autId;
    }

    public String getAutLogId() {
        return autLogId;
    }

    public void setAutLogId(String autLogId) {
        this.autLogId = autLogId;
    }

    public String getAutLogPwd() {
        return autLogPwd;
    }

    public void setAutLogPwd(String autLogPwd) {
        this.autLogPwd = autLogPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
