package com.shiro.pojo;

import java.util.Date;

/**
 * @author zhuzhenke
 * @date 2016-11-15
 */
public class Role extends BasePojo {


    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * role
     */
    private String role;
    /**
     * description
     */
    private String description;
    /**
     * enable_status
     */
    private Long enableStatus;
    /**
     * modified
     */
    private Date modified;


    /**
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return role role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return description description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return enableStatus enable_status
     */
    public Long getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus enable_status
     */
    public void setEnableStatus(Long enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return modified modified
     */
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified modified
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

}