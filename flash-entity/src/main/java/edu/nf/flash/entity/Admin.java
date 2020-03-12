package edu.nf.flash.entity;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName: Admin
 * @Author: Zachery
 * @Data: 20:27
 **/
public class Admin {

    private String adminId;
    @NotEmpty(message="{users.userName.empty}")
    private String adLogId;
    @NotEmpty(message="{users.password.empty}")
    private String adLogPwd;
    private String name;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdLogId() {
        return adLogId;
    }

    public void setAdLogId(String adLogId) {
        this.adLogId = adLogId;
    }

    public String getAdLogPwd() {
        return adLogPwd;
    }

    public void setAdLogPwd(String adLogPwd) {
        this.adLogPwd = adLogPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
