package com.gxc.entity;

import java.util.ArrayList;
import java.util.List;

public class TDormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDormExample() {
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

        public Criteria andDormidIsNull() {
            addCriterion("dormId is null");
            return (Criteria) this;
        }

        public Criteria andDormidIsNotNull() {
            addCriterion("dormId is not null");
            return (Criteria) this;
        }

        public Criteria andDormidEqualTo(Integer value) {
            addCriterion("dormId =", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidNotEqualTo(Integer value) {
            addCriterion("dormId <>", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidGreaterThan(Integer value) {
            addCriterion("dormId >", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormId >=", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidLessThan(Integer value) {
            addCriterion("dormId <", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidLessThanOrEqualTo(Integer value) {
            addCriterion("dormId <=", value, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidIn(List<Integer> values) {
            addCriterion("dormId in", values, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidNotIn(List<Integer> values) {
            addCriterion("dormId not in", values, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidBetween(Integer value1, Integer value2) {
            addCriterion("dormId between", value1, value2, "dormid");
            return (Criteria) this;
        }

        public Criteria andDormidNotBetween(Integer value1, Integer value2) {
            addCriterion("dormId not between", value1, value2, "dormid");
            return (Criteria) this;
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

        public Criteria andDormnameIsNull() {
            addCriterion("dormName is null");
            return (Criteria) this;
        }

        public Criteria andDormnameIsNotNull() {
            addCriterion("dormName is not null");
            return (Criteria) this;
        }

        public Criteria andDormnameEqualTo(String value) {
            addCriterion("dormName =", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameNotEqualTo(String value) {
            addCriterion("dormName <>", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameGreaterThan(String value) {
            addCriterion("dormName >", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameGreaterThanOrEqualTo(String value) {
            addCriterion("dormName >=", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameLessThan(String value) {
            addCriterion("dormName <", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameLessThanOrEqualTo(String value) {
            addCriterion("dormName <=", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameLike(String value) {
            addCriterion("dormName like", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameNotLike(String value) {
            addCriterion("dormName not like", value, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameIn(List<String> values) {
            addCriterion("dormName in", values, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameNotIn(List<String> values) {
            addCriterion("dormName not in", values, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameBetween(String value1, String value2) {
            addCriterion("dormName between", value1, value2, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormnameNotBetween(String value1, String value2) {
            addCriterion("dormName not between", value1, value2, "dormname");
            return (Criteria) this;
        }

        public Criteria andDormtypeIsNull() {
            addCriterion("dormType is null");
            return (Criteria) this;
        }

        public Criteria andDormtypeIsNotNull() {
            addCriterion("dormType is not null");
            return (Criteria) this;
        }

        public Criteria andDormtypeEqualTo(String value) {
            addCriterion("dormType =", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeNotEqualTo(String value) {
            addCriterion("dormType <>", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeGreaterThan(String value) {
            addCriterion("dormType >", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeGreaterThanOrEqualTo(String value) {
            addCriterion("dormType >=", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeLessThan(String value) {
            addCriterion("dormType <", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeLessThanOrEqualTo(String value) {
            addCriterion("dormType <=", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeLike(String value) {
            addCriterion("dormType like", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeNotLike(String value) {
            addCriterion("dormType not like", value, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeIn(List<String> values) {
            addCriterion("dormType in", values, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeNotIn(List<String> values) {
            addCriterion("dormType not in", values, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeBetween(String value1, String value2) {
            addCriterion("dormType between", value1, value2, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormtypeNotBetween(String value1, String value2) {
            addCriterion("dormType not between", value1, value2, "dormtype");
            return (Criteria) this;
        }

        public Criteria andDormnumberIsNull() {
            addCriterion("dormNumber is null");
            return (Criteria) this;
        }

        public Criteria andDormnumberIsNotNull() {
            addCriterion("dormNumber is not null");
            return (Criteria) this;
        }

        public Criteria andDormnumberEqualTo(Integer value) {
            addCriterion("dormNumber =", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberNotEqualTo(Integer value) {
            addCriterion("dormNumber <>", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberGreaterThan(Integer value) {
            addCriterion("dormNumber >", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormNumber >=", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberLessThan(Integer value) {
            addCriterion("dormNumber <", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberLessThanOrEqualTo(Integer value) {
            addCriterion("dormNumber <=", value, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberIn(List<Integer> values) {
            addCriterion("dormNumber in", values, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberNotIn(List<Integer> values) {
            addCriterion("dormNumber not in", values, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberBetween(Integer value1, Integer value2) {
            addCriterion("dormNumber between", value1, value2, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("dormNumber not between", value1, value2, "dormnumber");
            return (Criteria) this;
        }

        public Criteria andDormtelIsNull() {
            addCriterion("dormTel is null");
            return (Criteria) this;
        }

        public Criteria andDormtelIsNotNull() {
            addCriterion("dormTel is not null");
            return (Criteria) this;
        }

        public Criteria andDormtelEqualTo(String value) {
            addCriterion("dormTel =", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelNotEqualTo(String value) {
            addCriterion("dormTel <>", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelGreaterThan(String value) {
            addCriterion("dormTel >", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelGreaterThanOrEqualTo(String value) {
            addCriterion("dormTel >=", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelLessThan(String value) {
            addCriterion("dormTel <", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelLessThanOrEqualTo(String value) {
            addCriterion("dormTel <=", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelLike(String value) {
            addCriterion("dormTel like", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelNotLike(String value) {
            addCriterion("dormTel not like", value, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelIn(List<String> values) {
            addCriterion("dormTel in", values, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelNotIn(List<String> values) {
            addCriterion("dormTel not in", values, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelBetween(String value1, String value2) {
            addCriterion("dormTel between", value1, value2, "dormtel");
            return (Criteria) this;
        }

        public Criteria andDormtelNotBetween(String value1, String value2) {
            addCriterion("dormTel not between", value1, value2, "dormtel");
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