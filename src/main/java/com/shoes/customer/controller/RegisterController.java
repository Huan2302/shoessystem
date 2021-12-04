package com.shoes.customer.controller;

import com.shoes.customer.entity.User;
import com.shoes.customer.service.UserService;
import com.shoes.customer.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public String register(HttpSession session, ModelMap model,
                           @RequestParam(value = "error", required = false) String error) {
        session.setAttribute("user", null);
        try {
            if (error.equals("true")) {
                model.put("error", "Tên đăng nhập hoặc mật khẩu không đúng !!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "register";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String registerpost(@RequestParam("name")String name,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password) {
        userService.register(email, StringUtil.md5(password),name);
        return "redirect:/dang-nhap";
    }

}
