package cn.lcools.controller;

import cn.lcools.bean.SecAuthorize;
import cn.lcools.bean.SecFunctions;
import cn.lcools.bean.SecUser;
import cn.lcools.service.ISecAuthorizeInterface;
import cn.lcools.service.ISecRoleFunGrantInterface;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    ISecRoleFunGrantInterface roleFunGrantService;
    @Autowired
    ISecAuthorizeInterface authorizeService;

    @GetMapping
    public String getIndex() {
        return "forward:/login";
    }

    @GetMapping(value = "/user")
    public String getUserInfo(Model model){
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof SecUser) {
            SecUser userInfo = (SecUser)object;
            List<SecFunctions> functions = roleFunGrantService.selectFuncsByUserId(userInfo.getUserId());
            model.addAttribute("functions",functions);
            return "/user/main";
        }else {
            return "/user/main";
        }
    }
    @GetMapping(value = "/getUser")
    @ResponseBody
    public String getUser(){
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof SecUser) {
            SecUser userInfo = (SecUser) object;
            return userInfo.toString();
        }
        return "";
    }
    @GetMapping(value = "/getRole")
    @ResponseBody
    public String getRole(){
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof SecUser) {
            SecUser userInfo = (SecUser) object;
            List<SecAuthorize> authorizes = authorizeService.selectByUserId(userInfo.getUserId());
            return authorizes.get(0).toString();
        }
        return "";
    }
}
