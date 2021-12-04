package com.shoes.customer.controller.customer;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping(value = {"/danh-muc/{id}","/danh-muc"})
//    public ModelAndView home(@PathVariable(name = "id",required = false) Long id,HttpSession session){
//        if (id == null){
//            id = 1l;
//        }
//        ModelAndView mav = new ModelAndView("public/c-product");
//        mav.addObject("name","Danh mục");
//        mav.addObject("listById",productService.getProductByCategoryId(id));
//        return mav;
//    }

    @GetMapping(value = {"/thuong-hieu/{id}","/thuong-hieu"})
    public ModelAndView brand(@PathVariable(name = "id",required = false) Long id,
                              @RequestParam(value = "sort",required = false)String sort){
        if (id == null){
            id = 1l;
        }
        ModelAndView mav = new ModelAndView("public/c-product");
        if (sort==null){
            sort="az";
        }
        if (sort.equals("low")){
            mav.addObject("listById",productService.sortBrandPriceASC(id));
        }else if(sort.equals("high")){
            mav.addObject("listById",productService.sortBrandPriceDESC(id));
        }else if(sort.equals("za")){
            mav.addObject("listById",productService.sortBrandNameDESC(id));
        }else {
            mav.addObject("listById",productService.sortBrandNameASC(id));
        }
        mav.addObject("name","Thương hiệu");
        return mav;
    }

    @GetMapping(value = {"/danh-muc/{id}","/danh-muc"})
    public ModelAndView categorysort(@PathVariable(name = "id",required = false) Long id,
                                     @RequestParam(value = "sort",required = false)String sort){
        if (id == null){
            id = 1l;
        }
        if (sort==null){
            sort="az";
        }
        ModelAndView mav = new ModelAndView("public/c-product");
        if (sort.equals("low")){
            mav.addObject("listById",productService.sortCatPriceASC(id));
        }else if(sort.equals("high")){
            mav.addObject("listById",productService.sortCatPriceDESC(id));
        }else if(sort.equals("za")){
            mav.addObject("listById",productService.sortCatNameDESC(id));
        }else {
            mav.addObject("listById",productService.sortCatNameASC(id));
        }
        mav.addObject("name","Danh mục");
        return mav;
    }

}
