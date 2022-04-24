package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.OderDetailService;
import com.shoes.customer.service.OderService;
import com.shoes.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller(value = "oderControllerOfAdmin")
public class OderController {
    @Autowired
    private OderService oderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OderDetailService oderDetailService;

    @RequestMapping("/manager/oder")
    public String loadOder(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.getUserType() == 0) {
            List<Oder> oders = oderService.listAll();
            model.addAttribute("listOder", oders);
        } else {
            return "redirect:/dang-nhap";
        }
        return "admin/oder/index";
    }

    @RequestMapping("/manager/oder/handle")
    public String handle(@RequestParam long id, RedirectAttributes re) {
        Oder oder = oderService.get(id);
        if (oder.getStatus() != 0) {
            oderService.handle(id);
            re.addFlashAttribute("msg", MessageConstant.HANDLE);
        } else {
            re.addFlashAttribute("msg_err", MessageConstant.HANDLE_ERR);
        }
        return "redirect:/manager/oder";
    }

    @RequestMapping("/manager/oder/new")
    public String add(HttpSession session, Model model) {
        model.addAttribute("listProduct", productService.listAll());
        return "admin/oder/add";
    }

    @RequestMapping(value = "/manager/oder/new", method = RequestMethod.POST)
    public String addOder(HttpSession session, Model model
            , @RequestParam(value = "listProductOder") List<Long> list
            , @RequestParam(value = "listQuantity") List<Integer> listQuantity
            , RedirectAttributes re) {
        User user = (User) session.getAttribute("user");

        Oder oder = saveOder(user);
        List<OderDetail> oderDetails = new ArrayList<>();
        float sum = 0;
        int index = 0;
        for (Long item : list) {
            OderDetail oderDetail = new OderDetail();
            oderDetail.setOder(oder);
            oderDetail.setProduct(productService.get(item));
            oderDetail.setQuantity(listQuantity.get(index));
            oderDetail.setUnitPrice(productService.get(item).getPrice());
            oderDetail.setTotal(oderDetail.getUnitPrice() * listQuantity.get(index));

            oderDetailService.save(oderDetail);
            oderDetails.add(oderDetail);
            sum = oderDetail.getTotal() + sum;
            index++;
        }
        oder.setOders(oderDetails);
        oder.setTotal(sum);

        oderService.save(oder);
        re.addFlashAttribute("msg", MessageConstant.ADD_ODER);
        return "redirect:/manager/oder";
    }

//    @RequestMapping(value = "/manager/oder/delete")
//    public String hideOder(){
//        return "";
//    }

//    @RequestMapping(value = "/manager/oder/edit")
//    public String edit(){
//
//        return "";
//    }


    private Oder saveOder(User user) {
        Oder oder = new Oder();
        oder.setOderDate(new Date());
        oder.setStatus(1);
        oder.setUser(user);
        oder.setOders(null);
        oderService.save(oder);
        return oder;
    }
}
