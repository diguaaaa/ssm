package com.roobtyan.pojo;

import java.util.ArrayList;
import java.util.List;

public class GameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andGIdIsNull() {
            addCriterion("g_id is null");
            return (Criteria) this;
        }

        public Criteria andGIdIsNotNull() {
            addCriterion("g_id is not null");
            return (Criteria) this;
        }

        public Criteria andGIdEqualTo(Integer value) {
            addCriterion("g_id =", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotEqualTo(Integer value) {
            addCriterion("g_id <>", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThan(Integer value) {
            addCriterion("g_id >", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_id >=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThan(Integer value) {
            addCriterion("g_id <", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThanOrEqualTo(Integer value) {
            addCriterion("g_id <=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdIn(List<Integer> values) {
            addCriterion("g_id in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotIn(List<Integer> values) {
            addCriterion("g_id not in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdBetween(Integer value1, Integer value2) {
            addCriterion("g_id between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotBetween(Integer value1, Integer value2) {
            addCriterion("g_id not between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGAddressIsNull() {
            addCriterion("g_address is null");
            return (Criteria) this;
        }

        public Criteria andGAddressIsNotNull() {
            addCriterion("g_address is not null");
            return (Criteria) this;
        }

        public Criteria andGAddressEqualTo(String value) {
            addCriterion("g_address =", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressNotEqualTo(String value) {
            addCriterion("g_address <>", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressGreaterThan(String value) {
            addCriterion("g_address >", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressGreaterThanOrEqualTo(String value) {
            addCriterion("g_address >=", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressLessThan(String value) {
            addCriterion("g_address <", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressLessThanOrEqualTo(String value) {
            addCriterion("g_address <=", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressLike(String value) {
            addCriterion("g_address like", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressNotLike(String value) {
            addCriterion("g_address not like", value, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressIn(List<String> values) {
            addCriterion("g_address in", values, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressNotIn(List<String> values) {
            addCriterion("g_address not in", values, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressBetween(String value1, String value2) {
            addCriterion("g_address between", value1, value2, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGAddressNotBetween(String value1, String value2) {
            addCriterion("g_address not between", value1, value2, "gAddress");
            return (Criteria) this;
        }

        public Criteria andGSizeIsNull() {
            addCriterion("g_size is null");
            return (Criteria) this;
        }

        public Criteria andGSizeIsNotNull() {
            addCriterion("g_size is not null");
            return (Criteria) this;
        }

        public Criteria andGSizeEqualTo(Double value) {
            addCriterion("g_size =", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeNotEqualTo(Double value) {
            addCriterion("g_size <>", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeGreaterThan(Double value) {
            addCriterion("g_size >", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("g_size >=", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeLessThan(Double value) {
            addCriterion("g_size <", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeLessThanOrEqualTo(Double value) {
            addCriterion("g_size <=", value, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeIn(List<Double> values) {
            addCriterion("g_size in", values, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeNotIn(List<Double> values) {
            addCriterion("g_size not in", values, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeBetween(Double value1, Double value2) {
            addCriterion("g_size between", value1, value2, "gSize");
            return (Criteria) this;
        }

        public Criteria andGSizeNotBetween(Double value1, Double value2) {
            addCriterion("g_size not between", value1, value2, "gSize");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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