package com.shoes.customer.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/manager")
    public String index(){
        return "admin/index";
    }
}