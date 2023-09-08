package com.mustafatatlikatik.springBootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/")
    public String get(){
        return "Laptop 1";
    }
    @GetMapping("/products")
    public String get2(){
        return "Masaüstü 1";
    }
}
