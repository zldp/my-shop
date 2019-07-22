package com.zlsoft.my.shop.web.admin.web.controller;

import com.zlsoft.my.shop.domain.TbUser;
import com.zlsoft.my.shop.domain.User;
import com.zlsoft.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dp
 * @version 1.0.0
 * @date 2019-07-11 14:41
 */
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;
    @GetMapping(value = {"", "login"})
    public String login(){
        return "login";
    }

    @PostMapping(value = "login")
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request, Model model) {
        TbUser login = tbUserService.login(email, password);

        if (login == null) {
            model.addAttribute("message", "账号或者密码错误");
            return login();
        } else {
            request.getSession().setAttribute("user", login);
            return "redirect:/main";
        }

    }
}
