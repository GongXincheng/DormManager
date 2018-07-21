package com.gxc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRecordExample() {
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

        public Criteria andRecordidIsNull() {
            addCriterion("recordId is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordId is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(Integer value) {
            addCriterion("recordId =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(Integer value) {
            addCriterion("recordId <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(Integer value) {
            addCriterion("recordId >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recordId >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(Integer value) {
            addCriterion("recordId <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(Integer value) {
            addCriterion("recordId <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<Integer> values) {
            addCriterion("recordId in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<Integer> values) {
            addCriterion("recordId not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(Integer value1, Integer value2) {
            addCriterion("recordId between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("recordId not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNull() {
            addCriterion("studentNumber is null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNotNull() {
            addCriterion("studentNumber is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberEqualTo(String value) {
            addCriterion("studentNumber =", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotEqualTo(String value) {
            addCriterion("studentNumber <>", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThan(String value) {
            addCriterion("studentNumber >", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThanOrEqualTo(String value) {
            addCriterion("studentNumber >=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThan(String value) {
            addCriterion("studentNumber <", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThanOrEqualTo(String value) {
            addCriterion("studentNumber <=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLike(String value) {
            addCriterion("studentNumber like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotLike(String value) {
            addCriterion("studentNumber not like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIn(List<String> values) {
            addCriterion("studentNumber in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotIn(List<String> values) {
            addCriterion("studentNumber not in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberBetween(String value1, String value2) {
            addCriterion("studentNumber between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotBetween(String value1, String value2) {
            addCriterion("studentNumber not between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentName not between", value1, value2, "studentname");
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDatailIsNull() {
            addCriterion("datail is null");
            return (Criteria) this;
        }

        public Criteria andDatailIsNotNull() {
            addCriterion("datail is not null");
            return (Criteria) this;
        }

        public Criteria andDatailEqualTo(String value) {
            addCriterion("datail =", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailNotEqualTo(String value) {
            addCriterion("datail <>", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailGreaterThan(String value) {
            addCriterion("datail >", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailGreaterThanOrEqualTo(String value) {
            addCriterion("datail >=", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailLessThan(String value) {
            addCriterion("datail <", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailLessThanOrEqualTo(String value) {
            addCriterion("datail <=", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailLike(String value) {
            addCriterion("datail like", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailNotLike(String value) {
            addCriterion("datail not like", value, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailIn(List<String> values) {
            addCriterion("datail in", values, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailNotIn(List<String> values) {
            addCriterion("datail not in", values, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailBetween(String value1, String value2) {
            addCriterion("datail between", value1, value2, "datail");
            return (Criteria) this;
        }

        public Criteria andDatailNotBetween(String value1, String value2) {
            addCriterion("datail not between", value1, value2, "datail");
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