package com.shoes.customer.service;

import com.shoes.customer.entity.*;
import com.shoes.customer.repository.OderDetailReponsitory;
import com.shoes.customer.repository.OderReponsitory;
import com.shoes.customer.repository.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OderDetailService {
    @Autowired private OderDetailReponsitory repo; //DI
    @Autowired private ProductReponsitory productReponsitory;
    @Autowired private OderReponsitory oderReponsitory;
    @Autowired private OderDetailReponsitory oderDetailReponsitory;
    @Autowired private CategoryService categoryService;
    @Autowired private OderService oderService;


    public void save(OderDetail oder) {
        repo.save(oder);
    }

    public List<OderDetail> listAll() {
        return (List<OderDetail>) repo.findAll();
    }

    public OderDetail get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<OderDetail> findAllByOderDetailId(long id) {
        return (List<OderDetail>) repo.findAllByOderDetailId(id);
    }

    public Integer addProduct(long productId, int quantity, User user){
        System.out.println(quantity);
        int addedQuantity = quantity;
        Product product = productReponsitory.findById(productId).get();

        Oder oder = oderReponsitory.findOderByUser(user);

        System.out.println("1");
        OderDetail oderDetail=null;
        System.out.println("2");
        if (oder != null && oder.getStatus() == 0){
            oderDetail = repo.findByProductAndOder(product,oder);
            if (oderDetail != null){
                addedQuantity = oderDetail.getQuantity() + quantity;
                oderDetail.setQuantity(addedQuantity);
                oderDetail.setTotal(addedQuantity*oderDetail.getUnitPrice());
            }else {
                oderDetail = new OderDetail();
                oderDetail.setOder(oder);
                oderDetail.setProduct(product);
                oderDetail.setQuantity(quantity);
                oderDetail.setUnitPrice(product.getPrice());
                oderDetail.setTotal(quantity*(product.getPrice()));
            }
//            oderDetailReponsitory.save(oderDetail);
            oder.setOderDate(new Date());
            oder.setTotal(oder.getTotal()+oderDetail.getTotal());
        }else {
            oder = new Oder();
            oder.setUser(user);
            oder.setStatus(0);
            oder.setOderDate(new Date());

            oderDetail = new OderDetail();
            oderDetail.setOder(oder);
            oderDetail.setProduct(product);
            oderDetail.setQuantity(quantity);
            oderDetail.setUnitPrice(product.getPrice());
            oderDetail.setTotal(quantity*(product.getPrice()));
            System.out.println("3");
            oder.setTotal(oderDetail.getTotal());
        }
        System.out.println("dung");

        oderService.save(oder);
        System.out.println("4");
        save(oderDetail);
        System.out.println("5");
        return addedQuantity;
    }
}


