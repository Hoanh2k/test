package com.java5.assigment1.InvoiceDetail;



import com.java5.assigment1.Invoice.Invoice;
import com.java5.assigment1.Product.Product;
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
@RequestMapping("/invoicedetail")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    StaffService staffService;

    @GetMapping("")
    public String getHome(@RequestParam(defaultValue = "0") int page,Model model) {
        int pageSize=2;
        int totalPages = invoiceDetailService.getTotalPages(pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("list", invoiceDetailService.getPaginatedList(page,pageSize));
        return "/invoicedetail/index";
    }

    @GetMapping("/add")
    public String getFormAdd(Model model, HttpSession session) {
        Staff currentUser = (Staff) session.getAttribute("user");
        if (currentUser == null||!staffService.isAdmin(currentUser)  ) {
//            model.addAttribute("message","Ban  phai đăng nhập");
            return "redirect:/invoicedetail";
        }
        model.addAttribute("invoicedetail", new InvoiceDetail());
        return "/invoicedetail/createe";
    }

    @PostMapping("/add")
    public String Add(Model model, @Valid @ModelAttribute("invoicedetail") InvoiceDetail invoiceDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "/invoicedetail/createe";
        }
        invoiceDetailService.add(invoiceDetail);
        return "redirect:/invoicedetail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, HttpSession session) {
        Staff currentUser = (Staff) session.getAttribute("user");
        if (currentUser == null ||!staffService.isAdmin(currentUser) ) {
//            model.addAttribute("message","Ban  phai đăng nhập");
            return "redirect:/invoicedetail";
        }
        invoiceDetailService.delete(id);
        return "redirect:/invoicedetail";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable String id) {
        model.addAttribute("st", invoiceDetailService.finByID(id));
        return "/invoicedetail/detail";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("st", invoiceDetailService.finByID(id));
        model.addAttribute("invoicedetail", new InvoiceDetail());
        return "/invoicedetail/update";
    }


    @PostMapping("/update")
    public String update(Model model, @Valid @ModelAttribute("invoicedetail") InvoiceDetail invoiceDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "/invoicedetail/update";
        }
        invoiceDetailService.update(invoiceDetail);
        return "redirect:/invoicedetail";
    }


    @GetMapping("/search")
    public String search(@RequestParam("id") String id, Model model){

        model.addAttribute("list" , invoiceDetailService.searchName(id));
        return "invoicedetail/index";
    }

}
