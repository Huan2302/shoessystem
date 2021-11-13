package com.shoes.customer.controller.admin.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
    @GetMapping("/manager")
    public String index(){
        return "admin/category/index";
    }
}
