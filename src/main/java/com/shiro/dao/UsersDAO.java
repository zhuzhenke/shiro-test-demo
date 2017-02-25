package com.shiro.dao;

import com.alibaba.cobarclient.dao.MysdalBaseDao;
import com.shiro.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuzhenke
 * @date 2016-11-14
 */

@Repository
public class UsersDAO extends MysdalBaseDao {


    public Integer addUsers(Users users) {
        return (Integer) getSqlMapClientTemplate().insert("Users.insertUsers", users);
    }

    /**
     * 根据主键查找
     */
    public Users getUsersByKey(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return (Users) getSqlMapClientTemplate().queryForObject(
                "Users.getUsersByKey", params);
    }

    /**
     * 根据主键查找
     */
    public Users getUsersByUserName(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        return (Users) getSqlMapClientTemplate().queryForObject(
                "Users.getUsersByUserName", params);
    }

    /**
     * 根据主键批量查找
     */
    public List<Users> getUsersByKeys(List<Integer> idList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("keys", idList);
        return (List<Users>) getSqlMapClientTemplate().queryForList("Users.getUserssByKeys", params);
    }

    /**
     * 根据主键删除
     */
    public Integer deleteByKey(Integer id) {
        return getSqlMapClientTemplate().delete("Users.deleteByKey", id);
    }

    /**
     * 根据主键更新
     */
    public Integer updateUsersByKey(Users users) {
        return getSqlMapClientTemplate().update("Users.updateUsersByKey", users);
    }
}