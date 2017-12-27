package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PotevioOrderApp implements Serializable {
    /**
     * 订单ID
     *
     * @mbg.generated
     */
    private Integer order_id;

    /**
     * 应用ID
     *
     * @mbg.generated
     */
    private Integer app_id;

    /**
     * 应用的SN
     *
     * @mbg.generated
     */
    private Integer app_sn;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Integer app_begintime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Integer app_endtime;

    /**
     * 应用的单价（每月）
     *
     * @mbg.generated
     */
    private BigDecimal app_price;

    /**
     * 应用的总价
     *
     * @mbg.generated
     */
    private BigDecimal app_money;

    private static final long serialVersionUID = 1L;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Integer getApp_sn() {
        return app_sn;
    }

    public void setApp_sn(Integer app_sn) {
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

    public BigDecimal getApp_price() {
        return app_price;
    }

    public void setApp_price(BigDecimal app_price) {
        this.app_price = app_price;
    }

    public BigDecimal getApp_money() {
        return app_money;
    }

    public void setApp_money(BigDecimal app_money) {
        this.app_money = app_money;
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
        PotevioOrderApp other = (PotevioOrderApp) that;
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getApp_sn() == null ? other.getApp_sn() == null : this.getApp_sn().equals(other.getApp_sn()))
            && (this.getApp_begintime() == null ? other.getApp_begintime() == null : this.getApp_begintime().equals(other.getApp_begintime()))
            && (this.getApp_endtime() == null ? other.getApp_endtime() == null : this.getApp_endtime().equals(other.getApp_endtime()))
            && (this.getApp_price() == null ? other.getApp_price() == null : this.getApp_price().equals(other.getApp_price()))
            && (this.getApp_money() == null ? other.getApp_money() == null : this.getApp_money().equals(other.getApp_money()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getApp_sn() == null) ? 0 : getApp_sn().hashCode());
        result = prime * result + ((getApp_begintime() == null) ? 0 : getApp_begintime().hashCode());
        result = prime * result + ((getApp_endtime() == null) ? 0 : getApp_endtime().hashCode());
        result = prime * result + ((getApp_price() == null) ? 0 : getApp_price().hashCode());
        result = prime * result + ((getApp_money() == null) ? 0 : getApp_money().hashCode());
        return result;
    }
}