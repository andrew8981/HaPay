package com.hengaiw.model.dao.model;

import java.io.Serializable;

public class WxBill implements Serializable {
    private Integer id;

    /**
     * 交易时间
     *
     * @mbg.generated
     */
    private String tradetime;

    private String ghid;

    private String mchid;

    private String submch;

    private String deviceid;

    private String wxorder;

    private String bzorder;

    private String openid;

    private String tradetype;

    private String tradestatus;

    private String bank;

    private String currency;

    private String totalmoney;

    private String redpacketmoney;

    private String wxrefund;

    private String bzrefund;

    private String refundmoney;

    private String redpacketrefund;

    private String refundtype;

    private String refundstatus;

    private String productname;

    private String bzdatapacket;

    private String fee;

    private String rate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradetime() {
        return tradetime;
    }

    public void setTradetime(String tradetime) {
        this.tradetime = tradetime;
    }

    public String getGhid() {
        return ghid;
    }

    public void setGhid(String ghid) {
        this.ghid = ghid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getSubmch() {
        return submch;
    }

    public void setSubmch(String submch) {
        this.submch = submch;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getWxorder() {
        return wxorder;
    }

    public void setWxorder(String wxorder) {
        this.wxorder = wxorder;
    }

    public String getBzorder() {
        return bzorder;
    }

    public void setBzorder(String bzorder) {
        this.bzorder = bzorder;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public String getTradestatus() {
        return tradestatus;
    }

    public void setTradestatus(String tradestatus) {
        this.tradestatus = tradestatus;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getRedpacketmoney() {
        return redpacketmoney;
    }

    public void setRedpacketmoney(String redpacketmoney) {
        this.redpacketmoney = redpacketmoney;
    }

    public String getWxrefund() {
        return wxrefund;
    }

    public void setWxrefund(String wxrefund) {
        this.wxrefund = wxrefund;
    }

    public String getBzrefund() {
        return bzrefund;
    }

    public void setBzrefund(String bzrefund) {
        this.bzrefund = bzrefund;
    }

    public String getRefundmoney() {
        return refundmoney;
    }

    public void setRefundmoney(String refundmoney) {
        this.refundmoney = refundmoney;
    }

    public String getRedpacketrefund() {
        return redpacketrefund;
    }

    public void setRedpacketrefund(String redpacketrefund) {
        this.redpacketrefund = redpacketrefund;
    }

    public String getRefundtype() {
        return refundtype;
    }

    public void setRefundtype(String refundtype) {
        this.refundtype = refundtype;
    }

    public String getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(String refundstatus) {
        this.refundstatus = refundstatus;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBzdatapacket() {
        return bzdatapacket;
    }

    public void setBzdatapacket(String bzdatapacket) {
        this.bzdatapacket = bzdatapacket;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WxBill other = (WxBill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTradetime() == null ? other.getTradetime() == null : this.getTradetime().equals(other.getTradetime()))
            && (this.getGhid() == null ? other.getGhid() == null : this.getGhid().equals(other.getGhid()))
            && (this.getMchid() == null ? other.getMchid() == null : this.getMchid().equals(other.getMchid()))
            && (this.getSubmch() == null ? other.getSubmch() == null : this.getSubmch().equals(other.getSubmch()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getWxorder() == null ? other.getWxorder() == null : this.getWxorder().equals(other.getWxorder()))
            && (this.getBzorder() == null ? other.getBzorder() == null : this.getBzorder().equals(other.getBzorder()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getTradetype() == null ? other.getTradetype() == null : this.getTradetype().equals(other.getTradetype()))
            && (this.getTradestatus() == null ? other.getTradestatus() == null : this.getTradestatus().equals(other.getTradestatus()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getTotalmoney() == null ? other.getTotalmoney() == null : this.getTotalmoney().equals(other.getTotalmoney()))
            && (this.getRedpacketmoney() == null ? other.getRedpacketmoney() == null : this.getRedpacketmoney().equals(other.getRedpacketmoney()))
            && (this.getWxrefund() == null ? other.getWxrefund() == null : this.getWxrefund().equals(other.getWxrefund()))
            && (this.getBzrefund() == null ? other.getBzrefund() == null : this.getBzrefund().equals(other.getBzrefund()))
            && (this.getRefundmoney() == null ? other.getRefundmoney() == null : this.getRefundmoney().equals(other.getRefundmoney()))
            && (this.getRedpacketrefund() == null ? other.getRedpacketrefund() == null : this.getRedpacketrefund().equals(other.getRedpacketrefund()))
            && (this.getRefundtype() == null ? other.getRefundtype() == null : this.getRefundtype().equals(other.getRefundtype()))
            && (this.getRefundstatus() == null ? other.getRefundstatus() == null : this.getRefundstatus().equals(other.getRefundstatus()))
            && (this.getProductname() == null ? other.getProductname() == null : this.getProductname().equals(other.getProductname()))
            && (this.getBzdatapacket() == null ? other.getBzdatapacket() == null : this.getBzdatapacket().equals(other.getBzdatapacket()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTradetime() == null) ? 0 : getTradetime().hashCode());
        result = prime * result + ((getGhid() == null) ? 0 : getGhid().hashCode());
        result = prime * result + ((getMchid() == null) ? 0 : getMchid().hashCode());
        result = prime * result + ((getSubmch() == null) ? 0 : getSubmch().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getWxorder() == null) ? 0 : getWxorder().hashCode());
        result = prime * result + ((getBzorder() == null) ? 0 : getBzorder().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getTradetype() == null) ? 0 : getTradetype().hashCode());
        result = prime * result + ((getTradestatus() == null) ? 0 : getTradestatus().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getTotalmoney() == null) ? 0 : getTotalmoney().hashCode());
        result = prime * result + ((getRedpacketmoney() == null) ? 0 : getRedpacketmoney().hashCode());
        result = prime * result + ((getWxrefund() == null) ? 0 : getWxrefund().hashCode());
        result = prime * result + ((getBzrefund() == null) ? 0 : getBzrefund().hashCode());
        result = prime * result + ((getRefundmoney() == null) ? 0 : getRefundmoney().hashCode());
        result = prime * result + ((getRedpacketrefund() == null) ? 0 : getRedpacketrefund().hashCode());
        result = prime * result + ((getRefundtype() == null) ? 0 : getRefundtype().hashCode());
        result = prime * result + ((getRefundstatus() == null) ? 0 : getRefundstatus().hashCode());
        result = prime * result + ((getProductname() == null) ? 0 : getProductname().hashCode());
        result = prime * result + ((getBzdatapacket() == null) ? 0 : getBzdatapacket().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        return result;
    }
}