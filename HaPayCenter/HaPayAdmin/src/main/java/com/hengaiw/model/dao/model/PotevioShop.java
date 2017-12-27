package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PotevioShop implements Serializable {
    /**
     * 商户ID，自增长
     *
     * @mbg.generated
     */
    private Integer shop_id;

    /**
     * 商户手机号
     *
     * @mbg.generated
     */
    private String shop_phone;

    /**
     * 商户在统一平台的登录密码
     *
     * @mbg.generated
     */
    private String shop_passwd;

    /**
     * 商户在基础库的ID
     *
     * @mbg.generated
     */
    private String shop_baseid;

    /**
     * 商户名称
     *
     * @mbg.generated
     */
    private String shop_name;

    /**
     * 商户的联系人名称
     *
     * @mbg.generated
     */
    private String shop_linkman;

    /**
     * 商户地址
     *
     * @mbg.generated
     */
    private String shop_address;

    /**
     * 商户类型
     *
     * @mbg.generated
     */
    private String shop_businesstype;

    /**
     * 商户的行业细分
     *
     * @mbg.generated
     */
    private String shop_typeCode;

    /**
     * 套餐类型
     *
     * @mbg.generated
     */
    private String shop_fee;

    /**
     * 套餐开始时间
     *
     * @mbg.generated
     */
    private Integer shop_fee_begintime;

    /**
     * 套餐结束时间
     *
     * @mbg.generated
     */
    private Integer shop_fee_endtime;

    /**
     * 商户所属区域省级代码
     *
     * @mbg.generated
     */
    private String shop_proCode;

    /**
     * 商户所属区域市级代码
     *
     * @mbg.generated
     */
    private String shop_cityCode;

    /**
     * 商户所属区域县级代码
     *
     * @mbg.generated
     */
    private String shop_areaCode;

    /**
     * 添加时间
     *
     * @mbg.generated
     */
    private Date shop_addtime;

    private static final long serialVersionUID = 1L;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public String getShop_passwd() {
        return shop_passwd;
    }

    public void setShop_passwd(String shop_passwd) {
        this.shop_passwd = shop_passwd;
    }

    public String getShop_baseid() {
        return shop_baseid;
    }

    public void setShop_baseid(String shop_baseid) {
        this.shop_baseid = shop_baseid;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_linkman() {
        return shop_linkman;
    }

    public void setShop_linkman(String shop_linkman) {
        this.shop_linkman = shop_linkman;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_businesstype() {
        return shop_businesstype;
    }

    public void setShop_businesstype(String shop_businesstype) {
        this.shop_businesstype = shop_businesstype;
    }

    public String getShop_typeCode() {
        return shop_typeCode;
    }

    public void setShop_typeCode(String shop_typeCode) {
        this.shop_typeCode = shop_typeCode;
    }

    public String getShop_fee() {
        return shop_fee;
    }

    public void setShop_fee(String shop_fee) {
        this.shop_fee = shop_fee;
    }

    public Integer getShop_fee_begintime() {
        return shop_fee_begintime;
    }

    public void setShop_fee_begintime(Integer shop_fee_begintime) {
        this.shop_fee_begintime = shop_fee_begintime;
    }

    public Integer getShop_fee_endtime() {
        return shop_fee_endtime;
    }

    public void setShop_fee_endtime(Integer shop_fee_endtime) {
        this.shop_fee_endtime = shop_fee_endtime;
    }

    public String getShop_proCode() {
        return shop_proCode;
    }

    public void setShop_proCode(String shop_proCode) {
        this.shop_proCode = shop_proCode;
    }

    public String getShop_cityCode() {
        return shop_cityCode;
    }

    public void setShop_cityCode(String shop_cityCode) {
        this.shop_cityCode = shop_cityCode;
    }

    public String getShop_areaCode() {
        return shop_areaCode;
    }

    public void setShop_areaCode(String shop_areaCode) {
        this.shop_areaCode = shop_areaCode;
    }

    public Date getShop_addtime() {
        return shop_addtime;
    }

    public void setShop_addtime(Date shop_addtime) {
        this.shop_addtime = shop_addtime;
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
        PotevioShop other = (PotevioShop) that;
        return (this.getShop_id() == null ? other.getShop_id() == null : this.getShop_id().equals(other.getShop_id()))
            && (this.getShop_phone() == null ? other.getShop_phone() == null : this.getShop_phone().equals(other.getShop_phone()))
            && (this.getShop_passwd() == null ? other.getShop_passwd() == null : this.getShop_passwd().equals(other.getShop_passwd()))
            && (this.getShop_baseid() == null ? other.getShop_baseid() == null : this.getShop_baseid().equals(other.getShop_baseid()))
            && (this.getShop_name() == null ? other.getShop_name() == null : this.getShop_name().equals(other.getShop_name()))
            && (this.getShop_linkman() == null ? other.getShop_linkman() == null : this.getShop_linkman().equals(other.getShop_linkman()))
            && (this.getShop_address() == null ? other.getShop_address() == null : this.getShop_address().equals(other.getShop_address()))
            && (this.getShop_businesstype() == null ? other.getShop_businesstype() == null : this.getShop_businesstype().equals(other.getShop_businesstype()))
            && (this.getShop_typeCode() == null ? other.getShop_typeCode() == null : this.getShop_typeCode().equals(other.getShop_typeCode()))
            && (this.getShop_fee() == null ? other.getShop_fee() == null : this.getShop_fee().equals(other.getShop_fee()))
            && (this.getShop_fee_begintime() == null ? other.getShop_fee_begintime() == null : this.getShop_fee_begintime().equals(other.getShop_fee_begintime()))
            && (this.getShop_fee_endtime() == null ? other.getShop_fee_endtime() == null : this.getShop_fee_endtime().equals(other.getShop_fee_endtime()))
            && (this.getShop_proCode() == null ? other.getShop_proCode() == null : this.getShop_proCode().equals(other.getShop_proCode()))
            && (this.getShop_cityCode() == null ? other.getShop_cityCode() == null : this.getShop_cityCode().equals(other.getShop_cityCode()))
            && (this.getShop_areaCode() == null ? other.getShop_areaCode() == null : this.getShop_areaCode().equals(other.getShop_areaCode()))
            && (this.getShop_addtime() == null ? other.getShop_addtime() == null : this.getShop_addtime().equals(other.getShop_addtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShop_id() == null) ? 0 : getShop_id().hashCode());
        result = prime * result + ((getShop_phone() == null) ? 0 : getShop_phone().hashCode());
        result = prime * result + ((getShop_passwd() == null) ? 0 : getShop_passwd().hashCode());
        result = prime * result + ((getShop_baseid() == null) ? 0 : getShop_baseid().hashCode());
        result = prime * result + ((getShop_name() == null) ? 0 : getShop_name().hashCode());
        result = prime * result + ((getShop_linkman() == null) ? 0 : getShop_linkman().hashCode());
        result = prime * result + ((getShop_address() == null) ? 0 : getShop_address().hashCode());
        result = prime * result + ((getShop_businesstype() == null) ? 0 : getShop_businesstype().hashCode());
        result = prime * result + ((getShop_typeCode() == null) ? 0 : getShop_typeCode().hashCode());
        result = prime * result + ((getShop_fee() == null) ? 0 : getShop_fee().hashCode());
        result = prime * result + ((getShop_fee_begintime() == null) ? 0 : getShop_fee_begintime().hashCode());
        result = prime * result + ((getShop_fee_endtime() == null) ? 0 : getShop_fee_endtime().hashCode());
        result = prime * result + ((getShop_proCode() == null) ? 0 : getShop_proCode().hashCode());
        result = prime * result + ((getShop_cityCode() == null) ? 0 : getShop_cityCode().hashCode());
        result = prime * result + ((getShop_areaCode() == null) ? 0 : getShop_areaCode().hashCode());
        result = prime * result + ((getShop_addtime() == null) ? 0 : getShop_addtime().hashCode());
        return result;
    }
}