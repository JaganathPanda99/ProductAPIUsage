package com.example.ProductAPIsUsage.controllers;


import com.example.ProductAPIsUsage.exception.productNotFoundException;
import com.example.ProductAPIsUsage.models.Product;
import com.example.ProductAPIsUsage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private  ProductService productService;

    // GET /products/{id}
    @GetMapping( "/products/{id}")
//    @GetMapping( "/hello/{name}"  )
    public ResponseEntity<Product> getProductById( @PathVariable("id") int productId ) throws productNotFoundException {

//        if(  productId < 0 || productId > 20 ) {
//            return new ResponseEntity<>(  HttpStatusCode.valueOf(400));
//        }
         Product product = productService.getProduct(productId);

        return new ResponseEntity<>(product , HttpStatusCode.valueOf(200));

    }

    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<String> getProductException( productNotFoundException e ){
        return new ResponseEntity<>( e.getMessage(), HttpStatusCode.valueOf(400) );

    }



}
