package com.goit.todolist.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AuthController {
    private final AuthService adminService;

    @GetMapping("")
    public ModelAndView get() {
        if (!adminService.hasAuthority("ROLE_admin")){
            return new ModelAndView("access-denied").addObject("user", adminService.getUserName());
        }
        return new ModelAndView("admin");
    }
}
