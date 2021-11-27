package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired private CategoryService categoryService;
    @Autowired private ProductService productService;
    @Autowired private BrandService brandService;
    @Autowired private OderService oderService;
    @Autowired private OderDetailService oderDetailService;

    @GetMapping(value = {"/danh-muc/{id}","/danh-muc"})
    public ModelAndView home(@PathVariable(name = "id",required = false) Long id,HttpSession session){
        if (id == null){
            id = 1l;
        }
        ModelAndView mav = new ModelAndView("public/c-product");

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
        mav.addObject("listById",productService.getProductByCategoryId(id));
        return mav;
    }


}
