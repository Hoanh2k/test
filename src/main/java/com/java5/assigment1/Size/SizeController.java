package com.java5.assigment1.Size;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/size")
public class SizeController {
    @Autowired
    SizeSrvice sizeSrvice;

    @GetMapping("/data")
    public String fillData(@RequestParam(defaultValue = "0") int page,Model model){
        int pageSize =2;
        int totalPages = sizeSrvice.getTotalPages(pageSize);
        List<Size> list = sizeSrvice.getPaginatedList(page,pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list", list);
        return "size/index";
    }

    @GetMapping("/add")
    public String store(Model model){
        model.addAttribute("size",new Size());
        return "size/createe";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("size") Size size, BindingResult result){
        if(result.hasErrors()){
            return "size/createe";
        }
        sizeSrvice.create(size);
        return "redirect:/size/data";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        Size size = sizeSrvice.getById(id);
        model.addAttribute("s", size);
        model.addAttribute("size", new Size());
        return "size/update";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("size") Size s, BindingResult result){
        if(result.hasErrors()){
            return "size/update";
        }
        sizeSrvice.update(s);
        return "redirect:/size/data";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        sizeSrvice.delete(id);
        return "redirect:/size/data";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
          Size size =  sizeSrvice.getById(id);
          model.addAttribute("s",size);
        return "size/detail";
    }


    @GetMapping("/search")
    public String search(@RequestParam("code") String code, Model model){
        List<Size> listC = sizeSrvice.getByCode(code);
        model.addAttribute("list" , listC);
        return "size/index";
    }

}
