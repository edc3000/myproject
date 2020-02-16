package com.scauly.SpringCloud.entities;

import java.util.ArrayList;
import java.util.List;

public class FundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundExample() {
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

        public Criteria andFundidIsNull() {
            addCriterion("fundID is null");
            return (Criteria) this;
        }

        public Criteria andFundidIsNotNull() {
            addCriterion("fundID is not null");
            return (Criteria) this;
        }

        public Criteria andFundidEqualTo(Long value) {
            addCriterion("fundID =", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotEqualTo(Long value) {
            addCriterion("fundID <>", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidGreaterThan(Long value) {
            addCriterion("fundID >", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidGreaterThanOrEqualTo(Long value) {
            addCriterion("fundID >=", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidLessThan(Long value) {
            addCriterion("fundID <", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidLessThanOrEqualTo(Long value) {
            addCriterion("fundID <=", value, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidIn(List<Long> values) {
            addCriterion("fundID in", values, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotIn(List<Long> values) {
            addCriterion("fundID not in", values, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidBetween(Long value1, Long value2) {
            addCriterion("fundID between", value1, value2, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundidNotBetween(Long value1, Long value2) {
            addCriterion("fundID not between", value1, value2, "fundid");
            return (Criteria) this;
        }

        public Criteria andFundnameIsNull() {
            addCriterion("fundName is null");
            return (Criteria) this;
        }

        public Criteria andFundnameIsNotNull() {
            addCriterion("fundName is not null");
            return (Criteria) this;
        }

        public Criteria andFundnameEqualTo(String value) {
            addCriterion("fundName =", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameNotEqualTo(String value) {
            addCriterion("fundName <>", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameGreaterThan(String value) {
            addCriterion("fundName >", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameGreaterThanOrEqualTo(String value) {
            addCriterion("fundName >=", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameLessThan(String value) {
            addCriterion("fundName <", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameLessThanOrEqualTo(String value) {
            addCriterion("fundName <=", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameLike(String value) {
            addCriterion("fundName like", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameNotLike(String value) {
            addCriterion("fundName not like", value, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameIn(List<String> values) {
            addCriterion("fundName in", values, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameNotIn(List<String> values) {
            addCriterion("fundName not in", values, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameBetween(String value1, String value2) {
            addCriterion("fundName between", value1, value2, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundnameNotBetween(String value1, String value2) {
            addCriterion("fundName not between", value1, value2, "fundname");
            return (Criteria) this;
        }

        public Criteria andFundbriefIsNull() {
            addCriterion("fundBrief is null");
            return (Criteria) this;
        }

        public Criteria andFundbriefIsNotNull() {
            addCriterion("fundBrief is not null");
            return (Criteria) this;
        }

        public Criteria andFundbriefEqualTo(String value) {
            addCriterion("fundBrief =", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefNotEqualTo(String value) {
            addCriterion("fundBrief <>", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefGreaterThan(String value) {
            addCriterion("fundBrief >", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefGreaterThanOrEqualTo(String value) {
            addCriterion("fundBrief >=", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefLessThan(String value) {
            addCriterion("fundBrief <", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefLessThanOrEqualTo(String value) {
            addCriterion("fundBrief <=", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefLike(String value) {
            addCriterion("fundBrief like", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefNotLike(String value) {
            addCriterion("fundBrief not like", value, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefIn(List<String> values) {
            addCriterion("fundBrief in", values, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefNotIn(List<String> values) {
            addCriterion("fundBrief not in", values, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefBetween(String value1, String value2) {
            addCriterion("fundBrief between", value1, value2, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundbriefNotBetween(String value1, String value2) {
            addCriterion("fundBrief not between", value1, value2, "fundbrief");
            return (Criteria) this;
        }

        public Criteria andFundsupplyIsNull() {
            addCriterion("fundSupply is null");
            return (Criteria) this;
        }

        public Criteria andFundsupplyIsNotNull() {
            addCriterion("fundSupply is not null");
            return (Criteria) this;
        }

        public Criteria andFundsupplyEqualTo(Long value) {
            addCriterion("fundSupply =", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyNotEqualTo(Long value) {
            addCriterion("fundSupply <>", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyGreaterThan(Long value) {
            addCriterion("fundSupply >", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyGreaterThanOrEqualTo(Long value) {
            addCriterion("fundSupply >=", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyLessThan(Long value) {
            addCriterion("fundSupply <", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyLessThanOrEqualTo(Long value) {
            addCriterion("fundSupply <=", value, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyIn(List<Long> values) {
            addCriterion("fundSupply in", values, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyNotIn(List<Long> values) {
            addCriterion("fundSupply not in", values, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyBetween(Long value1, Long value2) {
            addCriterion("fundSupply between", value1, value2, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundsupplyNotBetween(Long value1, Long value2) {
            addCriterion("fundSupply not between", value1, value2, "fundsupply");
            return (Criteria) this;
        }

        public Criteria andFundpriceIsNull() {
            addCriterion("fundPrice is null");
            return (Criteria) this;
        }

        public Criteria andFundpriceIsNotNull() {
            addCriterion("fundPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFundpriceEqualTo(Long value) {
            addCriterion("fundPrice =", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceNotEqualTo(Long value) {
            addCriterion("fundPrice <>", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceGreaterThan(Long value) {
            addCriterion("fundPrice >", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("fundPrice >=", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceLessThan(Long value) {
            addCriterion("fundPrice <", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceLessThanOrEqualTo(Long value) {
            addCriterion("fundPrice <=", value, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceIn(List<Long> values) {
            addCriterion("fundPrice in", values, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceNotIn(List<Long> values) {
            addCriterion("fundPrice not in", values, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceBetween(Long value1, Long value2) {
            addCriterion("fundPrice between", value1, value2, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundpriceNotBetween(Long value1, Long value2) {
            addCriterion("fundPrice not between", value1, value2, "fundprice");
            return (Criteria) this;
        }

        public Criteria andFundresponseIsNull() {
            addCriterion("fundResponse is null");
            return (Criteria) this;
        }

        public Criteria andFundresponseIsNotNull() {
            addCriterion("fundResponse is not null");
            return (Criteria) this;
        }

        public Criteria andFundresponseEqualTo(String value) {
            addCriterion("fundResponse =", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseNotEqualTo(String value) {
            addCriterion("fundResponse <>", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseGreaterThan(String value) {
            addCriterion("fundResponse >", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseGreaterThanOrEqualTo(String value) {
            addCriterion("fundResponse >=", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseLessThan(String value) {
            addCriterion("fundResponse <", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseLessThanOrEqualTo(String value) {
            addCriterion("fundResponse <=", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseLike(String value) {
            addCriterion("fundResponse like", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseNotLike(String value) {
            addCriterion("fundResponse not like", value, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseIn(List<String> values) {
            addCriterion("fundResponse in", values, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseNotIn(List<String> values) {
            addCriterion("fundResponse not in", values, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseBetween(String value1, String value2) {
            addCriterion("fundResponse between", value1, value2, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundresponseNotBetween(String value1, String value2) {
            addCriterion("fundResponse not between", value1, value2, "fundresponse");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidIsNull() {
            addCriterion("fundCompanyID is null");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidIsNotNull() {
            addCriterion("fundCompanyID is not null");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidEqualTo(Long value) {
            addCriterion("fundCompanyID =", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidNotEqualTo(Long value) {
            addCriterion("fundCompanyID <>", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidGreaterThan(Long value) {
            addCriterion("fundCompanyID >", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidGreaterThanOrEqualTo(Long value) {
            addCriterion("fundCompanyID >=", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidLessThan(Long value) {
            addCriterion("fundCompanyID <", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidLessThanOrEqualTo(Long value) {
            addCriterion("fundCompanyID <=", value, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidIn(List<Long> values) {
            addCriterion("fundCompanyID in", values, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidNotIn(List<Long> values) {
            addCriterion("fundCompanyID not in", values, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidBetween(Long value1, Long value2) {
            addCriterion("fundCompanyID between", value1, value2, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundcompanyidNotBetween(Long value1, Long value2) {
            addCriterion("fundCompanyID not between", value1, value2, "fundcompanyid");
            return (Criteria) this;
        }

        public Criteria andFundstatusIsNull() {
            addCriterion("fundStatus is null");
            return (Criteria) this;
        }

        public Criteria andFundstatusIsNotNull() {
            addCriterion("fundStatus is not null");
            return (Criteria) this;
        }

        public Criteria andFundstatusEqualTo(String value) {
            addCriterion("fundStatus =", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusNotEqualTo(String value) {
            addCriterion("fundStatus <>", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusGreaterThan(String value) {
            addCriterion("fundStatus >", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusGreaterThanOrEqualTo(String value) {
            addCriterion("fundStatus >=", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusLessThan(String value) {
            addCriterion("fundStatus <", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusLessThanOrEqualTo(String value) {
            addCriterion("fundStatus <=", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusLike(String value) {
            addCriterion("fundStatus like", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusNotLike(String value) {
            addCriterion("fundStatus not like", value, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusIn(List<String> values) {
            addCriterion("fundStatus in", values, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusNotIn(List<String> values) {
            addCriterion("fundStatus not in", values, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusBetween(String value1, String value2) {
            addCriterion("fundStatus between", value1, value2, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundstatusNotBetween(String value1, String value2) {
            addCriterion("fundStatus not between", value1, value2, "fundstatus");
            return (Criteria) this;
        }

        public Criteria andFundmageurlIsNull() {
            addCriterion("fundmageURL is null");
            return (Criteria) this;
        }

        public Criteria andFundmageurlIsNotNull() {
            addCriterion("fundmageURL is not null");
            return (Criteria) this;
        }

        public Criteria andFundmageurlEqualTo(String value) {
            addCriterion("fundmageURL =", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlNotEqualTo(String value) {
            addCriterion("fundmageURL <>", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlGreaterThan(String value) {
            addCriterion("fundmageURL >", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlGreaterThanOrEqualTo(String value) {
            addCriterion("fundmageURL >=", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlLessThan(String value) {
            addCriterion("fundmageURL <", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlLessThanOrEqualTo(String value) {
            addCriterion("fundmageURL <=", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlLike(String value) {
            addCriterion("fundmageURL like", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlNotLike(String value) {
            addCriterion("fundmageURL not like", value, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlIn(List<String> values) {
            addCriterion("fundmageURL in", values, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlNotIn(List<String> values) {
            addCriterion("fundmageURL not in", values, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlBetween(String value1, String value2) {
            addCriterion("fundmageURL between", value1, value2, "fundmageurl");
            return (Criteria) this;
        }

        public Criteria andFundmageurlNotBetween(String value1, String value2) {
            addCriterion("fundmageURL not between", value1, value2, "fundmageurl");
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