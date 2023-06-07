package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

@Slf4j
@Controller
//@RestController
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if(StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方式是：{}", "mainPage");
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null) {
//            return "main";
//        } else {
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
        return "main";

    }
}
