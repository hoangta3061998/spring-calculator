package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/calculator"})
public class CalculatorController {
    @GetMapping("/calculate")
    public ModelAndView calculate(@RequestParam(value = "firstOperand") String firstOperand, @RequestParam(value = "secondOperand") String secondOperand, HttpServletRequest request,@RequestParam(value = "operator") String operator) {
        ModelAndView modelAndView = new ModelAndView("/calculator/home");
        double f = Double.parseDouble(request.getParameter("firstOperand"));
        double s = Double.parseDouble(request.getParameter("secondOperand"));
        double result = f;
        switch (operator){
            case "Addition":
                result = f+s;
                break;
            case "Subtraction":
                result = f - s;
                break;
            case "Multiplication":
                result = f*s;
                break;
            case "Division":
                result = f/s;
                break;
        }
        modelAndView.addObject("result",result);
        return modelAndView;


    }
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/calculator/home");
        return modelAndView;
    }
}
