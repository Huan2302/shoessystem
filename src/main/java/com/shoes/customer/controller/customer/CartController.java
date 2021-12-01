package com.shoes.customer.controller.customer;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.BrandService;
import com.shoes.customer.service.CategoryService;
import com.shoes.customer.service.OderDetailService;
import com.shoes.customer.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

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

    @RequestMapping("/gio-hang")
    public ModelAndView getCart(){
        ModelAndView mav = new ModelAndView("public/cart");
        return mav;
    }

    @RequestMapping("/gio-hang/del")
    private String del(@RequestParam long id,@RequestParam long oderId,@RequestParam float total
            ,@RequestParam float oderTotal
            , RedirectAttributes re){
        try{
            oderService.editTotal(oderTotal-total,oderId);
            oderDetailService.delete(id);
            re.addFlashAttribute("msg", MessageConstant.DELETE_SUSSCESS);
        }catch (Exception e){
            re.addFlashAttribute("msg", MessageConstant.DELETE_ERROR);
            return "redirect:/gio-hang?err=1";
        }
        return "redirect:/gio-hang";
    }

    @RequestMapping("/pay")
    private String pay(@RequestParam long id,RedirectAttributes re){
        oderService.pay(id);
        re.addFlashAttribute("msg",MessageConstant.PAY_SUSSCESS);
        return "redirect:/gio-hang";
    }
}
