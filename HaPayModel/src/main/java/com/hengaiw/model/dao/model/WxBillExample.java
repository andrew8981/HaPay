package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxBillExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public WxBillExample() {
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

        public Criteria andTradetimeIsNull() {
            addCriterion("tradetime is null");
            return (Criteria) this;
        }

        public Criteria andTradetimeIsNotNull() {
            addCriterion("tradetime is not null");
            return (Criteria) this;
        }

        public Criteria andTradetimeEqualTo(String value) {
            addCriterion("tradetime =", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotEqualTo(String value) {
            addCriterion("tradetime <>", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThan(String value) {
            addCriterion("tradetime >", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThanOrEqualTo(String value) {
            addCriterion("tradetime >=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThan(String value) {
            addCriterion("tradetime <", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThanOrEqualTo(String value) {
            addCriterion("tradetime <=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLike(String value) {
            addCriterion("tradetime like", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotLike(String value) {
            addCriterion("tradetime not like", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeIn(List<String> values) {
            addCriterion("tradetime in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotIn(List<String> values) {
            addCriterion("tradetime not in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeBetween(String value1, String value2) {
            addCriterion("tradetime between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotBetween(String value1, String value2) {
            addCriterion("tradetime not between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andGhidIsNull() {
            addCriterion("ghid is null");
            return (Criteria) this;
        }

        public Criteria andGhidIsNotNull() {
            addCriterion("ghid is not null");
            return (Criteria) this;
        }

        public Criteria andGhidEqualTo(String value) {
            addCriterion("ghid =", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotEqualTo(String value) {
            addCriterion("ghid <>", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidGreaterThan(String value) {
            addCriterion("ghid >", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidGreaterThanOrEqualTo(String value) {
            addCriterion("ghid >=", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidLessThan(String value) {
            addCriterion("ghid <", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidLessThanOrEqualTo(String value) {
            addCriterion("ghid <=", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidLike(String value) {
            addCriterion("ghid like", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotLike(String value) {
            addCriterion("ghid not like", value, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidIn(List<String> values) {
            addCriterion("ghid in", values, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotIn(List<String> values) {
            addCriterion("ghid not in", values, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidBetween(String value1, String value2) {
            addCriterion("ghid between", value1, value2, "ghid");
            return (Criteria) this;
        }

        public Criteria andGhidNotBetween(String value1, String value2) {
            addCriterion("ghid not between", value1, value2, "ghid");
            return (Criteria) this;
        }

        public Criteria andMchidIsNull() {
            addCriterion("mchid is null");
            return (Criteria) this;
        }

        public Criteria andMchidIsNotNull() {
            addCriterion("mchid is not null");
            return (Criteria) this;
        }

        public Criteria andMchidEqualTo(String value) {
            addCriterion("mchid =", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotEqualTo(String value) {
            addCriterion("mchid <>", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThan(String value) {
            addCriterion("mchid >", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidGreaterThanOrEqualTo(String value) {
            addCriterion("mchid >=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThan(String value) {
            addCriterion("mchid <", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLessThanOrEqualTo(String value) {
            addCriterion("mchid <=", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidLike(String value) {
            addCriterion("mchid like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotLike(String value) {
            addCriterion("mchid not like", value, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidIn(List<String> values) {
            addCriterion("mchid in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotIn(List<String> values) {
            addCriterion("mchid not in", values, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidBetween(String value1, String value2) {
            addCriterion("mchid between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andMchidNotBetween(String value1, String value2) {
            addCriterion("mchid not between", value1, value2, "mchid");
            return (Criteria) this;
        }

        public Criteria andSubmchIsNull() {
            addCriterion("submch is null");
            return (Criteria) this;
        }

        public Criteria andSubmchIsNotNull() {
            addCriterion("submch is not null");
            return (Criteria) this;
        }

        public Criteria andSubmchEqualTo(String value) {
            addCriterion("submch =", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchNotEqualTo(String value) {
            addCriterion("submch <>", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchGreaterThan(String value) {
            addCriterion("submch >", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchGreaterThanOrEqualTo(String value) {
            addCriterion("submch >=", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchLessThan(String value) {
            addCriterion("submch <", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchLessThanOrEqualTo(String value) {
            addCriterion("submch <=", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchLike(String value) {
            addCriterion("submch like", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchNotLike(String value) {
            addCriterion("submch not like", value, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchIn(List<String> values) {
            addCriterion("submch in", values, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchNotIn(List<String> values) {
            addCriterion("submch not in", values, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchBetween(String value1, String value2) {
            addCriterion("submch between", value1, value2, "submch");
            return (Criteria) this;
        }

        public Criteria andSubmchNotBetween(String value1, String value2) {
            addCriterion("submch not between", value1, value2, "submch");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(String value) {
            addCriterion("deviceid =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(String value) {
            addCriterion("deviceid <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(String value) {
            addCriterion("deviceid >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(String value) {
            addCriterion("deviceid >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(String value) {
            addCriterion("deviceid <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(String value) {
            addCriterion("deviceid <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLike(String value) {
            addCriterion("deviceid like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotLike(String value) {
            addCriterion("deviceid not like", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<String> values) {
            addCriterion("deviceid in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<String> values) {
            addCriterion("deviceid not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(String value1, String value2) {
            addCriterion("deviceid between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(String value1, String value2) {
            addCriterion("deviceid not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andWxorderIsNull() {
            addCriterion("wxorder is null");
            return (Criteria) this;
        }

        public Criteria andWxorderIsNotNull() {
            addCriterion("wxorder is not null");
            return (Criteria) this;
        }

        public Criteria andWxorderEqualTo(String value) {
            addCriterion("wxorder =", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderNotEqualTo(String value) {
            addCriterion("wxorder <>", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderGreaterThan(String value) {
            addCriterion("wxorder >", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderGreaterThanOrEqualTo(String value) {
            addCriterion("wxorder >=", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderLessThan(String value) {
            addCriterion("wxorder <", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderLessThanOrEqualTo(String value) {
            addCriterion("wxorder <=", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderLike(String value) {
            addCriterion("wxorder like", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderNotLike(String value) {
            addCriterion("wxorder not like", value, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderIn(List<String> values) {
            addCriterion("wxorder in", values, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderNotIn(List<String> values) {
            addCriterion("wxorder not in", values, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderBetween(String value1, String value2) {
            addCriterion("wxorder between", value1, value2, "wxorder");
            return (Criteria) this;
        }

        public Criteria andWxorderNotBetween(String value1, String value2) {
            addCriterion("wxorder not between", value1, value2, "wxorder");
            return (Criteria) this;
        }

        public Criteria andBzorderIsNull() {
            addCriterion("bzorder is null");
            return (Criteria) this;
        }

        public Criteria andBzorderIsNotNull() {
            addCriterion("bzorder is not null");
            return (Criteria) this;
        }

        public Criteria andBzorderEqualTo(String value) {
            addCriterion("bzorder =", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderNotEqualTo(String value) {
            addCriterion("bzorder <>", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderGreaterThan(String value) {
            addCriterion("bzorder >", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderGreaterThanOrEqualTo(String value) {
            addCriterion("bzorder >=", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderLessThan(String value) {
            addCriterion("bzorder <", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderLessThanOrEqualTo(String value) {
            addCriterion("bzorder <=", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderLike(String value) {
            addCriterion("bzorder like", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderNotLike(String value) {
            addCriterion("bzorder not like", value, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderIn(List<String> values) {
            addCriterion("bzorder in", values, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderNotIn(List<String> values) {
            addCriterion("bzorder not in", values, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderBetween(String value1, String value2) {
            addCriterion("bzorder between", value1, value2, "bzorder");
            return (Criteria) this;
        }

        public Criteria andBzorderNotBetween(String value1, String value2) {
            addCriterion("bzorder not between", value1, value2, "bzorder");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andTradetypeIsNull() {
            addCriterion("tradetype is null");
            return (Criteria) this;
        }

        public Criteria andTradetypeIsNotNull() {
            addCriterion("tradetype is not null");
            return (Criteria) this;
        }

        public Criteria andTradetypeEqualTo(String value) {
            addCriterion("tradetype =", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotEqualTo(String value) {
            addCriterion("tradetype <>", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThan(String value) {
            addCriterion("tradetype >", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThanOrEqualTo(String value) {
            addCriterion("tradetype >=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThan(String value) {
            addCriterion("tradetype <", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThanOrEqualTo(String value) {
            addCriterion("tradetype <=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLike(String value) {
            addCriterion("tradetype like", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotLike(String value) {
            addCriterion("tradetype not like", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeIn(List<String> values) {
            addCriterion("tradetype in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotIn(List<String> values) {
            addCriterion("tradetype not in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeBetween(String value1, String value2) {
            addCriterion("tradetype between", value1, value2, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotBetween(String value1, String value2) {
            addCriterion("tradetype not between", value1, value2, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradestatusIsNull() {
            addCriterion("tradestatus is null");
            return (Criteria) this;
        }

        public Criteria andTradestatusIsNotNull() {
            addCriterion("tradestatus is not null");
            return (Criteria) this;
        }

        public Criteria andTradestatusEqualTo(String value) {
            addCriterion("tradestatus =", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusNotEqualTo(String value) {
            addCriterion("tradestatus <>", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusGreaterThan(String value) {
            addCriterion("tradestatus >", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusGreaterThanOrEqualTo(String value) {
            addCriterion("tradestatus >=", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusLessThan(String value) {
            addCriterion("tradestatus <", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusLessThanOrEqualTo(String value) {
            addCriterion("tradestatus <=", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusLike(String value) {
            addCriterion("tradestatus like", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusNotLike(String value) {
            addCriterion("tradestatus not like", value, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusIn(List<String> values) {
            addCriterion("tradestatus in", values, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusNotIn(List<String> values) {
            addCriterion("tradestatus not in", values, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusBetween(String value1, String value2) {
            addCriterion("tradestatus between", value1, value2, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andTradestatusNotBetween(String value1, String value2) {
            addCriterion("tradestatus not between", value1, value2, "tradestatus");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalmoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalmoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(String value) {
            addCriterion("totalmoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(String value) {
            addCriterion("totalmoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(String value) {
            addCriterion("totalmoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("totalmoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(String value) {
            addCriterion("totalmoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(String value) {
            addCriterion("totalmoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLike(String value) {
            addCriterion("totalmoney like", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotLike(String value) {
            addCriterion("totalmoney not like", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<String> values) {
            addCriterion("totalmoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<String> values) {
            addCriterion("totalmoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(String value1, String value2) {
            addCriterion("totalmoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(String value1, String value2) {
            addCriterion("totalmoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyIsNull() {
            addCriterion("redpacketmoney is null");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyIsNotNull() {
            addCriterion("redpacketmoney is not null");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyEqualTo(String value) {
            addCriterion("redpacketmoney =", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyNotEqualTo(String value) {
            addCriterion("redpacketmoney <>", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyGreaterThan(String value) {
            addCriterion("redpacketmoney >", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("redpacketmoney >=", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyLessThan(String value) {
            addCriterion("redpacketmoney <", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyLessThanOrEqualTo(String value) {
            addCriterion("redpacketmoney <=", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyLike(String value) {
            addCriterion("redpacketmoney like", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyNotLike(String value) {
            addCriterion("redpacketmoney not like", value, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyIn(List<String> values) {
            addCriterion("redpacketmoney in", values, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyNotIn(List<String> values) {
            addCriterion("redpacketmoney not in", values, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyBetween(String value1, String value2) {
            addCriterion("redpacketmoney between", value1, value2, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketmoneyNotBetween(String value1, String value2) {
            addCriterion("redpacketmoney not between", value1, value2, "redpacketmoney");
            return (Criteria) this;
        }

        public Criteria andWxrefundIsNull() {
            addCriterion("wxrefund is null");
            return (Criteria) this;
        }

        public Criteria andWxrefundIsNotNull() {
            addCriterion("wxrefund is not null");
            return (Criteria) this;
        }

        public Criteria andWxrefundEqualTo(String value) {
            addCriterion("wxrefund =", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundNotEqualTo(String value) {
            addCriterion("wxrefund <>", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundGreaterThan(String value) {
            addCriterion("wxrefund >", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundGreaterThanOrEqualTo(String value) {
            addCriterion("wxrefund >=", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundLessThan(String value) {
            addCriterion("wxrefund <", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundLessThanOrEqualTo(String value) {
            addCriterion("wxrefund <=", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundLike(String value) {
            addCriterion("wxrefund like", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundNotLike(String value) {
            addCriterion("wxrefund not like", value, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundIn(List<String> values) {
            addCriterion("wxrefund in", values, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundNotIn(List<String> values) {
            addCriterion("wxrefund not in", values, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundBetween(String value1, String value2) {
            addCriterion("wxrefund between", value1, value2, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andWxrefundNotBetween(String value1, String value2) {
            addCriterion("wxrefund not between", value1, value2, "wxrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundIsNull() {
            addCriterion("bzrefund is null");
            return (Criteria) this;
        }

        public Criteria andBzrefundIsNotNull() {
            addCriterion("bzrefund is not null");
            return (Criteria) this;
        }

        public Criteria andBzrefundEqualTo(String value) {
            addCriterion("bzrefund =", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundNotEqualTo(String value) {
            addCriterion("bzrefund <>", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundGreaterThan(String value) {
            addCriterion("bzrefund >", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundGreaterThanOrEqualTo(String value) {
            addCriterion("bzrefund >=", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundLessThan(String value) {
            addCriterion("bzrefund <", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundLessThanOrEqualTo(String value) {
            addCriterion("bzrefund <=", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundLike(String value) {
            addCriterion("bzrefund like", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundNotLike(String value) {
            addCriterion("bzrefund not like", value, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundIn(List<String> values) {
            addCriterion("bzrefund in", values, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundNotIn(List<String> values) {
            addCriterion("bzrefund not in", values, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundBetween(String value1, String value2) {
            addCriterion("bzrefund between", value1, value2, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andBzrefundNotBetween(String value1, String value2) {
            addCriterion("bzrefund not between", value1, value2, "bzrefund");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyIsNull() {
            addCriterion("refundmoney is null");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyIsNotNull() {
            addCriterion("refundmoney is not null");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyEqualTo(String value) {
            addCriterion("refundmoney =", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyNotEqualTo(String value) {
            addCriterion("refundmoney <>", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyGreaterThan(String value) {
            addCriterion("refundmoney >", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("refundmoney >=", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyLessThan(String value) {
            addCriterion("refundmoney <", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyLessThanOrEqualTo(String value) {
            addCriterion("refundmoney <=", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyLike(String value) {
            addCriterion("refundmoney like", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyNotLike(String value) {
            addCriterion("refundmoney not like", value, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyIn(List<String> values) {
            addCriterion("refundmoney in", values, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyNotIn(List<String> values) {
            addCriterion("refundmoney not in", values, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyBetween(String value1, String value2) {
            addCriterion("refundmoney between", value1, value2, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRefundmoneyNotBetween(String value1, String value2) {
            addCriterion("refundmoney not between", value1, value2, "refundmoney");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundIsNull() {
            addCriterion("redpacketrefund is null");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundIsNotNull() {
            addCriterion("redpacketrefund is not null");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundEqualTo(String value) {
            addCriterion("redpacketrefund =", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundNotEqualTo(String value) {
            addCriterion("redpacketrefund <>", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundGreaterThan(String value) {
            addCriterion("redpacketrefund >", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundGreaterThanOrEqualTo(String value) {
            addCriterion("redpacketrefund >=", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundLessThan(String value) {
            addCriterion("redpacketrefund <", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundLessThanOrEqualTo(String value) {
            addCriterion("redpacketrefund <=", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundLike(String value) {
            addCriterion("redpacketrefund like", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundNotLike(String value) {
            addCriterion("redpacketrefund not like", value, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundIn(List<String> values) {
            addCriterion("redpacketrefund in", values, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundNotIn(List<String> values) {
            addCriterion("redpacketrefund not in", values, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundBetween(String value1, String value2) {
            addCriterion("redpacketrefund between", value1, value2, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRedpacketrefundNotBetween(String value1, String value2) {
            addCriterion("redpacketrefund not between", value1, value2, "redpacketrefund");
            return (Criteria) this;
        }

        public Criteria andRefundtypeIsNull() {
            addCriterion("refundtype is null");
            return (Criteria) this;
        }

        public Criteria andRefundtypeIsNotNull() {
            addCriterion("refundtype is not null");
            return (Criteria) this;
        }

        public Criteria andRefundtypeEqualTo(String value) {
            addCriterion("refundtype =", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeNotEqualTo(String value) {
            addCriterion("refundtype <>", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeGreaterThan(String value) {
            addCriterion("refundtype >", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeGreaterThanOrEqualTo(String value) {
            addCriterion("refundtype >=", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeLessThan(String value) {
            addCriterion("refundtype <", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeLessThanOrEqualTo(String value) {
            addCriterion("refundtype <=", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeLike(String value) {
            addCriterion("refundtype like", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeNotLike(String value) {
            addCriterion("refundtype not like", value, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeIn(List<String> values) {
            addCriterion("refundtype in", values, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeNotIn(List<String> values) {
            addCriterion("refundtype not in", values, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeBetween(String value1, String value2) {
            addCriterion("refundtype between", value1, value2, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundtypeNotBetween(String value1, String value2) {
            addCriterion("refundtype not between", value1, value2, "refundtype");
            return (Criteria) this;
        }

        public Criteria andRefundstatusIsNull() {
            addCriterion("refundstatus is null");
            return (Criteria) this;
        }

        public Criteria andRefundstatusIsNotNull() {
            addCriterion("refundstatus is not null");
            return (Criteria) this;
        }

        public Criteria andRefundstatusEqualTo(String value) {
            addCriterion("refundstatus =", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusNotEqualTo(String value) {
            addCriterion("refundstatus <>", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusGreaterThan(String value) {
            addCriterion("refundstatus >", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusGreaterThanOrEqualTo(String value) {
            addCriterion("refundstatus >=", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusLessThan(String value) {
            addCriterion("refundstatus <", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusLessThanOrEqualTo(String value) {
            addCriterion("refundstatus <=", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusLike(String value) {
            addCriterion("refundstatus like", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusNotLike(String value) {
            addCriterion("refundstatus not like", value, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusIn(List<String> values) {
            addCriterion("refundstatus in", values, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusNotIn(List<String> values) {
            addCriterion("refundstatus not in", values, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusBetween(String value1, String value2) {
            addCriterion("refundstatus between", value1, value2, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andRefundstatusNotBetween(String value1, String value2) {
            addCriterion("refundstatus not between", value1, value2, "refundstatus");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productname is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productname is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productname =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productname <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productname >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productname >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productname <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productname <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productname like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productname not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productname in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productname not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productname between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productname not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketIsNull() {
            addCriterion("bzdatapacket is null");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketIsNotNull() {
            addCriterion("bzdatapacket is not null");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketEqualTo(String value) {
            addCriterion("bzdatapacket =", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketNotEqualTo(String value) {
            addCriterion("bzdatapacket <>", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketGreaterThan(String value) {
            addCriterion("bzdatapacket >", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketGreaterThanOrEqualTo(String value) {
            addCriterion("bzdatapacket >=", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketLessThan(String value) {
            addCriterion("bzdatapacket <", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketLessThanOrEqualTo(String value) {
            addCriterion("bzdatapacket <=", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketLike(String value) {
            addCriterion("bzdatapacket like", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketNotLike(String value) {
            addCriterion("bzdatapacket not like", value, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketIn(List<String> values) {
            addCriterion("bzdatapacket in", values, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketNotIn(List<String> values) {
            addCriterion("bzdatapacket not in", values, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketBetween(String value1, String value2) {
            addCriterion("bzdatapacket between", value1, value2, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andBzdatapacketNotBetween(String value1, String value2) {
            addCriterion("bzdatapacket not between", value1, value2, "bzdatapacket");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(String value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(String value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(String value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(String value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(String value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(String value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLike(String value) {
            addCriterion("fee like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotLike(String value) {
            addCriterion("fee not like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<String> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<String> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(String value1, String value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(String value1, String value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
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