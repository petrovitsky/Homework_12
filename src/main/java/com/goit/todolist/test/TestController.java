package com.goit.todolist.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test")
@Controller
public class TestController {
    @GetMapping
    public ModelAndView getTestHtml(){
        return new ModelAndView("list");
    }
}

