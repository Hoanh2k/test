package com.java5.assigment1.Guest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestService guestService;

    @GetMapping("/data")
    public String fillData(@RequestParam(defaultValue = "0") int page,Model model){
       int pageSize =2;

        List<Guest> list = guestService.getPaginatedList(page, pageSize);
        int totalPages = guestService.getTotalPages(pageSize);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list" , list);
        return "guest/index";
    }

    @GetMapping("/add")
    public String store ( Model model){

        model.addAttribute("guest" , new Guest());
        return "guest/createe";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("guest") Guest guest, BindingResult result){
        if(result.hasErrors()){
            return "guest/createe";
        }
        guestService.create(guest);
        return "redirect:/guest/data";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        Guest guest = guestService.getById(id);
        model.addAttribute("guest", guest);
        return "guest/detail";
    }

    @GetMapping("/update/{id}")
    public  String edit(@PathVariable("id") String id, Model model){
        Guest guest = guestService.getById(id);
        model.addAttribute("g", guest);
        model.addAttribute("guest" , new Guest());
        System.out.println(guest.toString());
        return "guest/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("guest") Guest g, BindingResult result, Model model){
        if(result.hasErrors()){
            return "guest/update";
        }
        guestService.update(g);
        System.out.println(g.toString());
        return "redirect:/guest/data";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        guestService.delete(id);
        return "redirect:/guest/data";
    }

    @GetMapping("/search")
    public String search(@RequestParam("code") String code, Model model){
        List<Guest> listC = guestService.getByCode(code);
        model.addAttribute("list" , listC);
        return "guest/index";
    }
}
