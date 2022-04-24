package com.shoes.customer.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.shoes.customer.entity.Product;
import com.shoes.customer.service.ProductService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WritePDF {

    public void write(List<Product> list, String excelFilePath){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(excelFilePath));

            document.open();

            BaseFont courier = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.EMBEDDED);
            Font font = new Font(courier, 12, Font.NORMAL);
            Chunk chunk = new Chunk("",font);
            document.add(chunk);

            //Khởi tạo một table có 3 cột
            PdfPTable table = new PdfPTable(5);
            //Khởi tạo 3 ô header
            PdfPCell header1 = new PdfPCell(new Paragraph("STT"));
            PdfPCell header2 = new PdfPCell(new Paragraph("TEN SAN PHAM"));
            PdfPCell header3 = new PdfPCell(new Paragraph("DON VI"));
            PdfPCell header4 = new PdfPCell(new Paragraph("SO LUONG"));
            PdfPCell header5 = new PdfPCell(new Paragraph("GHI CHU"));
            //Thêm 3 ô header vào table
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);
            table.addCell(header4);
            table.addCell(header5);

            float sum = 0;
            int index =1;
            for (Product item : list){
                PdfPCell data1 = new PdfPCell(new Paragraph(String.valueOf(index++)));
                PdfPCell data2 = new PdfPCell(new Paragraph(String.valueOf(item.getName())));
                PdfPCell data3 = new PdfPCell(new Paragraph("VND"));
                PdfPCell data4 = new PdfPCell(new Paragraph(String.valueOf(item.getStock())));
                PdfPCell data5 = new PdfPCell(new Paragraph(""));
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);
                table.addCell(data5);
            }

            Font f=new Font(Font.FontFamily.TIMES_ROMAN,32.0f,Font.UNDERLINE,BaseColor.BLACK);
            Paragraph paragraph1 = new Paragraph("BAO CAO TON KHO",f);
            paragraph1.setIndentationLeft(100);
            paragraph1.setIndentationRight(100);
            paragraph1.setAlignment(Element.ALIGN_CENTER);

            Paragraph paragraph3 = new Paragraph("\n\n");
            Paragraph paragraph6 = new Paragraph("\n");

            Paragraph paragraph4 = new Paragraph("Ngay bao cao .../.../...");
            paragraph4.setIndentationLeft(100);
            paragraph4.setIndentationRight(100);
            paragraph4.setAlignment(Element.ALIGN_CENTER);

            //tao chu ki
            PdfPTable table2 = new PdfPTable(2);
            PdfPCell headerc1 = new PdfPCell(new Paragraph("Nguoi lap bao cao\n(Ky va ghi ro ho ten)"));
            headerc1.setBorder(Rectangle.NO_BORDER);
            headerc1.setVerticalAlignment(Element.ALIGN_LEFT);
            PdfPCell headerc2 = new PdfPCell(new Paragraph("              Ngay ... thang ... nam ...\n              Nguoi phu trach xac nhan\n" +
                    "              (Ky va ghi ro ho ten)"));
            headerc2.setBorder(Rectangle.NO_BORDER);
            headerc2.setVerticalAlignment(Element.ALIGN_LEFT);
            table2.addCell(headerc1);
            table2.addCell(headerc2);

            document.add(paragraph1);
            document.add(paragraph6);
            document.add(paragraph4);
            document.add(paragraph3);
            document.add(table);
            document.add(paragraph6);
            document.add(table2);
//            document.add(paragraph2);
//            document.addAuthor("vo tuong huan");
//            document.add(paragraph5);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WritePDF writePDF = new WritePDF();
        List<Product> list = new ProductService().listAll();
       writePDF.write(list,"img");

    }
}
