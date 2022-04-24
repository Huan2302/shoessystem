package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Category;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/manager/category")
    public String home(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user!=null && user.getUserType()==0){
            List<Category> listCategory = categoryService.listAll();
            model.addAttribute("listCategory", listCategory);
        }else {
            return "redirect:/dang-nhap";
        }
        return "admin/category/index";
    }

    @RequestMapping(value = "/manager/category/new", method = RequestMethod.GET)
    public String newCategoryForm(Map<String, Object> model,HttpServletRequest request) {
        Category category = new Category(); // cần thêm 1 cái category mới
        model.put("category", category); //put key value
        return "admin/category/add";
    }
//mi cần new 1 cái category đúng khoogn-> thì nhập vô cho ta cái id name
    @RequestMapping(value = "/manager/category/new", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category
            , HttpServletResponse response
            , RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");//tiếng việt
        re.addFlashAttribute("msg", MessageConstant.ADD_SUSSCESS);
        categoryService.save(category);
        return "redirect:/manager/category"; //get :http://localhost:8080/shopshoesSystem_war_exploded/manager/category
    }

    @RequestMapping(value = "/manager/category/edit", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("category") Category category
            , HttpServletResponse response
            , RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");
        re.addFlashAttribute("msg", MessageConstant.EDIT_SUSSCESS);
        categoryService.save(category);
        return "redirect:/manager/category";
    }

    @RequestMapping(value = "/manager/category/edit", method = RequestMethod.GET)
    public ModelAndView editCategoryForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("admin/category/edit");
        Category category = categoryService.get(id);
        mav.addObject("category", category);
        return mav;
    }

    @RequestMapping("/manager/category/delete")
    public String deleteAccountForm(@RequestParam long id, RedirectAttributes re) {
        try {
            categoryService.delete(id);
            re.addFlashAttribute("msg", MessageConstant.DELETE_SUSSCESS);
            return "redirect:/manager/category";
        }catch (Exception e){
            re.addFlashAttribute("msg_err", MessageConstant.DELETE_ERROR);
            return "redirect:/manager/category";
        }
    }
}
