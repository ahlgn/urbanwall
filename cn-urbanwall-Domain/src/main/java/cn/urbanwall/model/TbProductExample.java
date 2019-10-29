package cn.urbanwall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProductExample() {
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

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProImagesIsNull() {
            addCriterion("pro_images is null");
            return (Criteria) this;
        }

        public Criteria andProImagesIsNotNull() {
            addCriterion("pro_images is not null");
            return (Criteria) this;
        }

        public Criteria andProImagesEqualTo(String value) {
            addCriterion("pro_images =", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesNotEqualTo(String value) {
            addCriterion("pro_images <>", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesGreaterThan(String value) {
            addCriterion("pro_images >", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesGreaterThanOrEqualTo(String value) {
            addCriterion("pro_images >=", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesLessThan(String value) {
            addCriterion("pro_images <", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesLessThanOrEqualTo(String value) {
            addCriterion("pro_images <=", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesLike(String value) {
            addCriterion("pro_images like", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesNotLike(String value) {
            addCriterion("pro_images not like", value, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesIn(List<String> values) {
            addCriterion("pro_images in", values, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesNotIn(List<String> values) {
            addCriterion("pro_images not in", values, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesBetween(String value1, String value2) {
            addCriterion("pro_images between", value1, value2, "proImages");
            return (Criteria) this;
        }

        public Criteria andProImagesNotBetween(String value1, String value2) {
            addCriterion("pro_images not between", value1, value2, "proImages");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNull() {
            addCriterion("pro_price is null");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNotNull() {
            addCriterion("pro_price is not null");
            return (Criteria) this;
        }

        public Criteria andProPriceEqualTo(Double value) {
            addCriterion("pro_price =", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotEqualTo(Double value) {
            addCriterion("pro_price <>", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThan(Double value) {
            addCriterion("pro_price >", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_price >=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThan(Double value) {
            addCriterion("pro_price <", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThanOrEqualTo(Double value) {
            addCriterion("pro_price <=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceIn(List<Double> values) {
            addCriterion("pro_price in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotIn(List<Double> values) {
            addCriterion("pro_price not in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceBetween(Double value1, Double value2) {
            addCriterion("pro_price between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotBetween(Double value1, Double value2) {
            addCriterion("pro_price not between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPlaceIsNull() {
            addCriterion("pro_place is null");
            return (Criteria) this;
        }

        public Criteria andProPlaceIsNotNull() {
            addCriterion("pro_place is not null");
            return (Criteria) this;
        }

        public Criteria andProPlaceEqualTo(String value) {
            addCriterion("pro_place =", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceNotEqualTo(String value) {
            addCriterion("pro_place <>", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceGreaterThan(String value) {
            addCriterion("pro_place >", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("pro_place >=", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceLessThan(String value) {
            addCriterion("pro_place <", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceLessThanOrEqualTo(String value) {
            addCriterion("pro_place <=", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceLike(String value) {
            addCriterion("pro_place like", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceNotLike(String value) {
            addCriterion("pro_place not like", value, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceIn(List<String> values) {
            addCriterion("pro_place in", values, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceNotIn(List<String> values) {
            addCriterion("pro_place not in", values, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceBetween(String value1, String value2) {
            addCriterion("pro_place between", value1, value2, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProPlaceNotBetween(String value1, String value2) {
            addCriterion("pro_place not between", value1, value2, "proPlace");
            return (Criteria) this;
        }

        public Criteria andProStockIsNull() {
            addCriterion("pro_stock is null");
            return (Criteria) this;
        }

        public Criteria andProStockIsNotNull() {
            addCriterion("pro_stock is not null");
            return (Criteria) this;
        }

        public Criteria andProStockEqualTo(Integer value) {
            addCriterion("pro_stock =", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockNotEqualTo(Integer value) {
            addCriterion("pro_stock <>", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockGreaterThan(Integer value) {
            addCriterion("pro_stock >", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_stock >=", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockLessThan(Integer value) {
            addCriterion("pro_stock <", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockLessThanOrEqualTo(Integer value) {
            addCriterion("pro_stock <=", value, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockIn(List<Integer> values) {
            addCriterion("pro_stock in", values, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockNotIn(List<Integer> values) {
            addCriterion("pro_stock not in", values, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockBetween(Integer value1, Integer value2) {
            addCriterion("pro_stock between", value1, value2, "proStock");
            return (Criteria) this;
        }

        public Criteria andProStockNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_stock not between", value1, value2, "proStock");
            return (Criteria) this;
        }

        public Criteria andProTimeIsNull() {
            addCriterion("pro_time is null");
            return (Criteria) this;
        }

        public Criteria andProTimeIsNotNull() {
            addCriterion("pro_time is not null");
            return (Criteria) this;
        }

        public Criteria andProTimeEqualTo(Date value) {
            addCriterion("pro_time =", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotEqualTo(Date value) {
            addCriterion("pro_time <>", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeGreaterThan(Date value) {
            addCriterion("pro_time >", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_time >=", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeLessThan(Date value) {
            addCriterion("pro_time <", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeLessThanOrEqualTo(Date value) {
            addCriterion("pro_time <=", value, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeIn(List<Date> values) {
            addCriterion("pro_time in", values, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotIn(List<Date> values) {
            addCriterion("pro_time not in", values, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeBetween(Date value1, Date value2) {
            addCriterion("pro_time between", value1, value2, "proTime");
            return (Criteria) this;
        }

        public Criteria andProTimeNotBetween(Date value1, Date value2) {
            addCriterion("pro_time not between", value1, value2, "proTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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