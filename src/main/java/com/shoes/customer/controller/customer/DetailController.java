package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DetailController {
    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;
    @Autowired private BrandService brandService;
    @Autowired private OderService oderService;
    @Autowired private OderDetailService oderDetailService;

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

    @GetMapping("/san-pham/{id}")
    public ModelAndView home(@PathVariable(name = "id") Long id, HttpSession session){
        ModelAndView mav = new ModelAndView("public/detail-product");
//
//        User user = (User) session.getAttribute("user");
//        List<OderDetail> list = new ArrayList<>();
//        if (user!=null){
//            Oder oder = oderService.findOderByUser(user);
//            list = oderDetailService.findAllByOderDetailId(oder.getId());
//        }else {
//            list=null;
//        }
//        mav.addObject("listCart",list);
//
//        mav.addObject("listCategory", categoryService.listAll());
//        mav.addObject("listBrand",brandService.listAll());
        mav.addObject("product",productService.get(id));
        return mav;
    }
}
