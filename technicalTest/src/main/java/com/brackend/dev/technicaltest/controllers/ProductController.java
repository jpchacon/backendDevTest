package com.brackend.dev.technicaltest.controllers;

import com.brackend.dev.technicaltest.model.response.SimilarProduct;
import com.brackend.dev.technicaltest.business.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{productId}/similar")
    public ResponseEntity<SimilarProduct> getSimilarProducts(@NotNull @PathVariable("productId") Long productId){
        SimilarProduct products = productService.getProducts(productId);
        return new ResponseEntity<SimilarProduct>(products, HttpStatus.OK);
    }
}
