package cn.lcools.security;

import cn.lcools.bean.SecUser;
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

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object object = principalCollection.getPrimaryPrincipal();
        if (object instanceof SecUser) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            if ("admin".equals(((SecUser) object).getUsername())) {
                Set<String> roleSet = new HashSet<>();
                roleSet.add("admin");
                info.setRoles(roleSet);

                Set<String> stringSet = new HashSet<>();
                stringSet.add("user");
                info.setStringPermissions(stringSet);
            }
            return info;
        }else {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            if ("admin".equals(object)) {
                Set<String> roleSet = new HashSet<>();
                roleSet.add("admin");
                info.setRoles(roleSet);

                Set<String> stringSet = new HashSet<>();
                stringSet.add("user");
                info.setStringPermissions(stringSet);
            }
            return info;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userCode = (String) authenticationToken.getPrincipal();

        //从数据库获取用户信息
        SecUser userInfo = userService.getUserByUserCode(userCode);
        if (userInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userCode+"salt"));
        return simpleAuthenticationInfo;
    }
}
