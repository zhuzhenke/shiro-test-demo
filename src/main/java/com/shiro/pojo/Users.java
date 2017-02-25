package com.shiro.pojo;

/**
 * @author zhuzhenke
 * @date 2016-11-14
 */
public class Users extends BasePojo {


    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * userName
     */
    private String userName;
    /**
     * password
     */
    private String password;
    /**
     * role_id
     */
    private String roleId;


    /**
     * @return id id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userName userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return roleId role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId role_id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}