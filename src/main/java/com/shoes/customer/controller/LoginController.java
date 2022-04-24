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

@Controller(value = "loginControllerOfAdmin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String login(HttpSession session, ModelMap model,
                        @RequestParam(value = "error", required = false) String error) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/trang-chu";
        } else {
            session.setAttribute("user", null);
            try {
                if (error.equals("true")) {
                    model.put("error", "Tên đăng nhập hoặc mật khẩu không đúng !!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return "login";
        }
    }

    //người dùng gửi request đến server -> mapping -> service ->
    // repository (if db có user thì trả về user ,ngược lại trả về null)
    //-> controller
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
    public String login(HttpSession session, ModelMap model, @RequestParam("email") String email,
                        @RequestParam("password") String password) {
        if (email.equals("") || password.equals("")) {
            return "redirect:/dang-ky?error=true";
        }

        User user = new User();
        user = userService.login(email, StringUtil.md5(password)); //huanvo -1234
        session.setAttribute("user", user);

        if (user == null) {
            return "redirect:/dang-nhap?error=true";
        }

        if (user.getUserType() == 0) {
            return "redirect:/trang-chu";
        } else if (user.getUserType() == 1) {
            return "redirect:/trang-chu";
        }
        return "redirect:/dang-nhap?error=true";
    }


    @RequestMapping(value = "dang-xuat", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap model,
                         @RequestParam(value = "error", required = false) String error) {
        session.removeAttribute("user");
        return "redirect:/trang-chu";
    }
}
