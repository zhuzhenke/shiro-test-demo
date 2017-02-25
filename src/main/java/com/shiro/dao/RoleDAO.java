package com.shiro.dao;

import com.alibaba.cobarclient.dao.MysdalBaseDao;
import com.shiro.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuzhenke
 * @date 2016-11-15
 */

@Repository
public class RoleDAO extends MysdalBaseDao {


    public Integer addRole(Role role) {
        return (Integer) getSqlMapClientTemplate().insert("Role.insertRole", role);
    }

    /**
     * 根据主键查找
     */
    public Role getRoleByKey(Long id) {
        return (Role) getSqlMapClientTemplate().queryForObject(
                "Role.getRoleByKey", id);
    }

    /**
     * 根据主键批量查找
     */
    public List<Role> getRoleByKeys(List<Long> idList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("keys", idList);
        return (List<Role>) getSqlMapClientTemplate().queryForList("Role.getRolesByKeys", params);
    }

    /**
     * 根据主键删除
     */
    public Integer deleteByKey(Long id) {
        return getSqlMapClientTemplate().delete("Role.deleteByKey", id);
    }

    /**
     * 根据主键更新
     */
    public Integer updateRoleByKey(Role role) {
        return getSqlMapClientTemplate().update("Role.updateRoleByKey", role);
    }



}