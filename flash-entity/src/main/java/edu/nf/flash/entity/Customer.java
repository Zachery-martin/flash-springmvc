package edu.nf.flash.entity;

/**
 * @ClassName: Customer
 * @Author: Zachery
 * @Data: 20:28
 **/
public class Customer {

    private String cusId;
    private String cusLogId;
    private String cusLogPwd;
    private String name;
    private String phone;
    private String address;
    private String reAddress1;
    private String reAddress2;
    private String reAddress3;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusLogId() {
        return cusLogId;
    }

    public void setCusLogId(String cusLogId) {
        this.cusLogId = cusLogId;
    }

    public String getCusLogPwd() {
        return cusLogPwd;
    }

    public void setCusLogPwd(String cusLogPwd) {
        this.cusLogPwd = cusLogPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getReAddress1() {
        return reAddress1;
    }

    public void setReAddress1(String reAddress1) {
        this.reAddress1 = reAddress1;
    }

    public String getReAddress2() {
        return reAddress2;
    }

    public void setReAddress2(String reAddress2) {
        this.reAddress2 = reAddress2;
    }

    public String getReAddress3() {
        return reAddress3;
    }

    public void setReAddress3(String reAddress3) {
        this.reAddress3 = reAddress3;
    }
}
