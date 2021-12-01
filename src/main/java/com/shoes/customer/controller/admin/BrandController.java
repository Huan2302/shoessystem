package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Brand;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.BrandService;
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

@Controller(value = "brandControllerOfAdmin")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/manager/brand")
    public String home(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        ModelAndView mav = null;
        if (user!=null && user.getUserType()==0){
            List<Brand> listBrand = brandService.listAll();
            model.addAttribute("listBrand", listBrand);
        }else {
            return "redirect:/dang-nhap";
        }
        return "admin/brand/index";
    }

    @RequestMapping("/manager/brand/new")
    public String newBrandForm(Map<String, Object> model, HttpServletRequest request) {
        Brand brand = new Brand();
        model.put("brand", brand);
        return "admin/brand/add";
    }

    @RequestMapping(value = "/manager/brand/new", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("brand") Brand brand, BindingResult rs , HttpServletResponse response, RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");
        if(rs.hasErrors()) {
            return "admin/brand/add";
        }
                brandService.save(brand);
        re.addFlashAttribute("msg", MessageConstant.ADD_SUSSCESS);
        return "redirect:/manager/brand";
    }

    @RequestMapping(value = "/manager/brand/edit", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("brand") Brand brand, HttpServletResponse response, RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");
        brandService.save(brand);
        re.addFlashAttribute("msg", MessageConstant.EDIT_SUSSCESS);
        return "redirect:/manager/brand";
    }

    @RequestMapping("/manager/brand/edit")
    public ModelAndView editBrandForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("admin/brand/edit");
        Brand brand = brandService.get(id);
        mav.addObject("brand", brand);
        return mav;
    }

    @RequestMapping("/manager/brand/delete")
    public String deleteAccountForm(@RequestParam long id, RedirectAttributes re) {
        try {
            brandService.delete(id);
            re.addFlashAttribute("msg", MessageConstant.DELETE_SUSSCESS);
            return "redirect:/manager/brand";
        }catch (Exception e){
            re.addFlashAttribute("msg_err", MessageConstant.DELETE_ERROR);
            return "redirect:/manager/brand";
        }
    }
}
