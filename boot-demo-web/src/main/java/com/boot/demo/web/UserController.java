package com.boot.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.boot.demo.api.ExampleService;
import com.boot.demo.dao.entity.User;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private ExampleService exampleService;
	
	@RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = exampleService.getUserById(userId);
        System.out.println(JSON.toJSONString(user));
        model.addAttribute("user", user);
        return "user";
    }
}
