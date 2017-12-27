package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PotevioModel implements Serializable {
    private Integer m_id;

    /**
     * 模块名称
     *
     * @mbg.generated
     */
    private String m_name;

    /**
     * 模块地址
     *
     * @mbg.generated
     */
    private String m_url;

    /**
     * 模块图标
     *
     * @mbg.generated
     */
    private String m_icon;

    /**
     * 模块父级ID
     *
     * @mbg.generated
     */
    private Integer m_parent;

    /**
     * 模块状态，0为禁用，1为启用
     *
     * @mbg.generated
     */
    private Short m_state;

    /**
     * 添加时间
     *
     * @mbg.generated
     */
    private Date m_addtime;

    /**
     * 模块说明
     *
     * @mbg.generated
     */
    private String m_res;

    private static final long serialVersionUID = 1L;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_url() {
        return m_url;
    }

    public void setM_url(String m_url) {
        this.m_url = m_url;
    }

    public String getM_icon() {
        return m_icon;
    }

    public void setM_icon(String m_icon) {
        this.m_icon = m_icon;
    }

    public Integer getM_parent() {
        return m_parent;
    }

    public void setM_parent(Integer m_parent) {
        this.m_parent = m_parent;
    }

    public Short getM_state() {
        return m_state;
    }

    public void setM_state(Short m_state) {
        this.m_state = m_state;
    }

    public Date getM_addtime() {
        return m_addtime;
    }

    public void setM_addtime(Date m_addtime) {
        this.m_addtime = m_addtime;
    }

    public String getM_res() {
        return m_res;
    }

    public void setM_res(String m_res) {
        this.m_res = m_res;
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
        PotevioModel other = (PotevioModel) that;
        return (this.getM_id() == null ? other.getM_id() == null : this.getM_id().equals(other.getM_id()))
            && (this.getM_name() == null ? other.getM_name() == null : this.getM_name().equals(other.getM_name()))
            && (this.getM_url() == null ? other.getM_url() == null : this.getM_url().equals(other.getM_url()))
            && (this.getM_icon() == null ? other.getM_icon() == null : this.getM_icon().equals(other.getM_icon()))
            && (this.getM_parent() == null ? other.getM_parent() == null : this.getM_parent().equals(other.getM_parent()))
            && (this.getM_state() == null ? other.getM_state() == null : this.getM_state().equals(other.getM_state()))
            && (this.getM_addtime() == null ? other.getM_addtime() == null : this.getM_addtime().equals(other.getM_addtime()))
            && (this.getM_res() == null ? other.getM_res() == null : this.getM_res().equals(other.getM_res()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getM_id() == null) ? 0 : getM_id().hashCode());
        result = prime * result + ((getM_name() == null) ? 0 : getM_name().hashCode());
        result = prime * result + ((getM_url() == null) ? 0 : getM_url().hashCode());
        result = prime * result + ((getM_icon() == null) ? 0 : getM_icon().hashCode());
        result = prime * result + ((getM_parent() == null) ? 0 : getM_parent().hashCode());
        result = prime * result + ((getM_state() == null) ? 0 : getM_state().hashCode());
        result = prime * result + ((getM_addtime() == null) ? 0 : getM_addtime().hashCode());
        result = prime * result + ((getM_res() == null) ? 0 : getM_res().hashCode());
        return result;
    }
}