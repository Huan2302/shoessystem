package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.*;
import com.shoes.customer.repository.OderDetailReponsitory;
import com.shoes.customer.repository.OderReponsitory;
import com.shoes.customer.repository.ProductReponsitory;
import com.shoes.customer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OderController {
    @Autowired private OderService oderService;
    @Autowired private OderDetailService oderDetailService;
    @Autowired private CategoryService categoryService;
    @Autowired private BrandService brandService;

    @ModelAttribute
    public void modelAtr(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<OderDetail> list = new ArrayList<>();
        Oder oder = new Oder();
        if (user!=null){
            oder = oderService.findOderByUserId(user.getId());
            if ( oder!= null && oder.getStatus()==0){
                list = oderDetailService.findAllByOderDetailId(oder.getId());
                model.addAttribute("oder",oder);
            }
        }else {
            list=null;
        }
        model.addAttribute("listCart",list);
        model.addAttribute("listCategory", categoryService.listAll());
        model.addAttribute("listBrand",brandService.listAll());
    }

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
}
