package cn.lcools.security;

import cn.lcools.bean.SecUser;
import cn.lcools.service.ISecAuthorizeInterface;
import cn.lcools.service.ISecRoleFunGrantInterface;
import cn.lcools.service.ISecUserInterface;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: CustomRealm
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/19 17:20
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/19     liushuai3           v1.0.0               修改原因
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    ISecUserInterface userService;
    @Autowired
    ISecAuthorizeInterface authorizeService;
    @Autowired
    ISecRoleFunGrantInterface roleFunGrantService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取认证时传入的用户信息
        Object object = principalCollection.getPrimaryPrincipal();
        if (object instanceof SecUser) {
            SecUser secUser = (SecUser)object;
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 获取用户的角色
            Set<String> roleSet = authorizeService.selectRoleCodesByUserId(secUser.getUserId());
            info.setRoles(roleSet);
            // 获取用户的菜单
            Set<String> funsSet = roleFunGrantService.selectFuncIdsByUserId(secUser.getUserId());
            info.setStringPermissions(funsSet);
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 开始身份认证，获取登录时传入的userCode
        String userCode = (String) authenticationToken.getPrincipal();
        // 从数据库获取用户信息
        SecUser secUser = userService.getUserByUserCode(userCode);
        if (secUser == null) {
            return null;
        }
        // 通过数据库的密码信息生成认证信息，并将用户信息传入
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(secUser, secUser.getPassword(), getName());
        // 设置数据库密码的加Salt的编码为userCode+salt
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userCode+"salt"));
        return simpleAuthenticationInfo;
    }
}
