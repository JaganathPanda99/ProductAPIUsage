package com.example.ProductAPIsUsage.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
//
//@Getter
//@Setter

@Entity
public class Product {

    @Id
    String id;
    String name;
    String category;
    String description;


}
