package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserTooManyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "12345789"),
                new User("wangwu", "12345"),
                new User("xiaoliu", "gf45789"),
                new User("liqi", "1757"));
        model.addAttribute("users", users);

        if(users.size() > 3) {
            throw new UserTooManyException();
        }
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

}
