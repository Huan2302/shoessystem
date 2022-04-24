package com.shoes.customer.controller;

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

    @Autowired
    private UserService userService;

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
    public String registerpost(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("address") String address) {
        userService.register(email, StringUtil.md5(password), name,phoneNumber,address);
        return "redirect:/dang-nhap";
    }

    //get: chuyến hướng đến url mình cần -> parameter id=1
    //product detail id=1
    //http://localhost:8080/shopshoesSystem_war_exploded/san-pham/20

    //post vẫn lấy dc product detail . nhưng mà nó ẩn đi id
    //http://localhost:8080/shopshoesSystem_war_exploded/san-pham
    //KHI MÀ NHẬP FORM THÌ HAY DÙNG POSTMAPPING
}
