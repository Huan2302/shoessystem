package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Category;
import com.shoes.customer.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/manager/category")
    public ModelAndView home() {
        List<Category> listCategory = categoryService.listAll();
        ModelAndView mav = new ModelAndView("admin/category/index");
        mav.addObject("listCategory", listCategory);
        return mav;
    }

    @RequestMapping("/manager/category/new")
    public String newCategoryForm(Map<String, Object> model,HttpServletRequest request) {
        Category category = new Category();
        model.put("category", category);
        return "admin/category/add";
    }

    @RequestMapping(value = "/manager/category/new", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("category") Category category, HttpServletResponse response, RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");
        re.addFlashAttribute("msg", MessageConstant.ADD_SUSSCESS);
                categoryService.save(category);
        return "redirect:/manager/category";
    }

    @RequestMapping(value = "/manager/category/edit", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("category") Category category, HttpServletResponse response, RedirectAttributes re) {
        response.setCharacterEncoding("utf-8");
        re.addFlashAttribute("msg", MessageConstant.EDIT_SUSSCESS);
        categoryService.save(category);
        return "redirect:/manager/category";
    }

    @RequestMapping("/manager/category/edit")
    public ModelAndView editCategoryForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("admin/category/edit");
        Category category = categoryService.get(id);
        mav.addObject("category", category);
        return mav;
    }

    @RequestMapping("/manager/category/delete")
    public String deleteAccountForm(@RequestParam long id, RedirectAttributes re) {
        categoryService.delete(id);
        re.addFlashAttribute("msg", MessageConstant.DELETE_SUSSCESS);
        return "redirect:/manager/category";
    }
}
