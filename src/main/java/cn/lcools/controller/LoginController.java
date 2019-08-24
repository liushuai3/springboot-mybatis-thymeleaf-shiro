package cn.lcools.controller;

import cn.lcools.bean.SecUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: LoginController
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/20 10:20
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/20     liushuai3           v1.0.0               修改原因
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @PostMapping
    public String login(SecUser userInfo){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());

        token.setRememberMe(false);
        try {
            subject.login(token);
        }catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if(subject.isAuthenticated()){
            return "redirect:/user";
        }else {
            token.clear();
            return "redirect:/login";
        }
    }

    @GetMapping
    public String login(HttpServletRequest request,Model model) {
        SecUser userInfo = new SecUser();
            model.addAttribute("secUser", userInfo);
            return "/user/login";
    }

}
