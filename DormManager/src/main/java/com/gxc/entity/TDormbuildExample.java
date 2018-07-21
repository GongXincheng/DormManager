package com.gxc.entity;

import java.util.ArrayList;
import java.util.List;

public class TDormbuildExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDormbuildExample() {
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

        public Criteria andDormbuildidIsNull() {
            addCriterion("dormBuildId is null");
            return (Criteria) this;
        }

        public Criteria andDormbuildidIsNotNull() {
            addCriterion("dormBuildId is not null");
            return (Criteria) this;
        }

        public Criteria andDormbuildidEqualTo(Integer value) {
            addCriterion("dormBuildId =", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidNotEqualTo(Integer value) {
            addCriterion("dormBuildId <>", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidGreaterThan(Integer value) {
            addCriterion("dormBuildId >", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormBuildId >=", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidLessThan(Integer value) {
            addCriterion("dormBuildId <", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidLessThanOrEqualTo(Integer value) {
            addCriterion("dormBuildId <=", value, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidIn(List<Integer> values) {
            addCriterion("dormBuildId in", values, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidNotIn(List<Integer> values) {
            addCriterion("dormBuildId not in", values, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidBetween(Integer value1, Integer value2) {
            addCriterion("dormBuildId between", value1, value2, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildidNotBetween(Integer value1, Integer value2) {
            addCriterion("dormBuildId not between", value1, value2, "dormbuildid");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameIsNull() {
            addCriterion("dormBuildName is null");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameIsNotNull() {
            addCriterion("dormBuildName is not null");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameEqualTo(String value) {
            addCriterion("dormBuildName =", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameNotEqualTo(String value) {
            addCriterion("dormBuildName <>", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameGreaterThan(String value) {
            addCriterion("dormBuildName >", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameGreaterThanOrEqualTo(String value) {
            addCriterion("dormBuildName >=", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameLessThan(String value) {
            addCriterion("dormBuildName <", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameLessThanOrEqualTo(String value) {
            addCriterion("dormBuildName <=", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameLike(String value) {
            addCriterion("dormBuildName like", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameNotLike(String value) {
            addCriterion("dormBuildName not like", value, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameIn(List<String> values) {
            addCriterion("dormBuildName in", values, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameNotIn(List<String> values) {
            addCriterion("dormBuildName not in", values, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameBetween(String value1, String value2) {
            addCriterion("dormBuildName between", value1, value2, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuildnameNotBetween(String value1, String value2) {
            addCriterion("dormBuildName not between", value1, value2, "dormbuildname");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailIsNull() {
            addCriterion("dormBuildDetail is null");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailIsNotNull() {
            addCriterion("dormBuildDetail is not null");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailEqualTo(String value) {
            addCriterion("dormBuildDetail =", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailNotEqualTo(String value) {
            addCriterion("dormBuildDetail <>", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailGreaterThan(String value) {
            addCriterion("dormBuildDetail >", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailGreaterThanOrEqualTo(String value) {
            addCriterion("dormBuildDetail >=", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailLessThan(String value) {
            addCriterion("dormBuildDetail <", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailLessThanOrEqualTo(String value) {
            addCriterion("dormBuildDetail <=", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailLike(String value) {
            addCriterion("dormBuildDetail like", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailNotLike(String value) {
            addCriterion("dormBuildDetail not like", value, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailIn(List<String> values) {
            addCriterion("dormBuildDetail in", values, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailNotIn(List<String> values) {
            addCriterion("dormBuildDetail not in", values, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailBetween(String value1, String value2) {
            addCriterion("dormBuildDetail between", value1, value2, "dormbuilddetail");
            return (Criteria) this;
        }

        public Criteria andDormbuilddetailNotBetween(String value1, String value2) {
            addCriterion("dormBuildDetail not between", value1, value2, "dormbuilddetail");
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