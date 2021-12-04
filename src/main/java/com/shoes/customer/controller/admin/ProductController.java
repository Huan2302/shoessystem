package com.shoes.customer.controller.admin;

import com.shoes.customer.constant.MessageConstant;
import com.shoes.customer.entity.*;
import com.shoes.customer.service.BrandService;
import com.shoes.customer.service.CategoryService;
import com.shoes.customer.service.ProductService;
import com.shoes.customer.service.Product_imgService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;
    @Autowired private BrandService brandService;
    @Autowired private Product_imgService productImgService;
    @Autowired private ServletContext context;

    @RequestMapping("/manager/product")
    public String home(HttpSession session,Model model) {
        User user = (User) session.getAttribute("user");
        ModelAndView mav = null;
        if (user!=null && user.getUserType()==0){
            List<Product> listProduct = productService.listAll();
            model.addAttribute("listProduct", listProduct);
        }else {
            return "redirect:/dang-nhap";
        }
        return "admin/product/index";
    }

    @RequestMapping(value = "/manager/product/new", method = RequestMethod.GET)
    public String newArticleForm(Map<String, Object> model, HttpServletRequest request) {
        Product product = new Product();
        List<Category> listCategory = categoryService.listAll();
        List<Brand> listBrand = brandService.listAll();
        model.put("product", product);
        model.put("listCategory", listCategory);
        model.put("listBrand", listBrand);
        return "admin/product/add";
    }

    @RequestMapping(value = "/manager/product/new", method = RequestMethod.POST)
    public String saveArticle (HttpSession session
            , @Valid @ModelAttribute("product") Product product, BindingResult rs, @RequestParam("file") List<MultipartFile> multipartFileList
            , HttpServletRequest request, RedirectAttributes re) {
        if(rs.hasErrors()) {
            return "admin/product/add";
        }
        productService.save(product);
        try {
                User user = (User) session.getAttribute("user");
                if(user != null) {
                    if (!multipartFileList.get(0).getOriginalFilename().equals("")) {
                        for (MultipartFile multipartFile:multipartFileList){
                            String fileName = multipartFile.getOriginalFilename();
                            String getFile = getFileNameServer(fileName);
                            File fileRoot = pathFile(getFile,"img",request);
                            try {
                                multipartFile.transferTo(fileRoot);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Product_img product_img = new Product_img();
                            product_img.setName(getFile);
                            product_img.setProduct(product);
                            productImgService.save(product_img);
                        }
                    }
                    re.addFlashAttribute("msg", MessageConstant.ADD_SUSSCESS);
                }else {
                    return "redirect:/dang-nhap";
                }
        } catch (Exception e) {
            System.out.println("lỗi:====================" + e);
        }
        return "redirect:/manager/product";
    }



    @RequestMapping(value = "/manager/product/edit", method = RequestMethod.POST)
    public String editArticle (HttpSession session
            , @ModelAttribute("product") Product product, @RequestParam("file") List<MultipartFile> multipartFileList
            , HttpServletRequest request, RedirectAttributes re) {
        User user = (User) session.getAttribute("user");
        if(user != null) {
            if (!multipartFileList.get(0).getOriginalFilename().equals("")) {
                productImgService.deleteProduct_imgByProductId(product.getId());
            }
            Category category = categoryService.get(product.getCategory().getId());
            product.setCategory(category);
            Brand brand = brandService.get(product.getBrand().getId());
            product.setBrand(brand);
            productService.save(product);
            try {
                if (!multipartFileList.get(0).getOriginalFilename().equals("")) {
                    for (MultipartFile multipartFile:multipartFileList){
                        String fileName = multipartFile.getOriginalFilename();
                        String getFile = getFileNameServer(fileName);
                        File fileRoot = pathFile(getFile,"img",request);
                        try {
                            multipartFile.transferTo(fileRoot);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Product_img product_img = new Product_img();
                        product_img.setName(getFile);
                        product_img.setProduct(product);
                        productImgService.save(product_img);
                    }
                }
                re.addFlashAttribute("msg", MessageConstant.EDIT_SUSSCESS);

            } catch (Exception e) {
                System.out.println("lỗi:====================");
            }
        }else {
            return "redirect:/dang-nhap";
        }
        return "redirect:/manager/product";
    }


    @RequestMapping("/manager/product/edit")
    public ModelAndView editArticleForm(@RequestParam long id,RedirectAttributes re,HttpSession session) {
        ModelAndView mav = null;
        User user = (User) session.getAttribute("user");
        if(user != null) {
            mav = new ModelAndView("admin/product/edit");
            Product product = productService.get(id);
            List<Category> listCategory = categoryService.listAll();
            List<Brand> listBrand = brandService.listAll();
            List<Product_img> listImg = productImgService.getAllByProductId(product.getId());
            mav.addObject("listImg",listImg);
            mav.addObject("listCategory", listCategory);
            mav.addObject("listBrand", listBrand);
            mav.addObject("product", product);
        }else {
            mav= new ModelAndView("login");
        }
        return mav;
    }

    @RequestMapping("/manager/product/delete")
    public String deleteArticleForm(@RequestParam long id , RedirectAttributes rs) {
        try{
            productImgService.deleteProduct_imgByProductId(id);
            productService.delete(id);
            rs.addFlashAttribute("msg",MessageConstant.DELETE_SUSSCESS);
            return "redirect:/manager/product";
        }catch (Exception e){
            rs.addFlashAttribute("msg_err",MessageConstant.DELETE_ERROR);
            return "redirect:/manager/product";
        }
    }

    //đặt lại tên file
    public String getFileNameServer(String fileName){
        if (!StringUtils.isEmpty(fileName)){
            String extention = FilenameUtils.getExtension(fileName);
            String base = FilenameUtils.getBaseName(fileName);
            StringBuilder builder = new StringBuilder();
            builder.append(base).append("-").append(System.nanoTime()).append(".").append(extention);
            return builder.toString();
        }
        return StringUtils.EMPTY;
    }

    public File pathFile(String fileName,String folder,HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath(""); // trả về đường dẫn tuyệt đối của web(target)
        System.out.println("rootPath:"+rootPath);
        System.out.println("folder:"+folder);
        File disry = new File(rootPath+folder); // đường dẫn folder
        if (!disry.exists()){
            disry.mkdirs();
        }
        File file = new File(rootPath+folder+"/"+fileName);
        System.out.println("filePath:"+rootPath+folder+"/"+fileName);
        return file;
    }
}
