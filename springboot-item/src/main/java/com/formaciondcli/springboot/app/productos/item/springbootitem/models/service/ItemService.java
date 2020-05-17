package com.formaciondcli.springboot.app.productos.item.springbootitem.models.service;

import java.util.List;

import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Item;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id,Integer cantidad);
}