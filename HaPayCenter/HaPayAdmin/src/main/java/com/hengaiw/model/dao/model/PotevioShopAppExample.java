package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PotevioShopAppExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PotevioShopAppExample() {
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

        public Criteria andShop_idIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShop_idIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShop_idEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idLessThan(Integer value) {
            addCriterion("shop_id <", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shop_id");
            return (Criteria) this;
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

        public Criteria andApp_begintimeIsNull() {
            addCriterion("app_begintime is null");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeIsNotNull() {
            addCriterion("app_begintime is not null");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeEqualTo(Integer value) {
            addCriterion("app_begintime =", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeNotEqualTo(Integer value) {
            addCriterion("app_begintime <>", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeGreaterThan(Integer value) {
            addCriterion("app_begintime >", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_begintime >=", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeLessThan(Integer value) {
            addCriterion("app_begintime <", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeLessThanOrEqualTo(Integer value) {
            addCriterion("app_begintime <=", value, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeIn(List<Integer> values) {
            addCriterion("app_begintime in", values, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeNotIn(List<Integer> values) {
            addCriterion("app_begintime not in", values, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeBetween(Integer value1, Integer value2) {
            addCriterion("app_begintime between", value1, value2, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_begintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_begintime not between", value1, value2, "app_begintime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeIsNull() {
            addCriterion("app_endtime is null");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeIsNotNull() {
            addCriterion("app_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeEqualTo(Integer value) {
            addCriterion("app_endtime =", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeNotEqualTo(Integer value) {
            addCriterion("app_endtime <>", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeGreaterThan(Integer value) {
            addCriterion("app_endtime >", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_endtime >=", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeLessThan(Integer value) {
            addCriterion("app_endtime <", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeLessThanOrEqualTo(Integer value) {
            addCriterion("app_endtime <=", value, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeIn(List<Integer> values) {
            addCriterion("app_endtime in", values, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeNotIn(List<Integer> values) {
            addCriterion("app_endtime not in", values, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeBetween(Integer value1, Integer value2) {
            addCriterion("app_endtime between", value1, value2, "app_endtime");
            return (Criteria) this;
        }

        public Criteria andApp_endtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_endtime not between", value1, value2, "app_endtime");
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