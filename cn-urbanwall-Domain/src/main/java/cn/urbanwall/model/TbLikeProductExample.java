package cn.urbanwall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbLikeProductExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public TbLikeProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
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

        public Criteria andLikeIdIsNull() {
            addCriterion("like_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeIdIsNotNull() {
            addCriterion("like_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeIdEqualTo(Long value) {
            addCriterion("like_id =", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotEqualTo(Long value) {
            addCriterion("like_id <>", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThan(Long value) {
            addCriterion("like_id >", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_id >=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThan(Long value) {
            addCriterion("like_id <", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThanOrEqualTo(Long value) {
            addCriterion("like_id <=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdIn(List<Long> values) {
            addCriterion("like_id in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotIn(List<Long> values) {
            addCriterion("like_id not in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdBetween(Long value1, Long value2) {
            addCriterion("like_id between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotBetween(Long value1, Long value2) {
            addCriterion("like_id not between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdIsNull() {
            addCriterion("like_pro_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeProIdIsNotNull() {
            addCriterion("like_pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeProIdEqualTo(Long value) {
            addCriterion("like_pro_id =", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdNotEqualTo(Long value) {
            addCriterion("like_pro_id <>", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdGreaterThan(Long value) {
            addCriterion("like_pro_id >", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_pro_id >=", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdLessThan(Long value) {
            addCriterion("like_pro_id <", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdLessThanOrEqualTo(Long value) {
            addCriterion("like_pro_id <=", value, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdIn(List<Long> values) {
            addCriterion("like_pro_id in", values, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdNotIn(List<Long> values) {
            addCriterion("like_pro_id not in", values, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdBetween(Long value1, Long value2) {
            addCriterion("like_pro_id between", value1, value2, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeProIdNotBetween(Long value1, Long value2) {
            addCriterion("like_pro_id not between", value1, value2, "likeProId");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("like_time not between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNull() {
            addCriterion("like_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNotNull() {
            addCriterion("like_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdEqualTo(String value) {
            addCriterion("like_user_id =", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotEqualTo(String value) {
            addCriterion("like_user_id <>", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThan(String value) {
            addCriterion("like_user_id >", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("like_user_id >=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThan(String value) {
            addCriterion("like_user_id <", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThanOrEqualTo(String value) {
            addCriterion("like_user_id <=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLike(String value) {
            addCriterion("like_user_id like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotLike(String value) {
            addCriterion("like_user_id not like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIn(List<String> values) {
            addCriterion("like_user_id in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotIn(List<String> values) {
            addCriterion("like_user_id not in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdBetween(String value1, String value2) {
            addCriterion("like_user_id between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotBetween(String value1, String value2) {
            addCriterion("like_user_id not between", value1, value2, "likeUserId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_like_product
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_like_product
     *
     * @mbggenerated
     */
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