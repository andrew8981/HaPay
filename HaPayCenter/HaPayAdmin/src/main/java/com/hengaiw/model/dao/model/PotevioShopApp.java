package com.hengaiw.model.dao.model;

import java.io.Serializable;

public class PotevioShopApp implements Serializable {
    /**
     * 商户ID
     *
     * @mbg.generated
     */
    private Integer shop_id;

    /**
     * 应用ID
     *
     * @mbg.generated
     */
    private Integer app_id;

    /**
     * 应用SN
     *
     * @mbg.generated
     */
    private String app_sn;

    /**
     * 授权开始时间
     *
     * @mbg.generated
     */
    private Integer app_begintime;

    /**
     * 授权结束时间
     *
     * @mbg.generated
     */
    private Integer app_endtime;

    private static final long serialVersionUID = 1L;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

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

    public Integer getApp_begintime() {
        return app_begintime;
    }

    public void setApp_begintime(Integer app_begintime) {
        this.app_begintime = app_begintime;
    }

    public Integer getApp_endtime() {
        return app_endtime;
    }

    public void setApp_endtime(Integer app_endtime) {
        this.app_endtime = app_endtime;
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
        PotevioShopApp other = (PotevioShopApp) that;
        return (this.getShop_id() == null ? other.getShop_id() == null : this.getShop_id().equals(other.getShop_id()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getApp_sn() == null ? other.getApp_sn() == null : this.getApp_sn().equals(other.getApp_sn()))
            && (this.getApp_begintime() == null ? other.getApp_begintime() == null : this.getApp_begintime().equals(other.getApp_begintime()))
            && (this.getApp_endtime() == null ? other.getApp_endtime() == null : this.getApp_endtime().equals(other.getApp_endtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShop_id() == null) ? 0 : getShop_id().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getApp_sn() == null) ? 0 : getApp_sn().hashCode());
        result = prime * result + ((getApp_begintime() == null) ? 0 : getApp_begintime().hashCode());
        result = prime * result + ((getApp_endtime() == null) ? 0 : getApp_endtime().hashCode());
        return result;
    }
}