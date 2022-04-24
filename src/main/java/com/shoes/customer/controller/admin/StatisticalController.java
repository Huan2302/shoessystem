package com.shoes.customer.controller.admin;

import com.shoes.customer.service.StatisticalService;
import com.shoes.customer.utils.WritePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class StatisticalController {
    @Autowired private StatisticalService service;

    @RequestMapping("/danh-thu")
    public String baocao(HttpServletRequest request, HttpServletResponse response){

        final  String dirPathName = request.getServletContext().getRealPath("/download");
        File dirFile = new File(dirPathName);
        if (!dirFile.exists()){
            dirFile.mkdir();
        }
        String fileName = "Danhthu.csv";

        String filePathName = dirPathName + File.separator + fileName; //duong đẫn thư mục

        service.createCSV(filePathName);
        try(OutputStream out = response.getOutputStream()){
            response.setContentType("APPLICATION/OCTET-STREAM");

//            force to download
            response.setHeader("Content-Disposition",
                    "attachment; filename=Danhthu.csv");

            FileInputStream in = new FileInputStream(filePathName);

            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            in.close();
            out.flush();
            File oldFile = new File(filePathName);
            if (oldFile.exists()){
                oldFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/home";
    }
}
