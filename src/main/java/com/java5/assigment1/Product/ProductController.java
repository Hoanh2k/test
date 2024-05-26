package com.java5.assigment1.Product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/data")
    public String fillData(@RequestParam(defaultValue = "0") int page,Model model) {
        int pageSize =2;
        int totalPages= productService.getTotalPages(pageSize);
        List<Product> list = productService.getPaginatedList(page,pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list", list);
        return "product/index";

    }

    @GetMapping("/add")
    public String store(Model model) {
        model.addAttribute("product", new Product());
        return "product/createe";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "product/createe";
        }
        productService.create(product);
        return "redirect:/product/data";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Product pd = productService.getById(id);
        model.addAttribute("product", pd);
        return "product/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        productService.delete(id);
        return "redirect:/product/data";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("pd", product);
        model.addAttribute("product", new Product());
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()){
            return "product/update";
        }
        productService.update(product);
        return "redirect:/product/data";
    }

    @GetMapping("/search")
    public String search(@RequestParam("code") String code, Model model) {
        model.addAttribute("list", productService.getByCode(code));
        return "product/index";
    }
}
