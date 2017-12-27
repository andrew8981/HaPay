package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PotevioApp implements Serializable {
    /**
     * 应用ID，自增长
     *
     * @mbg.generated
     */
    private Integer app_id;

    /**
     * 应用在CRM上的系列号
     *
     * @mbg.generated
     */
    private String app_sn;

    /**
     * 应用名称
     *
     * @mbg.generated
     */
    private String app_name;

    /**
     * 应用在统一平台的appkey
     *
     * @mbg.generated
     */
    private String app_appkey;

    /**
     * 应用在统一平台的apisecret
     *
     * @mbg.generated
     */
    private String app_apisecret;

    /**
     * 应用在统一平台的所属权限组
     *
     * @mbg.generated
     */
    private String app_uuid;

    /**
     * 应用在统一平台的名称
     *
     * @mbg.generated
     */
    private String app_purchaseid;

    /**
     * 应用使用价格（每月）
     *
     * @mbg.generated
     */
    private BigDecimal app_price;

    /**
     * 应用的状态，0为关闭，1 为开启
     *
     * @mbg.generated
     */
    private Boolean app_status;

    /**
     * 应用的添加时间
     *
     * @mbg.generated
     */
    private Date app_addtime;

    private static final long serialVersionUID = 1L;

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getApp_sn() {
        return app_sn;
    }

    public void setApp_sn(String app_sn) {
        this.app_sn = app_sn;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_appkey() {
        return app_appkey;
    }

    public void setApp_appkey(String app_appkey) {
        this.app_appkey = app_appkey;
    }

    public String getApp_apisecret() {
        return app_apisecret;
    }

    public void setApp_apisecret(String app_apisecret) {
        this.app_apisecret = app_apisecret;
    }

    public String getApp_uuid() {
        return app_uuid;
    }

    public void setApp_uuid(String app_uuid) {
        this.app_uuid = app_uuid;
    }

    public String getApp_purchaseid() {
        return app_purchaseid;
    }

    public void setApp_purchaseid(String app_purchaseid) {
        this.app_purchaseid = app_purchaseid;
    }

    public BigDecimal getApp_price() {
        return app_price;
    }

    public void setApp_price(BigDecimal app_price) {
        this.app_price = app_price;
    }

    public Boolean getApp_status() {
        return app_status;
    }

    public void setApp_status(Boolean app_status) {
        this.app_status = app_status;
    }

    public Date getApp_addtime() {
        return app_addtime;
    }

    public void setApp_addtime(Date app_addtime) {
        this.app_addtime = app_addtime;
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
        PotevioApp other = (PotevioApp) that;
        return (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getApp_sn() == null ? other.getApp_sn() == null : this.getApp_sn().equals(other.getApp_sn()))
            && (this.getApp_name() == null ? other.getApp_name() == null : this.getApp_name().equals(other.getApp_name()))
            && (this.getApp_appkey() == null ? other.getApp_appkey() == null : this.getApp_appkey().equals(other.getApp_appkey()))
            && (this.getApp_apisecret() == null ? other.getApp_apisecret() == null : this.getApp_apisecret().equals(other.getApp_apisecret()))
            && (this.getApp_uuid() == null ? other.getApp_uuid() == null : this.getApp_uuid().equals(other.getApp_uuid()))
            && (this.getApp_purchaseid() == null ? other.getApp_purchaseid() == null : this.getApp_purchaseid().equals(other.getApp_purchaseid()))
            && (this.getApp_price() == null ? other.getApp_price() == null : this.getApp_price().equals(other.getApp_price()))
            && (this.getApp_status() == null ? other.getApp_status() == null : this.getApp_status().equals(other.getApp_status()))
            && (this.getApp_addtime() == null ? other.getApp_addtime() == null : this.getApp_addtime().equals(other.getApp_addtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getApp_sn() == null) ? 0 : getApp_sn().hashCode());
        result = prime * result + ((getApp_name() == null) ? 0 : getApp_name().hashCode());
        result = prime * result + ((getApp_appkey() == null) ? 0 : getApp_appkey().hashCode());
        result = prime * result + ((getApp_apisecret() == null) ? 0 : getApp_apisecret().hashCode());
        result = prime * result + ((getApp_uuid() == null) ? 0 : getApp_uuid().hashCode());
        result = prime * result + ((getApp_purchaseid() == null) ? 0 : getApp_purchaseid().hashCode());
        result = prime * result + ((getApp_price() == null) ? 0 : getApp_price().hashCode());
        result = prime * result + ((getApp_status() == null) ? 0 : getApp_status().hashCode());
        result = prime * result + ((getApp_addtime() == null) ? 0 : getApp_addtime().hashCode());
        return result;
    }
}