package com.java5.assigment1.Invoice;


import com.java5.assigment1.Guest.Guest;
import com.java5.assigment1.Staff.Staff;
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
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    StaffService staffService;

    @GetMapping("")
    public String getHome(@RequestParam(defaultValue = "0") int page,Model model){
       int pageSize =2;
       int totalPages = invoiceService.getTotalPages(pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list",invoiceService.getPaginatedList(page,pageSize));
        return "/invoice/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable String id,HttpSession session){
        Staff currentUser = (Staff) session.getAttribute("user");
        if (currentUser == null || !staffService.isAdmin(currentUser) ) {
//            model.addAttribute("message","Ban  phai đăng nhập");
            return "redirect:/invoice";
        }
        invoiceService.delete(id);
        return "redirect:/invoice";
    }


    @GetMapping("/create")
    public String getFormAdd(Model model, HttpSession session){
        Staff currentUser = (Staff) session.getAttribute("user");
        if (currentUser == null||!staffService.isAdmin(currentUser) ) {
//            model.addAttribute("message","Ban  phai đăng nhập");
            return "redirect:/invoice";
        }
        model.addAttribute("invoice",new Invoice());
        return "/invoice/createe";
    }

    @PostMapping("/add")
    public String Add(Model model, @Valid @ModelAttribute("invoice")Invoice invoice, BindingResult result){
        if(result.hasErrors()){
            return "/invoice/createe";
        }
        invoiceService.add(invoice);
        return "redirect:/invoice";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable String id){

        model.addAttribute("st",invoiceService.finByID(id));
        return "/invoice/detail";
    }

    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable String id){
        model.addAttribute("st",invoiceService.finByID(id));
        model.addAttribute("invoice", new Invoice());
        return "/invoice/update";
    }

    @PostMapping("/update")
    public String update(Model model,@Valid @ModelAttribute("invoice") Invoice invoice,BindingResult result){
        if(result.hasErrors()){
            return "/invoice/update";
        }
        invoiceService.update(invoice);
        return "redirect:/invoice";
    }

    @GetMapping("/search")
    public String search(@RequestParam("id") String id, Model model){
        List<Invoice> listC = invoiceService.getByCode(id);
        model.addAttribute("list" , listC);
        return "invoice/index";
    }

}