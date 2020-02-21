package cn.tsxygfy.blog.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class LoginController {

    @GetMapping("/admin")
    public String adminLogin(){
        return "redirect:/admin/index.html";
    }

}
