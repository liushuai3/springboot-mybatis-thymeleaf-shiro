package cn.lcools.controller;

import cn.lcools.bean.SecUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: UserController
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/20 15:03
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/20     liushuai3           v1.0.0               修改原因
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    @ResponseBody
    @GetMapping(value = "/user")
    public String getUserInfo(){
        Subject subject = SecurityUtils.getSubject();
        boolean ok = subject.isAuthenticated();
        boolean ok2 = subject.hasRole("admin");
        boolean ok3 = subject.isPermitted("user");
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof SecUser) {
            SecUser userInfo = (SecUser)object;
            return userInfo.getUsername()+":"+ok+":"+ok2+":"+ok3;
        }else {
            return object+":"+ok+":"+ok2+":"+ok3;
        }
    }

    @ResponseBody
    @GetMapping(value = "/index")
    public String getUserInfo1() {
        Subject subject = SecurityUtils.getSubject();
        boolean ok = subject.isAuthenticated();
        boolean ok2 = subject.hasRole("admin");
        boolean ok3 = subject.isPermitted("user");
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof SecUser) {
            SecUser userInfo = (SecUser) object;
            return "tt:"+userInfo.getUsername() + ":" + ok + ":" + ok2 + ":" + ok3;
        } else {
            return "tt:" + object + ":" + ok + ":" + ok2 + ":" + ok3;
        }
    }
}
