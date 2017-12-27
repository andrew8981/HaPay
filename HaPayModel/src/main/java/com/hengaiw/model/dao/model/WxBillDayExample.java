package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxBillDayExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public WxBillDayExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTotal_orderIsNull() {
            addCriterion("total_order is null");
            return (Criteria) this;
        }

        public Criteria andTotal_orderIsNotNull() {
            addCriterion("total_order is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_orderEqualTo(String value) {
            addCriterion("total_order =", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderNotEqualTo(String value) {
            addCriterion("total_order <>", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderGreaterThan(String value) {
            addCriterion("total_order >", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderGreaterThanOrEqualTo(String value) {
            addCriterion("total_order >=", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderLessThan(String value) {
            addCriterion("total_order <", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderLessThanOrEqualTo(String value) {
            addCriterion("total_order <=", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderLike(String value) {
            addCriterion("total_order like", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderNotLike(String value) {
            addCriterion("total_order not like", value, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderIn(List<String> values) {
            addCriterion("total_order in", values, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderNotIn(List<String> values) {
            addCriterion("total_order not in", values, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderBetween(String value1, String value2) {
            addCriterion("total_order between", value1, value2, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_orderNotBetween(String value1, String value2) {
            addCriterion("total_order not between", value1, value2, "total_order");
            return (Criteria) this;
        }

        public Criteria andTotal_payIsNull() {
            addCriterion("total_pay is null");
            return (Criteria) this;
        }

        public Criteria andTotal_payIsNotNull() {
            addCriterion("total_pay is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_payEqualTo(String value) {
            addCriterion("total_pay =", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payNotEqualTo(String value) {
            addCriterion("total_pay <>", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payGreaterThan(String value) {
            addCriterion("total_pay >", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payGreaterThanOrEqualTo(String value) {
            addCriterion("total_pay >=", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payLessThan(String value) {
            addCriterion("total_pay <", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payLessThanOrEqualTo(String value) {
            addCriterion("total_pay <=", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payLike(String value) {
            addCriterion("total_pay like", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payNotLike(String value) {
            addCriterion("total_pay not like", value, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payIn(List<String> values) {
            addCriterion("total_pay in", values, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payNotIn(List<String> values) {
            addCriterion("total_pay not in", values, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payBetween(String value1, String value2) {
            addCriterion("total_pay between", value1, value2, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_payNotBetween(String value1, String value2) {
            addCriterion("total_pay not between", value1, value2, "total_pay");
            return (Criteria) this;
        }

        public Criteria andTotal_refundIsNull() {
            addCriterion("total_refund is null");
            return (Criteria) this;
        }

        public Criteria andTotal_refundIsNotNull() {
            addCriterion("total_refund is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_refundEqualTo(String value) {
            addCriterion("total_refund =", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundNotEqualTo(String value) {
            addCriterion("total_refund <>", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundGreaterThan(String value) {
            addCriterion("total_refund >", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundGreaterThanOrEqualTo(String value) {
            addCriterion("total_refund >=", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundLessThan(String value) {
            addCriterion("total_refund <", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundLessThanOrEqualTo(String value) {
            addCriterion("total_refund <=", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundLike(String value) {
            addCriterion("total_refund like", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundNotLike(String value) {
            addCriterion("total_refund not like", value, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundIn(List<String> values) {
            addCriterion("total_refund in", values, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundNotIn(List<String> values) {
            addCriterion("total_refund not in", values, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundBetween(String value1, String value2) {
            addCriterion("total_refund between", value1, value2, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_refundNotBetween(String value1, String value2) {
            addCriterion("total_refund not between", value1, value2, "total_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundIsNull() {
            addCriterion("total_company_refund is null");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundIsNotNull() {
            addCriterion("total_company_refund is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundEqualTo(String value) {
            addCriterion("total_company_refund =", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundNotEqualTo(String value) {
            addCriterion("total_company_refund <>", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundGreaterThan(String value) {
            addCriterion("total_company_refund >", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundGreaterThanOrEqualTo(String value) {
            addCriterion("total_company_refund >=", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundLessThan(String value) {
            addCriterion("total_company_refund <", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundLessThanOrEqualTo(String value) {
            addCriterion("total_company_refund <=", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundLike(String value) {
            addCriterion("total_company_refund like", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundNotLike(String value) {
            addCriterion("total_company_refund not like", value, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundIn(List<String> values) {
            addCriterion("total_company_refund in", values, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundNotIn(List<String> values) {
            addCriterion("total_company_refund not in", values, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundBetween(String value1, String value2) {
            addCriterion("total_company_refund between", value1, value2, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_company_refundNotBetween(String value1, String value2) {
            addCriterion("total_company_refund not between", value1, value2, "total_company_refund");
            return (Criteria) this;
        }

        public Criteria andTotal_feeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotal_feeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_feeEqualTo(String value) {
            addCriterion("total_fee =", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeNotEqualTo(String value) {
            addCriterion("total_fee <>", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeGreaterThan(String value) {
            addCriterion("total_fee >", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeGreaterThanOrEqualTo(String value) {
            addCriterion("total_fee >=", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeLessThan(String value) {
            addCriterion("total_fee <", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeLessThanOrEqualTo(String value) {
            addCriterion("total_fee <=", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeLike(String value) {
            addCriterion("total_fee like", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeNotLike(String value) {
            addCriterion("total_fee not like", value, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeIn(List<String> values) {
            addCriterion("total_fee in", values, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeNotIn(List<String> values) {
            addCriterion("total_fee not in", values, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeBetween(String value1, String value2) {
            addCriterion("total_fee between", value1, value2, "total_fee");
            return (Criteria) this;
        }

        public Criteria andTotal_feeNotBetween(String value1, String value2) {
            addCriterion("total_fee not between", value1, value2, "total_fee");
            return (Criteria) this;
        }

        public Criteria andBill_dateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBill_dateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBill_dateEqualTo(String value) {
            addCriterion("bill_date =", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateNotEqualTo(String value) {
            addCriterion("bill_date <>", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateGreaterThan(String value) {
            addCriterion("bill_date >", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateGreaterThanOrEqualTo(String value) {
            addCriterion("bill_date >=", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateLessThan(String value) {
            addCriterion("bill_date <", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateLessThanOrEqualTo(String value) {
            addCriterion("bill_date <=", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateLike(String value) {
            addCriterion("bill_date like", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateNotLike(String value) {
            addCriterion("bill_date not like", value, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateIn(List<String> values) {
            addCriterion("bill_date in", values, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateNotIn(List<String> values) {
            addCriterion("bill_date not in", values, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateBetween(String value1, String value2) {
            addCriterion("bill_date between", value1, value2, "bill_date");
            return (Criteria) this;
        }

        public Criteria andBill_dateNotBetween(String value1, String value2) {
            addCriterion("bill_date not between", value1, value2, "bill_date");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mchId is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mchId is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mchId =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mchId <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mchId >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mchId >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mchId <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mchId <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mchId like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mchId not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mchId in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mchId not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mchId between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mchId not between", value1, value2, "mchId");
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