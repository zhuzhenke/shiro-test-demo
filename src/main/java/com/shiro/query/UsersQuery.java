package com.shiro.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuzhenke
 */
public class UsersQuery extends BaseQuery {

    /**==============================批量查询、更新、删除时的Where条件设置==================================**/
    /**
     * id
     **/
    private Integer id;

    public Integer getId() {
        return id;
    }

    public UsersQuery setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * userName
     **/
    private String userName;

    public String getUserName() {
        return userName;
    }

    public UsersQuery setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * password
     **/
    private String password;

    public String getPassword() {
        return password;
    }

    public UsersQuery setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * role_id
     **/
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public UsersQuery setRoleId(String roleId) {
        this.roleId = roleId;
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
    public UsersQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：userName
     *
     * @param isAsc 是否升序，否则为降序
     */
    public UsersQuery orderbyUserName(boolean isAsc) {
        orderFields.add(new OrderField("userName", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：password
     *
     * @param isAsc 是否升序，否则为降序
     */
    public UsersQuery orderbyPassword(boolean isAsc) {
        orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：role_id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public UsersQuery orderbyRoleId(boolean isAsc) {
        orderFields.add(new OrderField("role_id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    private List<Integer> keys;

    public List<Integer> getKeys() {
        return keys;
    }

    public UsersQuery setKeys(List<Integer> keys) {
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
            fieldMap.put("userName", "userName");
            fieldMap.put("password", "password");
            fieldMap.put("role_id", "roleId");
        }
        return fieldMap;
    }

    public String getFields() {
        return this.fields;
    }

    public UsersQuery setFields(String fields) {
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
