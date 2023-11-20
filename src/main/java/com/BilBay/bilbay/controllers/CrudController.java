package com.BilBay.bilbay.controllers;

import java.util.List;

public interface CrudController<T> {
    List<T> findAll();

    T findById(Long id);

    T create(T entity);

    T update(Long id, T entity);

    void delete(Long id);
}
