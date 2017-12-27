package com.hengaiw.model.dao.model;

import java.io.Serializable;

public class PotevioTariff implements Serializable {
    /**
     * 套餐ID，自增长
     *
     * @mbg.generated
     */
    private Integer tariff_id;

    /**
     * 资费
     *
     * @mbg.generated
     */
    private String tariff_value;

    /**
     * 套餐对应ID
     *
     * @mbg.generated
     */
    private String tariff_type;

    /**
     * 套餐绑定的应用ID串
     *
     * @mbg.generated
     */
    private String tariff_app;

    /**
     * 说明
     *
     * @mbg.generated
     */
    private String tariff_explain;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String summary;

    private static final long serialVersionUID = 1L;

    public Integer getTariff_id() {
        return tariff_id;
    }

    public void setTariff_id(Integer tariff_id) {
        this.tariff_id = tariff_id;
    }

    public String getTariff_value() {
        return tariff_value;
    }

    public void setTariff_value(String tariff_value) {
        this.tariff_value = tariff_value;
    }

    public String getTariff_type() {
        return tariff_type;
    }

    public void setTariff_type(String tariff_type) {
        this.tariff_type = tariff_type;
    }

    public String getTariff_app() {
        return tariff_app;
    }

    public void setTariff_app(String tariff_app) {
        this.tariff_app = tariff_app;
    }

    public String getTariff_explain() {
        return tariff_explain;
    }

    public void setTariff_explain(String tariff_explain) {
        this.tariff_explain = tariff_explain;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
        PotevioTariff other = (PotevioTariff) that;
        return (this.getTariff_id() == null ? other.getTariff_id() == null : this.getTariff_id().equals(other.getTariff_id()))
            && (this.getTariff_value() == null ? other.getTariff_value() == null : this.getTariff_value().equals(other.getTariff_value()))
            && (this.getTariff_type() == null ? other.getTariff_type() == null : this.getTariff_type().equals(other.getTariff_type()))
            && (this.getTariff_app() == null ? other.getTariff_app() == null : this.getTariff_app().equals(other.getTariff_app()))
            && (this.getTariff_explain() == null ? other.getTariff_explain() == null : this.getTariff_explain().equals(other.getTariff_explain()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTariff_id() == null) ? 0 : getTariff_id().hashCode());
        result = prime * result + ((getTariff_value() == null) ? 0 : getTariff_value().hashCode());
        result = prime * result + ((getTariff_type() == null) ? 0 : getTariff_type().hashCode());
        result = prime * result + ((getTariff_app() == null) ? 0 : getTariff_app().hashCode());
        result = prime * result + ((getTariff_explain() == null) ? 0 : getTariff_explain().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        return result;
    }
}