package com.zlsoft.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dp
 * @version 1.0.0
 * @date 2019-07-11 14:47
 */
@Controller
public class MainController {
    @GetMapping("main")
    public String main(){
        return "main";
    }
}
