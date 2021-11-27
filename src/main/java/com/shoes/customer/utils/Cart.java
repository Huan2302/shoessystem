package com.shoes.customer.utils;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import com.shoes.customer.entity.User;
import com.shoes.customer.service.OderDetailService;
import com.shoes.customer.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    @Autowired
    private OderService oderService;
    @Autowired private OderDetailService oderDetailService;

    public List<OderDetail> showCart(User user){
        List<OderDetail> list = new ArrayList<>();
        Oder oder = oderService.findOderByUser(user);
        return oderDetailService.findAllByOderDetailId(oder.getId());
    }
}
