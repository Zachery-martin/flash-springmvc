package edu.nf.flash.entity;

import java.math.BigDecimal;

/**
 * @ClassName: Transaction
 * @Author: Zachery
 * @Data: 20:29
 **/
public class Transaction {

    private String tid;
    private String cid;
    private String autId;
    private String reAddress;
    private BigDecimal price;
    private String payment;
    private String remarks;
    private String camilo;

    public String getCamilo() {
        return camilo;
    }

    public void setCamilo(String camilo) {
        this.camilo = camilo;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAutId() {
        return autId;
    }

    public void setAutId(String autId) {
        this.autId = autId;
    }

    public String getReAddress() {
        return reAddress;
    }

    public void setReAddress(String reAddress) {
        this.reAddress = reAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
