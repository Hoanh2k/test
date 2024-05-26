package com.java5.assigment1;

import com.java5.assigment1.Staff.Staff;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    StaffService staffService;
    @GetMapping("")
    public String form(){
        return "login";
    }

    @PostMapping("/a")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        Model model, HttpSession session){
        Staff staff = staffService.getByUserAndPass(userName,passWord);
        if(staff != null){
            model.addAttribute("user", userName);
            session.setAttribute("user", staff);
            return "homepage";

        }else {
            model.addAttribute("message","Sai tài khoản, mật khẩu");
            return "login";
        }
    }
}
