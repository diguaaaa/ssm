package com.roobtyan.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChoicedetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChoicedetailExample() {
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

        public Criteria andChoicedetailIdIsNull() {
            addCriterion("choicedetail_id is null");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdIsNotNull() {
            addCriterion("choicedetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdEqualTo(Integer value) {
            addCriterion("choicedetail_id =", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdNotEqualTo(Integer value) {
            addCriterion("choicedetail_id <>", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdGreaterThan(Integer value) {
            addCriterion("choicedetail_id >", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("choicedetail_id >=", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdLessThan(Integer value) {
            addCriterion("choicedetail_id <", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("choicedetail_id <=", value, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdIn(List<Integer> values) {
            addCriterion("choicedetail_id in", values, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdNotIn(List<Integer> values) {
            addCriterion("choicedetail_id not in", values, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdBetween(Integer value1, Integer value2) {
            addCriterion("choicedetail_id between", value1, value2, "choicedetailId");
            return (Criteria) this;
        }

        public Criteria andChoicedetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("choicedetail_id not between", value1, value2, "choicedetailId");
            return (Criteria) this;
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

        public Criteria andChoiceIdIsNull() {
            addCriterion("choice_id is null");
            return (Criteria) this;
        }

        public Criteria andChoiceIdIsNotNull() {
            addCriterion("choice_id is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceIdEqualTo(String value) {
            addCriterion("choice_id =", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdNotEqualTo(String value) {
            addCriterion("choice_id <>", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdGreaterThan(String value) {
            addCriterion("choice_id >", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("choice_id >=", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdLessThan(String value) {
            addCriterion("choice_id <", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdLessThanOrEqualTo(String value) {
            addCriterion("choice_id <=", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdLike(String value) {
            addCriterion("choice_id like", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdNotLike(String value) {
            addCriterion("choice_id not like", value, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdIn(List<String> values) {
            addCriterion("choice_id in", values, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdNotIn(List<String> values) {
            addCriterion("choice_id not in", values, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdBetween(String value1, String value2) {
            addCriterion("choice_id between", value1, value2, "choiceId");
            return (Criteria) this;
        }

        public Criteria andChoiceIdNotBetween(String value1, String value2) {
            addCriterion("choice_id not between", value1, value2, "choiceId");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andSizeTotalIsNull() {
            addCriterion("size_total is null");
            return (Criteria) this;
        }

        public Criteria andSizeTotalIsNotNull() {
            addCriterion("size_total is not null");
            return (Criteria) this;
        }

        public Criteria andSizeTotalEqualTo(Double value) {
            addCriterion("size_total =", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalNotEqualTo(Double value) {
            addCriterion("size_total <>", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalGreaterThan(Double value) {
            addCriterion("size_total >", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("size_total >=", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalLessThan(Double value) {
            addCriterion("size_total <", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalLessThanOrEqualTo(Double value) {
            addCriterion("size_total <=", value, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalIn(List<Double> values) {
            addCriterion("size_total in", values, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalNotIn(List<Double> values) {
            addCriterion("size_total not in", values, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalBetween(Double value1, Double value2) {
            addCriterion("size_total between", value1, value2, "sizeTotal");
            return (Criteria) this;
        }

        public Criteria andSizeTotalNotBetween(Double value1, Double value2) {
            addCriterion("size_total not between", value1, value2, "sizeTotal");
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