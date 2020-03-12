package edu.nf.flash.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName: ReUpShelf
 * @Author: Zachery
 * @Data: 20:29
 **/
public class ReUpShelf {

    private String rid;
    private String autId;
    private String name;
    private String title;
    private String workName;
    private String introduce;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date upLoadTime;
    private String url;
    private String workType;
    private String continueUp;
    private String remarks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getAutId() {
        return autId;
    }

    public void setAutId(String autId) {
        this.autId = autId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Date getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(Date upLoadTime) {
        this.upLoadTime = upLoadTime;
    }

    public String getContinueUp() {
        return continueUp;
    }

    public void setContinueUp(String continueUp) {
        this.continueUp = continueUp;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
