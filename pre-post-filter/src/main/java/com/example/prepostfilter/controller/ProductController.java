package com.example.prepostfilter.controller;

import com.example.prepostfilter.ds.Product;
import com.example.prepostfilter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/sell")
    public List<Product> sellProducts(){
        List<Product> products = new ArrayList<>();
        Collections.addAll(products,
                new Product("beer","Pyae"),
                new Product("whiskey","Pyae"),
                new Product("chocolate","Skywalker")

        );
        return productService.sellProduct(products);
    }

    @GetMapping("/sell2")
    public List<Product> sellProductsV2(){
        return productService.sellProductV2();
    }
}























