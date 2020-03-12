package edu.nf.flash.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @ClassName: ReWorkUpdate
 * @Author: Zachery
 * @Data: 20:29
 **/
public class ReWorkUpdate {

    private String updateId;
    private String autId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date time;
    private String url;
    private String remarks;

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getAutId() {
        return autId;
    }

    public void setAutId(String autId) {
        this.autId = autId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
