package com.marmuz.spring.http.controller;

import com.marmuz.spring.database.entity.Role;
import com.marmuz.spring.dto.UserReadDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/api/v1")
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request, @ModelAttribute("userReadDto") UserReadDto userReadDto){
        return "greeting/hello";
    }

    @GetMapping("/hello/{id}")
    public String hello2(Model model,
                              @RequestParam("age") Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String sessionId,
                              @PathVariable("id") Integer id){
        return "greeting/hello";
    }
    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user, Model model){
        model.addAttribute("user", user);
        return "greeting/bye";
    }
}
