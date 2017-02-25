package com.shiro.realm;

import com.shiro.dao.RoleDAO;
import com.shiro.dao.UsersDAO;
import com.shiro.pojo.Role;
import com.shiro.pojo.Users;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/15
 * Time: 14:24
 * Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UsersDAO usersDAO;

    @Resource
    private RoleDAO roleDAO;

    //authorization 授权
    //获取登录用户的信息，获取角色，给authorizationInfo添加这个用户的角色信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection/**这个相当于用户信息，自己设置的主体，一般是用户名**/ principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        //SimpleAuthorizationInfo主要包含两个属性roles和stringPermissions
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Users user = usersDAO.getUsersByUserName(userName);
        if (user != null) {
            String roleIds = user.getRoleId();
            if (StringUtils.isNotBlank(roleIds)) {
                List<String> ids = Arrays.asList(roleIds.split(","));
                List<Long> longIds = new ArrayList<Long>();
                for (String id : ids) {
                    longIds.add(Long.valueOf(id));
                }
                List<Role> roles = roleDAO.getRoleByKeys(longIds);
                if (roles != null) {
                    for (Role role : roles) {
                        //mark 这个方法的代码里主要就是给authorizationInfo添加角色和权限信息，很好自己扩展
                        //给当前认证添加角色
                        authorizationInfo.addRole(role.getRole());
                    }
                }
            }
        }
        return authorizationInfo;
    }

    //authentication 验证
    //验证是否有这个登录主体
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        Users user = usersDAO.getUsersByUserName(userName);
        if (user == null) {
            throw new UnknownAccountException("userName:" + userName + " 没有此用户");
        }
        return new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                "gy"
        );
    }
}