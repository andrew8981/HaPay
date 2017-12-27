package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PotevioOrder implements Serializable {
    /**
     * 订单ID,自增长
     *
     * @mbg.generated
     */
    private Integer order_id;

    /**
     * 订单流水号
     *
     * @mbg.generated
     */
    private String order_sn;

    /**
     * 商户ID
     *
     * @mbg.generated
     */
    private Integer shop_id;

    /**
     * 订单总金额
     *
     * @mbg.generated
     */
    private BigDecimal order_price;

    /**
     * 订单状态,0为未付款，1为已付款
     *
     * @mbg.generated
     */
    private Boolean order_status;

    /**
     * 支付方式，1为微信支付，2为支付宝支付，3为银行卡支付
     *
     * @mbg.generated
     */
    private Boolean order_pay;

    /**
     * 支付流水号
     *
     * @mbg.generated
     */
    private String pay_sn;

    /**
     * 支付时间
     *
     * @mbg.generated
     */
    private Integer pay_time;

    /**
     * 订单添加时间
     *
     * @mbg.generated
     */
    private Date order_addtime;

    /**
     * 订单更新时间
     *
     * @mbg.generated
     */
    private Date order_updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public BigDecimal getOrder_price() {
        return order_price;
    }

    public void setOrder_price(BigDecimal order_price) {
        this.order_price = order_price;
    }

    public Boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Boolean order_status) {
        this.order_status = order_status;
    }

    public Boolean getOrder_pay() {
        return order_pay;
    }

    public void setOrder_pay(Boolean order_pay) {
        this.order_pay = order_pay;
    }

    public String getPay_sn() {
        return pay_sn;
    }

    public void setPay_sn(String pay_sn) {
        this.pay_sn = pay_sn;
    }

    public Integer getPay_time() {
        return pay_time;
    }

    public void setPay_time(Integer pay_time) {
        this.pay_time = pay_time;
    }

    public Date getOrder_addtime() {
        return order_addtime;
    }

    public void setOrder_addtime(Date order_addtime) {
        this.order_addtime = order_addtime;
    }

    public Date getOrder_updatetime() {
        return order_updatetime;
    }

    public void setOrder_updatetime(Date order_updatetime) {
        this.order_updatetime = order_updatetime;
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
        PotevioOrder other = (PotevioOrder) that;
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getOrder_sn() == null ? other.getOrder_sn() == null : this.getOrder_sn().equals(other.getOrder_sn()))
            && (this.getShop_id() == null ? other.getShop_id() == null : this.getShop_id().equals(other.getShop_id()))
            && (this.getOrder_price() == null ? other.getOrder_price() == null : this.getOrder_price().equals(other.getOrder_price()))
            && (this.getOrder_status() == null ? other.getOrder_status() == null : this.getOrder_status().equals(other.getOrder_status()))
            && (this.getOrder_pay() == null ? other.getOrder_pay() == null : this.getOrder_pay().equals(other.getOrder_pay()))
            && (this.getPay_sn() == null ? other.getPay_sn() == null : this.getPay_sn().equals(other.getPay_sn()))
            && (this.getPay_time() == null ? other.getPay_time() == null : this.getPay_time().equals(other.getPay_time()))
            && (this.getOrder_addtime() == null ? other.getOrder_addtime() == null : this.getOrder_addtime().equals(other.getOrder_addtime()))
            && (this.getOrder_updatetime() == null ? other.getOrder_updatetime() == null : this.getOrder_updatetime().equals(other.getOrder_updatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getOrder_sn() == null) ? 0 : getOrder_sn().hashCode());
        result = prime * result + ((getShop_id() == null) ? 0 : getShop_id().hashCode());
        result = prime * result + ((getOrder_price() == null) ? 0 : getOrder_price().hashCode());
        result = prime * result + ((getOrder_status() == null) ? 0 : getOrder_status().hashCode());
        result = prime * result + ((getOrder_pay() == null) ? 0 : getOrder_pay().hashCode());
        result = prime * result + ((getPay_sn() == null) ? 0 : getPay_sn().hashCode());
        result = prime * result + ((getPay_time() == null) ? 0 : getPay_time().hashCode());
        result = prime * result + ((getOrder_addtime() == null) ? 0 : getOrder_addtime().hashCode());
        result = prime * result + ((getOrder_updatetime() == null) ? 0 : getOrder_updatetime().hashCode());
        return result;
    }
}