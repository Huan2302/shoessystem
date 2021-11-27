package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.*;
import com.shoes.customer.repository.OderDetailReponsitory;
import com.shoes.customer.repository.OderReponsitory;
import com.shoes.customer.repository.ProductReponsitory;
import com.shoes.customer.service.OderDetailService;
import com.shoes.customer.service.OderService;
import com.shoes.customer.service.ProductService;
import com.shoes.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OderController {
    @Autowired private ProductService productService;
    @Autowired private OderService oderService;
    @Autowired private OderDetailService oderDetailService;
    @Autowired private ProductReponsitory productReponsitory;
    @Autowired private OderReponsitory oderReponsitory;
    @Autowired private OderDetailReponsitory repo; //DI

    @PostMapping("/add-cart")
    public String addCart(HttpSession session,@RequestParam("id")long id,@RequestParam("quantity") int quantity){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            oderDetailService.addProduct(id,quantity,user);
            return "redirect:/dang-nhap";
        }else {
            return null;
        }
    }
    @GetMapping("/add-cart")
    public String addCart1(HttpSession session,@RequestParam("id")long id,@RequestParam("quantity") int quantity){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            oderDetailService.addProduct(id,quantity,user);
            return "redirect:/gio-hang";
        }else {
            return "redirect:/dang-nhap";
        }
    }

//    public List<OderDetail> showCart(HttpSession session){
//        User user = (User) session.getAttribute("user");
//        if (user!=null){
//            Oder oder = oderService.findOderByUser(user);
//            List<OderDetail> list = oderDetailService.findAllByByOder(oder);
//            return list;
//        }else {
//            return null;
//        }
//    }
}
