package com.hengaiw.model.dao.model;

import java.io.Serializable;

public class WxBillDay implements Serializable {
    private Integer id;

    /**
     * 总交易单数
     *
     * @mbg.generated
     */
    private String total_order;

    /**
     * 总交易额
     *
     * @mbg.generated
     */
    private String total_pay;

    /**
     * 总退款金额
     *
     * @mbg.generated
     */
    private String total_refund;

    /**
     * 总企业红包退款金额
     *
     * @mbg.generated
     */
    private String total_company_refund;

    /**
     * 手续费总金额
     *
     * @mbg.generated
     */
    private String total_fee;

    /**
     * 帐单日期
     *
     * @mbg.generated
     */
    private String bill_date;

    /**
     * 商家ID
     *
     * @mbg.generated
     */
    private String mchId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotal_order() {
        return total_order;
    }

    public void setTotal_order(String total_order) {
        this.total_order = total_order;
    }

    public String getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(String total_pay) {
        this.total_pay = total_pay;
    }

    public String getTotal_refund() {
        return total_refund;
    }

    public void setTotal_refund(String total_refund) {
        this.total_refund = total_refund;
    }

    public String getTotal_company_refund() {
        return total_company_refund;
    }

    public void setTotal_company_refund(String total_company_refund) {
        this.total_company_refund = total_company_refund;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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
        WxBillDay other = (WxBillDay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTotal_order() == null ? other.getTotal_order() == null : this.getTotal_order().equals(other.getTotal_order()))
            && (this.getTotal_pay() == null ? other.getTotal_pay() == null : this.getTotal_pay().equals(other.getTotal_pay()))
            && (this.getTotal_refund() == null ? other.getTotal_refund() == null : this.getTotal_refund().equals(other.getTotal_refund()))
            && (this.getTotal_company_refund() == null ? other.getTotal_company_refund() == null : this.getTotal_company_refund().equals(other.getTotal_company_refund()))
            && (this.getTotal_fee() == null ? other.getTotal_fee() == null : this.getTotal_fee().equals(other.getTotal_fee()))
            && (this.getBill_date() == null ? other.getBill_date() == null : this.getBill_date().equals(other.getBill_date()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTotal_order() == null) ? 0 : getTotal_order().hashCode());
        result = prime * result + ((getTotal_pay() == null) ? 0 : getTotal_pay().hashCode());
        result = prime * result + ((getTotal_refund() == null) ? 0 : getTotal_refund().hashCode());
        result = prime * result + ((getTotal_company_refund() == null) ? 0 : getTotal_company_refund().hashCode());
        result = prime * result + ((getTotal_fee() == null) ? 0 : getTotal_fee().hashCode());
        result = prime * result + ((getBill_date() == null) ? 0 : getBill_date().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        return result;
    }
}