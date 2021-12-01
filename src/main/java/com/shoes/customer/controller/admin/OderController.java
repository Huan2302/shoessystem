package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Category;
import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller(value = "oderControllerOfAdmin")
public class OderController {
    @Autowired private OderService oderService;

    @RequestMapping("/manager/oder")
    public String loadOder(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (user!=null && user.getUserType()==0){
            List<Oder> oders = oderService.listAll();
            model.addAttribute("listOder", oders);
        }else {
            return "redirect:/dang-nhap";
        }
        return "admin/oder/index";
    }

    @RequestMapping("/manager/oder/handle")
    public String handle(@RequestParam long id, RedirectAttributes re){
        Oder oder = oderService.get(id);
        if (oder.getStatus()!=0){
            oderService.handle(id);
            re.addFlashAttribute("msg", MessageConstant.HANDLE);
        }else {
            re.addFlashAttribute("msg_err", MessageConstant.HANDLE_ERR);
        }
        return "redirect:/manager/oder";
    }
}
