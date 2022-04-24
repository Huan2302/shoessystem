package com.shoes.customer.service;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.OderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticalService {

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String NEW_LINE = ",";

    @Autowired
    private OderService oderService;
    @Autowired
    private OderDetailService oderDetailService;

    private int getMonth() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonthValue());
        return localDate.getMonthValue();
    }

    private List<Oder> getListOderToMonth() {
        List<Oder> oderList = oderService.listAll();
        List<Oder> listResult = new ArrayList<>();
        for (Oder item : oderList) {
            int getMonth = item.getOderDate().getMonth() + 1;
            if (getMonth == getMonth()) {
                listResult.add(item);
            }
        }
        return listResult;
    }

    public List<OderDetail> getListoderDetailToMonth() {
        List<Oder> list = getListOderToMonth();
        List<OderDetail> oderDetails = new ArrayList<>();
        for (Oder item : list) {
            List<OderDetail> temp = oderDetailService.findAllByOder(item);
            for (OderDetail detail : temp) {
                oderDetails.add(detail);
            }
        }
        return oderDetails;
    }

    public void createCSV(String finame ) {
        //write csv in spring
        OutputStreamWriter fileWriter = null;
        float sum = 0;
        try {
            fileWriter = new OutputStreamWriter(new FileOutputStream(finame), StandardCharsets.UTF_8);
            fileWriter.append(String.valueOf("Tên sản phẩm"));
            fileWriter.append(NEW_LINE);
            fileWriter.append(String.valueOf("Số lượng"));
            fileWriter.append(NEW_LINE);
            fileWriter.append(String.valueOf("Đơn giá"));
            fileWriter.append(NEW_LINE);
            fileWriter.append(String.valueOf("Tổng tiền"));
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (OderDetail item : getListoderDetailToMonth()) {
                fileWriter.append(String.valueOf(item.getProduct().getName()));
                fileWriter.append(NEW_LINE);
                fileWriter.append(String.valueOf(item.getQuantity()));
                fileWriter.append(NEW_LINE);
                fileWriter.append(String.valueOf(item.getTotal()));
                fileWriter.append(NEW_LINE);
                fileWriter.append(String.valueOf(item.getUnitPrice()));
                fileWriter.append(NEW_LINE_SEPARATOR);
                sum += item.getUnitPrice();
            }
            fileWriter.append(String.valueOf("Tổng danh thu:") + sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
