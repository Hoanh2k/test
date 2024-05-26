package com.java5.assigment1.Color;

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
@RequestMapping("/color")
public class ColorController {
    @Autowired
    ColorService colorService;

    @Autowired
    StaffService staffService;

    @GetMapping("/data")
    public String fillData(@RequestParam(defaultValue = "0") int page,Model model , HttpSession session) {
//        Staff staff = (Staff) session.getAttribute("user");
//        if(staff == null){
//            return null;
//        }
        int pageSize = 2;
        List<Color> colorList = colorService.getPaginatedList(page, pageSize);
        int totalPages = colorService.getTotalPages(pageSize);

        model.addAttribute("list", colorList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "color/index";

    }

    @GetMapping("/add")
    public String store(Model model){
        model.addAttribute("color", new Color());
        return "color/createe";
    }

    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("color") Color color, BindingResult result, Model model){
    if(result.hasErrors()){
        return "color/createe";
    }
        colorService.create(color);
        return "redirect:/color";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        Color cl = colorService.getById(id);
        model.addAttribute("color", cl);
        return "color/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        colorService.delete(id);
        return "redirect:/color";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") String id,Model model){
        Color cl = colorService.getById(id);
        model.addAttribute("cl", cl);
        model.addAttribute("color", new Color());
        return "color/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("color") Color cl,BindingResult result){
        if(result.hasErrors()){
            return "color/update";
        }
        colorService.update(cl);
        return "redirect:/color";
    }


    @GetMapping("/search")
    public String timkiem(@RequestParam("code") String code, Model model){
        model.addAttribute("list", colorService.getByCode(code));
        return "color/index";
    }

}
