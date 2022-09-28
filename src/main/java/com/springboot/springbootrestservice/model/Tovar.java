package com.springboot.springbootrestservice.model;

import lombok.Data;

@Data
public class Tovar {
    private String name, category;
    private int id,price,ostatok,dostavka_price,sale;
  /*  private final float rating;

    Tovar() {
        rating = 0;
    }*/

}
