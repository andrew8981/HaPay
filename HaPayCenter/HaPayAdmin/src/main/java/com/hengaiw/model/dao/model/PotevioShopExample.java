package com.hengaiw.model.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PotevioShopExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PotevioShopExample() {
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

        public Criteria andShop_phoneIsNull() {
            addCriterion("shop_phone is null");
            return (Criteria) this;
        }

        public Criteria andShop_phoneIsNotNull() {
            addCriterion("shop_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShop_phoneEqualTo(String value) {
            addCriterion("shop_phone =", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneNotEqualTo(String value) {
            addCriterion("shop_phone <>", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneGreaterThan(String value) {
            addCriterion("shop_phone >", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("shop_phone >=", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneLessThan(String value) {
            addCriterion("shop_phone <", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneLessThanOrEqualTo(String value) {
            addCriterion("shop_phone <=", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneLike(String value) {
            addCriterion("shop_phone like", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneNotLike(String value) {
            addCriterion("shop_phone not like", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneIn(List<String> values) {
            addCriterion("shop_phone in", values, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneNotIn(List<String> values) {
            addCriterion("shop_phone not in", values, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneBetween(String value1, String value2) {
            addCriterion("shop_phone between", value1, value2, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_phoneNotBetween(String value1, String value2) {
            addCriterion("shop_phone not between", value1, value2, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShop_passwdIsNull() {
            addCriterion("shop_passwd is null");
            return (Criteria) this;
        }

        public Criteria andShop_passwdIsNotNull() {
            addCriterion("shop_passwd is not null");
            return (Criteria) this;
        }

        public Criteria andShop_passwdEqualTo(String value) {
            addCriterion("shop_passwd =", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdNotEqualTo(String value) {
            addCriterion("shop_passwd <>", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdGreaterThan(String value) {
            addCriterion("shop_passwd >", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_passwd >=", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdLessThan(String value) {
            addCriterion("shop_passwd <", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdLessThanOrEqualTo(String value) {
            addCriterion("shop_passwd <=", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdLike(String value) {
            addCriterion("shop_passwd like", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdNotLike(String value) {
            addCriterion("shop_passwd not like", value, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdIn(List<String> values) {
            addCriterion("shop_passwd in", values, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdNotIn(List<String> values) {
            addCriterion("shop_passwd not in", values, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdBetween(String value1, String value2) {
            addCriterion("shop_passwd between", value1, value2, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_passwdNotBetween(String value1, String value2) {
            addCriterion("shop_passwd not between", value1, value2, "shop_passwd");
            return (Criteria) this;
        }

        public Criteria andShop_baseidIsNull() {
            addCriterion("shop_baseid is null");
            return (Criteria) this;
        }

        public Criteria andShop_baseidIsNotNull() {
            addCriterion("shop_baseid is not null");
            return (Criteria) this;
        }

        public Criteria andShop_baseidEqualTo(String value) {
            addCriterion("shop_baseid =", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidNotEqualTo(String value) {
            addCriterion("shop_baseid <>", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidGreaterThan(String value) {
            addCriterion("shop_baseid >", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidGreaterThanOrEqualTo(String value) {
            addCriterion("shop_baseid >=", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidLessThan(String value) {
            addCriterion("shop_baseid <", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidLessThanOrEqualTo(String value) {
            addCriterion("shop_baseid <=", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidLike(String value) {
            addCriterion("shop_baseid like", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidNotLike(String value) {
            addCriterion("shop_baseid not like", value, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidIn(List<String> values) {
            addCriterion("shop_baseid in", values, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidNotIn(List<String> values) {
            addCriterion("shop_baseid not in", values, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidBetween(String value1, String value2) {
            addCriterion("shop_baseid between", value1, value2, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_baseidNotBetween(String value1, String value2) {
            addCriterion("shop_baseid not between", value1, value2, "shop_baseid");
            return (Criteria) this;
        }

        public Criteria andShop_nameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShop_nameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShop_nameEqualTo(String value) {
            addCriterion("shop_name =", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLessThan(String value) {
            addCriterion("shop_name <", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLike(String value) {
            addCriterion("shop_name like", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotLike(String value) {
            addCriterion("shop_name not like", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameIn(List<String> values) {
            addCriterion("shop_name in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanIsNull() {
            addCriterion("shop_linkman is null");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanIsNotNull() {
            addCriterion("shop_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanEqualTo(String value) {
            addCriterion("shop_linkman =", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanNotEqualTo(String value) {
            addCriterion("shop_linkman <>", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanGreaterThan(String value) {
            addCriterion("shop_linkman >", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanGreaterThanOrEqualTo(String value) {
            addCriterion("shop_linkman >=", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanLessThan(String value) {
            addCriterion("shop_linkman <", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanLessThanOrEqualTo(String value) {
            addCriterion("shop_linkman <=", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanLike(String value) {
            addCriterion("shop_linkman like", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanNotLike(String value) {
            addCriterion("shop_linkman not like", value, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanIn(List<String> values) {
            addCriterion("shop_linkman in", values, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanNotIn(List<String> values) {
            addCriterion("shop_linkman not in", values, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanBetween(String value1, String value2) {
            addCriterion("shop_linkman between", value1, value2, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_linkmanNotBetween(String value1, String value2) {
            addCriterion("shop_linkman not between", value1, value2, "shop_linkman");
            return (Criteria) this;
        }

        public Criteria andShop_addressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShop_addressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShop_addressEqualTo(String value) {
            addCriterion("shop_address =", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLessThan(String value) {
            addCriterion("shop_address <", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLike(String value) {
            addCriterion("shop_address like", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotLike(String value) {
            addCriterion("shop_address not like", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressIn(List<String> values) {
            addCriterion("shop_address in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeIsNull() {
            addCriterion("shop_businesstype is null");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeIsNotNull() {
            addCriterion("shop_businesstype is not null");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeEqualTo(String value) {
            addCriterion("shop_businesstype =", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeNotEqualTo(String value) {
            addCriterion("shop_businesstype <>", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeGreaterThan(String value) {
            addCriterion("shop_businesstype >", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_businesstype >=", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeLessThan(String value) {
            addCriterion("shop_businesstype <", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeLessThanOrEqualTo(String value) {
            addCriterion("shop_businesstype <=", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeLike(String value) {
            addCriterion("shop_businesstype like", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeNotLike(String value) {
            addCriterion("shop_businesstype not like", value, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeIn(List<String> values) {
            addCriterion("shop_businesstype in", values, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeNotIn(List<String> values) {
            addCriterion("shop_businesstype not in", values, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeBetween(String value1, String value2) {
            addCriterion("shop_businesstype between", value1, value2, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_businesstypeNotBetween(String value1, String value2) {
            addCriterion("shop_businesstype not between", value1, value2, "shop_businesstype");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeIsNull() {
            addCriterion("shop_typeCode is null");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeIsNotNull() {
            addCriterion("shop_typeCode is not null");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeEqualTo(String value) {
            addCriterion("shop_typeCode =", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeNotEqualTo(String value) {
            addCriterion("shop_typeCode <>", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeGreaterThan(String value) {
            addCriterion("shop_typeCode >", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_typeCode >=", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeLessThan(String value) {
            addCriterion("shop_typeCode <", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeLessThanOrEqualTo(String value) {
            addCriterion("shop_typeCode <=", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeLike(String value) {
            addCriterion("shop_typeCode like", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeNotLike(String value) {
            addCriterion("shop_typeCode not like", value, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeIn(List<String> values) {
            addCriterion("shop_typeCode in", values, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeNotIn(List<String> values) {
            addCriterion("shop_typeCode not in", values, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeBetween(String value1, String value2) {
            addCriterion("shop_typeCode between", value1, value2, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_typeCodeNotBetween(String value1, String value2) {
            addCriterion("shop_typeCode not between", value1, value2, "shop_typeCode");
            return (Criteria) this;
        }

        public Criteria andShop_feeIsNull() {
            addCriterion("shop_fee is null");
            return (Criteria) this;
        }

        public Criteria andShop_feeIsNotNull() {
            addCriterion("shop_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShop_feeEqualTo(String value) {
            addCriterion("shop_fee =", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeNotEqualTo(String value) {
            addCriterion("shop_fee <>", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeGreaterThan(String value) {
            addCriterion("shop_fee >", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_fee >=", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeLessThan(String value) {
            addCriterion("shop_fee <", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeLessThanOrEqualTo(String value) {
            addCriterion("shop_fee <=", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeLike(String value) {
            addCriterion("shop_fee like", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeNotLike(String value) {
            addCriterion("shop_fee not like", value, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeIn(List<String> values) {
            addCriterion("shop_fee in", values, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeNotIn(List<String> values) {
            addCriterion("shop_fee not in", values, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeBetween(String value1, String value2) {
            addCriterion("shop_fee between", value1, value2, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_feeNotBetween(String value1, String value2) {
            addCriterion("shop_fee not between", value1, value2, "shop_fee");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeIsNull() {
            addCriterion("shop_fee_begintime is null");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeIsNotNull() {
            addCriterion("shop_fee_begintime is not null");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeEqualTo(Integer value) {
            addCriterion("shop_fee_begintime =", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeNotEqualTo(Integer value) {
            addCriterion("shop_fee_begintime <>", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeGreaterThan(Integer value) {
            addCriterion("shop_fee_begintime >", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_fee_begintime >=", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeLessThan(Integer value) {
            addCriterion("shop_fee_begintime <", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_fee_begintime <=", value, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeIn(List<Integer> values) {
            addCriterion("shop_fee_begintime in", values, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeNotIn(List<Integer> values) {
            addCriterion("shop_fee_begintime not in", values, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeBetween(Integer value1, Integer value2) {
            addCriterion("shop_fee_begintime between", value1, value2, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_begintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_fee_begintime not between", value1, value2, "shop_fee_begintime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeIsNull() {
            addCriterion("shop_fee_endtime is null");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeIsNotNull() {
            addCriterion("shop_fee_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeEqualTo(Integer value) {
            addCriterion("shop_fee_endtime =", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeNotEqualTo(Integer value) {
            addCriterion("shop_fee_endtime <>", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeGreaterThan(Integer value) {
            addCriterion("shop_fee_endtime >", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_fee_endtime >=", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeLessThan(Integer value) {
            addCriterion("shop_fee_endtime <", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_fee_endtime <=", value, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeIn(List<Integer> values) {
            addCriterion("shop_fee_endtime in", values, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeNotIn(List<Integer> values) {
            addCriterion("shop_fee_endtime not in", values, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeBetween(Integer value1, Integer value2) {
            addCriterion("shop_fee_endtime between", value1, value2, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_fee_endtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_fee_endtime not between", value1, value2, "shop_fee_endtime");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeIsNull() {
            addCriterion("shop_proCode is null");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeIsNotNull() {
            addCriterion("shop_proCode is not null");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeEqualTo(String value) {
            addCriterion("shop_proCode =", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeNotEqualTo(String value) {
            addCriterion("shop_proCode <>", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeGreaterThan(String value) {
            addCriterion("shop_proCode >", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_proCode >=", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeLessThan(String value) {
            addCriterion("shop_proCode <", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeLessThanOrEqualTo(String value) {
            addCriterion("shop_proCode <=", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeLike(String value) {
            addCriterion("shop_proCode like", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeNotLike(String value) {
            addCriterion("shop_proCode not like", value, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeIn(List<String> values) {
            addCriterion("shop_proCode in", values, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeNotIn(List<String> values) {
            addCriterion("shop_proCode not in", values, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeBetween(String value1, String value2) {
            addCriterion("shop_proCode between", value1, value2, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_proCodeNotBetween(String value1, String value2) {
            addCriterion("shop_proCode not between", value1, value2, "shop_proCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeIsNull() {
            addCriterion("shop_cityCode is null");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeIsNotNull() {
            addCriterion("shop_cityCode is not null");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeEqualTo(String value) {
            addCriterion("shop_cityCode =", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeNotEqualTo(String value) {
            addCriterion("shop_cityCode <>", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeGreaterThan(String value) {
            addCriterion("shop_cityCode >", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_cityCode >=", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeLessThan(String value) {
            addCriterion("shop_cityCode <", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeLessThanOrEqualTo(String value) {
            addCriterion("shop_cityCode <=", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeLike(String value) {
            addCriterion("shop_cityCode like", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeNotLike(String value) {
            addCriterion("shop_cityCode not like", value, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeIn(List<String> values) {
            addCriterion("shop_cityCode in", values, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeNotIn(List<String> values) {
            addCriterion("shop_cityCode not in", values, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeBetween(String value1, String value2) {
            addCriterion("shop_cityCode between", value1, value2, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_cityCodeNotBetween(String value1, String value2) {
            addCriterion("shop_cityCode not between", value1, value2, "shop_cityCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeIsNull() {
            addCriterion("shop_areaCode is null");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeIsNotNull() {
            addCriterion("shop_areaCode is not null");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeEqualTo(String value) {
            addCriterion("shop_areaCode =", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeNotEqualTo(String value) {
            addCriterion("shop_areaCode <>", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeGreaterThan(String value) {
            addCriterion("shop_areaCode >", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_areaCode >=", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeLessThan(String value) {
            addCriterion("shop_areaCode <", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeLessThanOrEqualTo(String value) {
            addCriterion("shop_areaCode <=", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeLike(String value) {
            addCriterion("shop_areaCode like", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeNotLike(String value) {
            addCriterion("shop_areaCode not like", value, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeIn(List<String> values) {
            addCriterion("shop_areaCode in", values, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeNotIn(List<String> values) {
            addCriterion("shop_areaCode not in", values, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeBetween(String value1, String value2) {
            addCriterion("shop_areaCode between", value1, value2, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_areaCodeNotBetween(String value1, String value2) {
            addCriterion("shop_areaCode not between", value1, value2, "shop_areaCode");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeIsNull() {
            addCriterion("shop_addtime is null");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeIsNotNull() {
            addCriterion("shop_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeEqualTo(Date value) {
            addCriterion("shop_addtime =", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeNotEqualTo(Date value) {
            addCriterion("shop_addtime <>", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeGreaterThan(Date value) {
            addCriterion("shop_addtime >", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shop_addtime >=", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeLessThan(Date value) {
            addCriterion("shop_addtime <", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeLessThanOrEqualTo(Date value) {
            addCriterion("shop_addtime <=", value, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeIn(List<Date> values) {
            addCriterion("shop_addtime in", values, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeNotIn(List<Date> values) {
            addCriterion("shop_addtime not in", values, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeBetween(Date value1, Date value2) {
            addCriterion("shop_addtime between", value1, value2, "shop_addtime");
            return (Criteria) this;
        }

        public Criteria andShop_addtimeNotBetween(Date value1, Date value2) {
            addCriterion("shop_addtime not between", value1, value2, "shop_addtime");
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