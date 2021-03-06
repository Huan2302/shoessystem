package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.UserService;
import com.shoes.customer.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller(value = "userControllerOfAdmin")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/manager/user")
    public String home(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        ModelAndView mav = null;
        if (user!=null && user.getUserType()==0){
            List<User> listUser = userService.listAll();
            model.addAttribute("listUser", listUser);
        }else {
            return "redirect:/dang-nhap";
        }
        return "admin/user/index";
    }

    @RequestMapping("/manager/user/new")
    public String newAccountForm(Map<String, Object> model, HttpServletRequest request) {
        User user = new User();
        model.put("user", user);
        return "admin/user/add";
    }

    @RequestMapping(value = "/manager/user/new", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("user") User user, BindingResult rs, @RequestParam("password")String pass
            , HttpServletResponse response, RedirectAttributes rss) {


        if(rs.hasErrors()) {
            return "admin/user/add";
        }
        user.setPassword(StringUtil.md5(pass));
        response.setCharacterEncoding("utf-8");
        userService.save(user);
        rss.addFlashAttribute("msg",MessageConstant.ADD_SUSSCESS);
        return "redirect:/manager/user";
    }

    @RequestMapping(value = "/manager/user/edit", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("account") User user,@RequestParam("password")String pass
            , HttpServletResponse response,RedirectAttributes rs) {
        user.setPassword(StringUtil.md5(pass));
        response.setCharacterEncoding("utf-8");
        userService.save(user);
        rs.addFlashAttribute("msg",MessageConstant.EDIT_SUSSCESS);
        return "redirect:/manager/user";
    }

    @RequestMapping("/manager/user/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        User user = userService.get(id);
        mav.addObject("password",user.getPassword());
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/manager/user/delete")
    public String deleteAccountForm(@RequestParam long id, RedirectAttributes rs) {
        try{
            userService.delete(id);
            rs.addFlashAttribute("msg", MessageConstant.DELETE_SUSSCESS);
            return "redirect:/manager/user";
        }catch (Exception e){
            rs.addFlashAttribute("msg_err", MessageConstant.DELETE_SUSSCESS);
            return "redirect:/manager/user";
        }
    }
}
