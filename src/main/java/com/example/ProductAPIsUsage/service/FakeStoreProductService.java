package com.example.ProductAPIsUsage.service;

import com.example.ProductAPIsUsage.dtos.FakeStoreProductServiceDto;
import com.example.ProductAPIsUsage.exception.productNotFoundException;
import com.example.ProductAPIsUsage.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService  implements ProductService {

    @Override
    public Product getProduct(int id) throws productNotFoundException {

/*
   Take the product ID from the input and call this endpoint
   https://fakestoreapi.com/products/
 */
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
//        RestTemplate restTemplate1 = restTemplate;

       FakeStoreProductServiceDto fakeStoreProductServiceDto =  restTemplate.getForObject(url, FakeStoreProductServiceDto.class);
        if( fakeStoreProductServiceDto == null ){
           throw new productNotFoundException("Exception: Product" + id + "not found");
        }
        return convertFakeStoreProductServiceDtoToProduct(fakeStoreProductServiceDto);
    }


    private Product convertFakeStoreProductServiceDtoToProduct(FakeStoreProductServiceDto fakeStoreProductServiceDto) {
        Product product = new Product();
//        product.setName( fakeStoreProductServiceDto.getTitle() );
//        product.setDescription( fakeStoreProductServiceDto.getDescription() );
//        product.setCategory( fakeStoreProductServiceDto.getCategory() );
//        product.setDescription( fakeStoreProductServiceDto.getDescription() );

        return product;
    }
}
