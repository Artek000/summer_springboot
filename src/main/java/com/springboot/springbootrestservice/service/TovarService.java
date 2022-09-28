package com.springboot.springbootrestservice.service;

import com.springboot.springbootrestservice.model.Tovar;

import java.util.List;

public interface TovarService {
    void create(Tovar tovar);

    List<Tovar> readAll();

    Tovar read(int id);

    boolean update(Tovar tovar, int id);

    boolean delete(int id);

    int about();

    void save_tovars();


}
