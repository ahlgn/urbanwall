package cn.urbanwall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbWallerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWallerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNull() {
            addCriterion("send_userid is null");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNotNull() {
            addCriterion("send_userid is not null");
            return (Criteria) this;
        }

        public Criteria andSendUseridEqualTo(String value) {
            addCriterion("send_userid =", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotEqualTo(String value) {
            addCriterion("send_userid <>", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThan(String value) {
            addCriterion("send_userid >", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThanOrEqualTo(String value) {
            addCriterion("send_userid >=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThan(String value) {
            addCriterion("send_userid <", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThanOrEqualTo(String value) {
            addCriterion("send_userid <=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLike(String value) {
            addCriterion("send_userid like", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotLike(String value) {
            addCriterion("send_userid not like", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridIn(List<String> values) {
            addCriterion("send_userid in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotIn(List<String> values) {
            addCriterion("send_userid not in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridBetween(String value1, String value2) {
            addCriterion("send_userid between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotBetween(String value1, String value2) {
            addCriterion("send_userid not between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUsernameIsNull() {
            addCriterion("send_username is null");
            return (Criteria) this;
        }

        public Criteria andSendUsernameIsNotNull() {
            addCriterion("send_username is not null");
            return (Criteria) this;
        }

        public Criteria andSendUsernameEqualTo(String value) {
            addCriterion("send_username =", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameNotEqualTo(String value) {
            addCriterion("send_username <>", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameGreaterThan(String value) {
            addCriterion("send_username >", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("send_username >=", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameLessThan(String value) {
            addCriterion("send_username <", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameLessThanOrEqualTo(String value) {
            addCriterion("send_username <=", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameLike(String value) {
            addCriterion("send_username like", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameNotLike(String value) {
            addCriterion("send_username not like", value, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameIn(List<String> values) {
            addCriterion("send_username in", values, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameNotIn(List<String> values) {
            addCriterion("send_username not in", values, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameBetween(String value1, String value2) {
            addCriterion("send_username between", value1, value2, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andSendUsernameNotBetween(String value1, String value2) {
            addCriterion("send_username not between", value1, value2, "sendUsername");
            return (Criteria) this;
        }

        public Criteria andWallerIsNull() {
            addCriterion("waller is null");
            return (Criteria) this;
        }

        public Criteria andWallerIsNotNull() {
            addCriterion("waller is not null");
            return (Criteria) this;
        }

        public Criteria andWallerEqualTo(String value) {
            addCriterion("waller =", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerNotEqualTo(String value) {
            addCriterion("waller <>", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerGreaterThan(String value) {
            addCriterion("waller >", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerGreaterThanOrEqualTo(String value) {
            addCriterion("waller >=", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerLessThan(String value) {
            addCriterion("waller <", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerLessThanOrEqualTo(String value) {
            addCriterion("waller <=", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerLike(String value) {
            addCriterion("waller like", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerNotLike(String value) {
            addCriterion("waller not like", value, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerIn(List<String> values) {
            addCriterion("waller in", values, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerNotIn(List<String> values) {
            addCriterion("waller not in", values, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerBetween(String value1, String value2) {
            addCriterion("waller between", value1, value2, "waller");
            return (Criteria) this;
        }

        public Criteria andWallerNotBetween(String value1, String value2) {
            addCriterion("waller not between", value1, value2, "waller");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andEmotionIsNull() {
            addCriterion("emotion is null");
            return (Criteria) this;
        }

        public Criteria andEmotionIsNotNull() {
            addCriterion("emotion is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionEqualTo(String value) {
            addCriterion("emotion =", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotEqualTo(String value) {
            addCriterion("emotion <>", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionGreaterThan(String value) {
            addCriterion("emotion >", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionGreaterThanOrEqualTo(String value) {
            addCriterion("emotion >=", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLessThan(String value) {
            addCriterion("emotion <", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLessThanOrEqualTo(String value) {
            addCriterion("emotion <=", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLike(String value) {
            addCriterion("emotion like", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotLike(String value) {
            addCriterion("emotion not like", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionIn(List<String> values) {
            addCriterion("emotion in", values, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotIn(List<String> values) {
            addCriterion("emotion not in", values, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionBetween(String value1, String value2) {
            addCriterion("emotion between", value1, value2, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotBetween(String value1, String value2) {
            addCriterion("emotion not between", value1, value2, "emotion");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterionForJDBCDate("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterionForJDBCDate("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendtime not between", value1, value2, "sendtime");
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