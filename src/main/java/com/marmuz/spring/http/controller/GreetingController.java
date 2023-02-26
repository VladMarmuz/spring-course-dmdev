package com.marmuz.spring.http.controller;

import com.marmuz.spring.dto.UserReadDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("greeting/hello");
        modelAndView.addObject("user",new UserReadDto(1L,"Ivan"));
        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView,
                              @RequestParam("age") Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String sessionId,
                              @PathVariable("id") Integer id){
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }
    @GetMapping("/bye")
    public ModelAndView bye(@SessionAttribute("user") UserReadDto user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }
}
