package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.Category;
import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired private CategoryService categoryService;
    @Autowired private BrandService brandService;
    @Autowired private OderService oderService;
    @Autowired private OderDetailService oderDetailService;


    @GetMapping("/trang-chu")
    public ModelAndView home(HttpSession session){
        ModelAndView mav = new ModelAndView("public/index");

        User user = (User) session.getAttribute("user");
        List<OderDetail> list = new ArrayList<>();
        if (user!=null){
            Oder oder = oderService.findOderByUser(user);
            list = oderDetailService.findAllByOderDetailId(oder.getId());
        }else {
            list=null;
        }
        mav.addObject("listCart",list);

        mav.addObject("listCategory", categoryService.listAll());
        mav.addObject("listBrand",brandService.listAll());
        return mav;
    }
}
