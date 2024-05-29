package com.lucas.productregister.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World, all are working here.";
    }
}
