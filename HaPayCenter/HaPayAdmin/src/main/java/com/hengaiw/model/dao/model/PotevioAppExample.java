package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PotevioAppExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PotevioAppExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andApp_idIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andApp_idIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andApp_idEqualTo(Integer value) {
            addCriterion("app_id =", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idGreaterThan(Integer value) {
            addCriterion("app_id >", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idLessThan(Integer value) {
            addCriterion("app_id <", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idIn(List<Integer> values) {
            addCriterion("app_id in", values, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_snIsNull() {
            addCriterion("app_sn is null");
            return (Criteria) this;
        }

        public Criteria andApp_snIsNotNull() {
            addCriterion("app_sn is not null");
            return (Criteria) this;
        }

        public Criteria andApp_snEqualTo(String value) {
            addCriterion("app_sn =", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snNotEqualTo(String value) {
            addCriterion("app_sn <>", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snGreaterThan(String value) {
            addCriterion("app_sn >", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snGreaterThanOrEqualTo(String value) {
            addCriterion("app_sn >=", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snLessThan(String value) {
            addCriterion("app_sn <", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snLessThanOrEqualTo(String value) {
            addCriterion("app_sn <=", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snLike(String value) {
            addCriterion("app_sn like", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snNotLike(String value) {
            addCriterion("app_sn not like", value, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snIn(List<String> values) {
            addCriterion("app_sn in", values, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snNotIn(List<String> values) {
            addCriterion("app_sn not in", values, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snBetween(String value1, String value2) {
            addCriterion("app_sn between", value1, value2, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_snNotBetween(String value1, String value2) {
            addCriterion("app_sn not between", value1, value2, "app_sn");
            return (Criteria) this;
        }

        public Criteria andApp_nameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andApp_nameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andApp_nameEqualTo(String value) {
            addCriterion("app_name =", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameGreaterThan(String value) {
            addCriterion("app_name >", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameLessThan(String value) {
            addCriterion("app_name <", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameLike(String value) {
            addCriterion("app_name like", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameNotLike(String value) {
            addCriterion("app_name not like", value, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameIn(List<String> values) {
            addCriterion("app_name in", values, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_nameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "app_name");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyIsNull() {
            addCriterion("app_appkey is null");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyIsNotNull() {
            addCriterion("app_appkey is not null");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyEqualTo(String value) {
            addCriterion("app_appkey =", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyNotEqualTo(String value) {
            addCriterion("app_appkey <>", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyGreaterThan(String value) {
            addCriterion("app_appkey >", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_appkey >=", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyLessThan(String value) {
            addCriterion("app_appkey <", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyLessThanOrEqualTo(String value) {
            addCriterion("app_appkey <=", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyLike(String value) {
            addCriterion("app_appkey like", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyNotLike(String value) {
            addCriterion("app_appkey not like", value, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyIn(List<String> values) {
            addCriterion("app_appkey in", values, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyNotIn(List<String> values) {
            addCriterion("app_appkey not in", values, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyBetween(String value1, String value2) {
            addCriterion("app_appkey between", value1, value2, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_appkeyNotBetween(String value1, String value2) {
            addCriterion("app_appkey not between", value1, value2, "app_appkey");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretIsNull() {
            addCriterion("app_apisecret is null");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretIsNotNull() {
            addCriterion("app_apisecret is not null");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretEqualTo(String value) {
            addCriterion("app_apisecret =", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretNotEqualTo(String value) {
            addCriterion("app_apisecret <>", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretGreaterThan(String value) {
            addCriterion("app_apisecret >", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_apisecret >=", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretLessThan(String value) {
            addCriterion("app_apisecret <", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretLessThanOrEqualTo(String value) {
            addCriterion("app_apisecret <=", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretLike(String value) {
            addCriterion("app_apisecret like", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretNotLike(String value) {
            addCriterion("app_apisecret not like", value, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretIn(List<String> values) {
            addCriterion("app_apisecret in", values, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretNotIn(List<String> values) {
            addCriterion("app_apisecret not in", values, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretBetween(String value1, String value2) {
            addCriterion("app_apisecret between", value1, value2, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_apisecretNotBetween(String value1, String value2) {
            addCriterion("app_apisecret not between", value1, value2, "app_apisecret");
            return (Criteria) this;
        }

        public Criteria andApp_uuidIsNull() {
            addCriterion("app_uuid is null");
            return (Criteria) this;
        }

        public Criteria andApp_uuidIsNotNull() {
            addCriterion("app_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andApp_uuidEqualTo(String value) {
            addCriterion("app_uuid =", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidNotEqualTo(String value) {
            addCriterion("app_uuid <>", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidGreaterThan(String value) {
            addCriterion("app_uuid >", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidGreaterThanOrEqualTo(String value) {
            addCriterion("app_uuid >=", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidLessThan(String value) {
            addCriterion("app_uuid <", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidLessThanOrEqualTo(String value) {
            addCriterion("app_uuid <=", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidLike(String value) {
            addCriterion("app_uuid like", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidNotLike(String value) {
            addCriterion("app_uuid not like", value, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidIn(List<String> values) {
            addCriterion("app_uuid in", values, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidNotIn(List<String> values) {
            addCriterion("app_uuid not in", values, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidBetween(String value1, String value2) {
            addCriterion("app_uuid between", value1, value2, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_uuidNotBetween(String value1, String value2) {
            addCriterion("app_uuid not between", value1, value2, "app_uuid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidIsNull() {
            addCriterion("app_purchaseid is null");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidIsNotNull() {
            addCriterion("app_purchaseid is not null");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidEqualTo(String value) {
            addCriterion("app_purchaseid =", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidNotEqualTo(String value) {
            addCriterion("app_purchaseid <>", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidGreaterThan(String value) {
            addCriterion("app_purchaseid >", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidGreaterThanOrEqualTo(String value) {
            addCriterion("app_purchaseid >=", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidLessThan(String value) {
            addCriterion("app_purchaseid <", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidLessThanOrEqualTo(String value) {
            addCriterion("app_purchaseid <=", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidLike(String value) {
            addCriterion("app_purchaseid like", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidNotLike(String value) {
            addCriterion("app_purchaseid not like", value, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidIn(List<String> values) {
            addCriterion("app_purchaseid in", values, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidNotIn(List<String> values) {
            addCriterion("app_purchaseid not in", values, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidBetween(String value1, String value2) {
            addCriterion("app_purchaseid between", value1, value2, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_purchaseidNotBetween(String value1, String value2) {
            addCriterion("app_purchaseid not between", value1, value2, "app_purchaseid");
            return (Criteria) this;
        }

        public Criteria andApp_priceIsNull() {
            addCriterion("app_price is null");
            return (Criteria) this;
        }

        public Criteria andApp_priceIsNotNull() {
            addCriterion("app_price is not null");
            return (Criteria) this;
        }

        public Criteria andApp_priceEqualTo(BigDecimal value) {
            addCriterion("app_price =", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceNotEqualTo(BigDecimal value) {
            addCriterion("app_price <>", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceGreaterThan(BigDecimal value) {
            addCriterion("app_price >", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("app_price >=", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceLessThan(BigDecimal value) {
            addCriterion("app_price <", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("app_price <=", value, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceIn(List<BigDecimal> values) {
            addCriterion("app_price in", values, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceNotIn(List<BigDecimal> values) {
            addCriterion("app_price not in", values, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("app_price between", value1, value2, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("app_price not between", value1, value2, "app_price");
            return (Criteria) this;
        }

        public Criteria andApp_statusIsNull() {
            addCriterion("app_status is null");
            return (Criteria) this;
        }

        public Criteria andApp_statusIsNotNull() {
            addCriterion("app_status is not null");
            return (Criteria) this;
        }

        public Criteria andApp_statusEqualTo(Boolean value) {
            addCriterion("app_status =", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusNotEqualTo(Boolean value) {
            addCriterion("app_status <>", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusGreaterThan(Boolean value) {
            addCriterion("app_status >", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("app_status >=", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusLessThan(Boolean value) {
            addCriterion("app_status <", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusLessThanOrEqualTo(Boolean value) {
            addCriterion("app_status <=", value, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusIn(List<Boolean> values) {
            addCriterion("app_status in", values, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusNotIn(List<Boolean> values) {
            addCriterion("app_status not in", values, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusBetween(Boolean value1, Boolean value2) {
            addCriterion("app_status between", value1, value2, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_statusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("app_status not between", value1, value2, "app_status");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeIsNull() {
            addCriterion("app_addtime is null");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeIsNotNull() {
            addCriterion("app_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeEqualTo(Date value) {
            addCriterion("app_addtime =", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeNotEqualTo(Date value) {
            addCriterion("app_addtime <>", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeGreaterThan(Date value) {
            addCriterion("app_addtime >", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("app_addtime >=", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeLessThan(Date value) {
            addCriterion("app_addtime <", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeLessThanOrEqualTo(Date value) {
            addCriterion("app_addtime <=", value, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeIn(List<Date> values) {
            addCriterion("app_addtime in", values, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeNotIn(List<Date> values) {
            addCriterion("app_addtime not in", values, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeBetween(Date value1, Date value2) {
            addCriterion("app_addtime between", value1, value2, "app_addtime");
            return (Criteria) this;
        }

        public Criteria andApp_addtimeNotBetween(Date value1, Date value2) {
            addCriterion("app_addtime not between", value1, value2, "app_addtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}