package com.example.ProductAPIsUsage.service;

import com.example.ProductAPIsUsage.exception.productNotFoundException;
import com.example.ProductAPIsUsage.models.Product;

public interface ProductService {

    public Product getProduct(int id) throws productNotFoundException;

}
