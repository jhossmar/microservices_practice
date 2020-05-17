package com.formaciondcli.springboot.app.productos.item.springbootitem.models.service;

import java.util.List;
import java.util.stream.Collectors;

import com.formaciondcli.springboot.app.productos.item.springbootitem.clientes.ProductoClienteRest;
import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("itemServiceFein")
@Primary
public class ItemServiceFein implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFein;
    
    @Override
    public List<Item> findAll() {
       
        return clienteFein.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        
        return new Item(clienteFein.detalle(id),cantidad);
    }
    
}