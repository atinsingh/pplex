package com.example.pragraplex.contoller;

import com.example.pragraplex.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/customer")
    public String showAllCustomer(Model model){
        model.addAttribute("title", "Showing Customer");
        model.addAttribute("customers", service.getAllCustomer());
        return "customer";
    }
}
