package com.springboot.springbootrestservice.model;

public class Tovar {
    private String name, category;
    private int id,price,ostatok,dostavka_price,sale;
  /*  private final float rating;

    Tovar() {
        rating = 0;
    }*/

    public Integer getId(){return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    public int getOstatok() {return ostatok;}

    public void setOstatok(int ostatok) {this.ostatok = ostatok;}

    public int getDostavka_price() {return dostavka_price;}

    public void setDostavka_price(int dostavka_price) {this.dostavka_price = dostavka_price;}

    /*public float getRating() {return rating;}*/

    public int getSale() {return sale;}

    public void setSale(int sale) {this.sale = sale;}
}
