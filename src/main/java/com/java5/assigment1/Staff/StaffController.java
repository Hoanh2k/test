package com.java5.assigment1.Staff;

import com.java5.assigment1.StaffService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;



    @GetMapping("/data")
    public String fillData(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 2;
        List<Staff> staffList = staffService.getPaginatedList(page, pageSize);
        int totalPages = staffService.getTotalPages(pageSize);

        model.addAttribute("list", staffList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "staff/index";
    }

    @GetMapping("/add")
    public String store(Model model){
        model.addAttribute("staff", new Staff());
        return "staff/createe";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("staff") Staff staff, BindingResult result){
        if(result.hasErrors()){
            return "staff/createe";
        }
        staffService.create(staff);
        return "redirect:/staff/data";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, HttpSession session, Model model){

        Staff currentUser = (Staff) session.getAttribute("user");
        if (currentUser == null ) {
            model.addAttribute("message","Ban  phai đăng nhập");
            return "redirect:/staff/data";
        }
//        Boolean staff = staf
        staffService.delete(id);
        return "redirect:/staff/data";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id,Model model){
      Staff staff=  staffService.getById(id);
      model.addAttribute("st", staff);
        return "staff/detail";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        model.addAttribute("staff", new Staff());
        model.addAttribute("st", staffService.getById(id));
        return "staff/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("staff") Staff staff, BindingResult result){
        if(result.hasErrors()){
            return "staff/update";
        }
        staffService.update(staff);
        return "redirect:/staff/data";
    }


    @GetMapping("/search")
    public String search(@RequestParam("userName") String userName, Model model){
        List<Staff> listC = staffService.getByCode(userName);
        model.addAttribute("list" , listC);
        return "staff/index";
    }


}
