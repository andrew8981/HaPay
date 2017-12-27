package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PotevioOrderExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PotevioOrderExample() {
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

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_snIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrder_snIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_snEqualTo(String value) {
            addCriterion("order_sn =", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snGreaterThan(String value) {
            addCriterion("order_sn >", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLessThan(String value) {
            addCriterion("order_sn <", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLike(String value) {
            addCriterion("order_sn like", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotLike(String value) {
            addCriterion("order_sn not like", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snIn(List<String> values) {
            addCriterion("order_sn in", values, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "order_sn");
            return (Criteria) this;
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

        public Criteria andOrder_priceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrder_priceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_priceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "order_price");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(Boolean value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(Boolean value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(Boolean value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(Boolean value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(Boolean value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<Boolean> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<Boolean> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(Boolean value1, Boolean value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_payIsNull() {
            addCriterion("order_pay is null");
            return (Criteria) this;
        }

        public Criteria andOrder_payIsNotNull() {
            addCriterion("order_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_payEqualTo(Boolean value) {
            addCriterion("order_pay =", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payNotEqualTo(Boolean value) {
            addCriterion("order_pay <>", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payGreaterThan(Boolean value) {
            addCriterion("order_pay >", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_pay >=", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payLessThan(Boolean value) {
            addCriterion("order_pay <", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payLessThanOrEqualTo(Boolean value) {
            addCriterion("order_pay <=", value, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payIn(List<Boolean> values) {
            addCriterion("order_pay in", values, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payNotIn(List<Boolean> values) {
            addCriterion("order_pay not in", values, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payBetween(Boolean value1, Boolean value2) {
            addCriterion("order_pay between", value1, value2, "order_pay");
            return (Criteria) this;
        }

        public Criteria andOrder_payNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_pay not between", value1, value2, "order_pay");
            return (Criteria) this;
        }

        public Criteria andPay_snIsNull() {
            addCriterion("pay_sn is null");
            return (Criteria) this;
        }

        public Criteria andPay_snIsNotNull() {
            addCriterion("pay_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPay_snEqualTo(String value) {
            addCriterion("pay_sn =", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snNotEqualTo(String value) {
            addCriterion("pay_sn <>", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snGreaterThan(String value) {
            addCriterion("pay_sn >", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snGreaterThanOrEqualTo(String value) {
            addCriterion("pay_sn >=", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snLessThan(String value) {
            addCriterion("pay_sn <", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snLessThanOrEqualTo(String value) {
            addCriterion("pay_sn <=", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snLike(String value) {
            addCriterion("pay_sn like", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snNotLike(String value) {
            addCriterion("pay_sn not like", value, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snIn(List<String> values) {
            addCriterion("pay_sn in", values, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snNotIn(List<String> values) {
            addCriterion("pay_sn not in", values, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snBetween(String value1, String value2) {
            addCriterion("pay_sn between", value1, value2, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_snNotBetween(String value1, String value2) {
            addCriterion("pay_sn not between", value1, value2, "pay_sn");
            return (Criteria) this;
        }

        public Criteria andPay_timeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPay_timeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPay_timeEqualTo(Integer value) {
            addCriterion("pay_time =", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotEqualTo(Integer value) {
            addCriterion("pay_time <>", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeGreaterThan(Integer value) {
            addCriterion("pay_time >", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_time >=", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeLessThan(Integer value) {
            addCriterion("pay_time <", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_time <=", value, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeIn(List<Integer> values) {
            addCriterion("pay_time in", values, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotIn(List<Integer> values) {
            addCriterion("pay_time not in", values, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeBetween(Integer value1, Integer value2) {
            addCriterion("pay_time between", value1, value2, "pay_time");
            return (Criteria) this;
        }

        public Criteria andPay_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_time not between", value1, value2, "pay_time");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeIsNull() {
            addCriterion("order_addtime is null");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeIsNotNull() {
            addCriterion("order_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeEqualTo(Date value) {
            addCriterion("order_addtime =", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeNotEqualTo(Date value) {
            addCriterion("order_addtime <>", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeGreaterThan(Date value) {
            addCriterion("order_addtime >", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_addtime >=", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeLessThan(Date value) {
            addCriterion("order_addtime <", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeLessThanOrEqualTo(Date value) {
            addCriterion("order_addtime <=", value, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeIn(List<Date> values) {
            addCriterion("order_addtime in", values, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeNotIn(List<Date> values) {
            addCriterion("order_addtime not in", values, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeBetween(Date value1, Date value2) {
            addCriterion("order_addtime between", value1, value2, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_addtimeNotBetween(Date value1, Date value2) {
            addCriterion("order_addtime not between", value1, value2, "order_addtime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeIsNull() {
            addCriterion("order_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeIsNotNull() {
            addCriterion("order_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeEqualTo(Date value) {
            addCriterion("order_updatetime =", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeNotEqualTo(Date value) {
            addCriterion("order_updatetime <>", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeGreaterThan(Date value) {
            addCriterion("order_updatetime >", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_updatetime >=", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeLessThan(Date value) {
            addCriterion("order_updatetime <", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeLessThanOrEqualTo(Date value) {
            addCriterion("order_updatetime <=", value, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeIn(List<Date> values) {
            addCriterion("order_updatetime in", values, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeNotIn(List<Date> values) {
            addCriterion("order_updatetime not in", values, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeBetween(Date value1, Date value2) {
            addCriterion("order_updatetime between", value1, value2, "order_updatetime");
            return (Criteria) this;
        }

        public Criteria andOrder_updatetimeNotBetween(Date value1, Date value2) {
            addCriterion("order_updatetime not between", value1, value2, "order_updatetime");
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