package com.shiro.query;

import java.util.*;

/**
 * @author zhuzhenke
 */
public class RoleQuery extends BaseQuery {

    /**==============================批量查询、更新、删除时的Where条件设置==================================**/
    /**
     * id
     **/
    private Long id;

    public Long getId() {
        return id;
    }

    public RoleQuery setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * role
     **/
    private String role;

    public String getRole() {
        return role;
    }

    public RoleQuery setRole(String role) {
        this.role = role;
        return this;
    }

    /**
     * description
     **/
    private String description;

    public String getDescription() {
        return description;
    }

    public RoleQuery setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * enable_status
     **/
    private Long enableStatus;

    public Long getEnableStatus() {
        return enableStatus;
    }

    public RoleQuery setEnableStatus(Long enableStatus) {
        this.enableStatus = enableStatus;
        return this;
    }

    /**
     * modified
     **/
    private Date modifiedStart;

    public Date getModifiedStart() {
        return modifiedStart;
    }

    public RoleQuery setModifiedStart(Date modified) {
        this.modifiedStart = modified;
        return this;
    }

    private Date modifiedEnd;

    public Date getModifiedEnd() {
        return modifiedEnd;
    }

    public RoleQuery setModifiedEnd(Date modified) {
        this.modifiedEnd = modified;
        return this;
    }

    private Date modifiedEqual;

    public Date getModifiedEqual() {
        return modifiedEqual;
    }

    public RoleQuery setModifiedEqual(Date modified) {
        this.modifiedEqual = modified;
        return this;
    }

    /**
     * ==============================批量查询时的Order条件顺序设置==================================
     **/
    public class OrderField {
        public OrderField(String fieldName, String order) {
            super();
            this.fieldName = fieldName;
            this.order = order;
        }

        private String fieldName;
        private String order;

        public String getFieldName() {
            return fieldName;
        }

        public OrderField setFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public String getOrder() {
            return order;
        }

        public OrderField setOrder(String order) {
            this.order = order;
            return this;
        }
    }

    /**==============================批量查询时的Order条件顺序设置==================================**/
    /**
     * 排序列表字段
     **/
    private List<OrderField> orderFields = new ArrayList<OrderField>();

    /**
     * 设置排序按属性：id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public RoleQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：role
     *
     * @param isAsc 是否升序，否则为降序
     */
    public RoleQuery orderbyRole(boolean isAsc) {
        orderFields.add(new OrderField("role", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：description
     *
     * @param isAsc 是否升序，否则为降序
     */
    public RoleQuery orderbyDescription(boolean isAsc) {
        orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：enable_status
     *
     * @param isAsc 是否升序，否则为降序
     */
    public RoleQuery orderbyEnableStatus(boolean isAsc) {
        orderFields.add(new OrderField("enable_status", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：modified
     *
     * @param isAsc 是否升序，否则为降序
     */
    public RoleQuery orderbyModified(boolean isAsc) {
        orderFields.add(new OrderField("modified", isAsc ? "ASC" : "DESC"));
        return this;
    }

    private List<Long> keys;

    public List<Long> getKeys() {
        return keys;
    }

    public RoleQuery setKeys(List<Long> keys) {
        this.keys = keys;
        return this;
    }


    private String fields;
    /**
     * 提供自定义字段使用
     */
    private static Map<String, String> fieldMap;

    private static Map<String, String> getFieldSet() {
        if (fieldMap == null) {
            fieldMap = new HashMap<String, String>();
            fieldMap.put("id", "id");
            fieldMap.put("role", "role");
            fieldMap.put("description", "description");
            fieldMap.put("enable_status", "enableStatus");
            fieldMap.put("modified", "modified");
        }
        return fieldMap;
    }

    public String getFields() {
        return this.fields;
    }

    public RoleQuery setFields(String fields) {
        String[] array = fields.split(",");
        StringBuffer buffer = new StringBuffer();
        for (String field : array) {
            if (getFieldSet().containsKey(field)) {
                buffer.append(field).append(" as ").append(getFieldSet().get(field)).append(" ,");
            }
            if (getFieldSet().containsKey("`" + field + "`")) {
                buffer.append("`" + field + "`").append(" as ").append(getFieldSet().get(field)).append(" ,");
            }
        }
        if (buffer.length() != 0) {
            this.fields = buffer.substring(0, buffer.length() - 1);
        } else {
            this.fields = " 1 ";//没有一个参数可能会报错
        }
        return this;
    }
}
