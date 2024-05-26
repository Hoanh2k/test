package com.java5.assigment1.ProducDetail;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productdetail")
public class ProductDetailController {
    @Autowired private ProductDetailService productDetailService;

    @GetMapping("")
    public String form(@RequestParam(defaultValue = "0") int page,Model model) {
      int pageSize =2;
      int totalPages= productDetailService.getTotalPages(pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list", productDetailService.getPaginatedList(page,pageSize));
        return "productdetail/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        productDetailService.delete(id);
        return "redirect:/productdetail";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("productdetail", new ProductDetail());
        return "/productdetail/createe";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("productdetail") ProductDetail productdetail, BindingResult result) {
        if (result.hasErrors()) {
            return "/productdetail/createe";
        }
        productDetailService.add(productdetail);
        return "redirect:/productdetail";
    }

    @GetMapping("/detail/{id}")
    public String detailForm(Model model,@PathVariable String id){
        model.addAttribute("productdetail",productDetailService.finByID(id));
        return "/productdetail/detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model,@PathVariable String id){
        model.addAttribute("pd",productDetailService.finByID(id));
        model.addAttribute("productdetail", new ProductDetail());
        return "/productdetail/update";
    }


    @PostMapping("/update")
    public String detailForm(Model model,@Valid @ModelAttribute("productdetail") ProductDetail productdetail,BindingResult result){
        if (result.hasErrors()) {
            return "/productdetail/update";
        }
        productDetailService.update(productdetail);
        return "redirect:/productdetail";
    }


    @GetMapping("/search")
    public String search(@RequestParam("code") String code, Model model){
        List<ProductDetail> listC = new ArrayList<>();
        listC.add(productDetailService.searchName(code));
        model.addAttribute("list" , listC);
        return "productdetail/index";
    }

}
