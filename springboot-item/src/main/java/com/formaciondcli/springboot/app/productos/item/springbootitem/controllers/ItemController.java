package com.formaciondcli.springboot.app.productos.item.springbootitem.controllers;

import java.util.List;

import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Item;
import com.formaciondcli.springboot.app.productos.item.springbootitem.models.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
    @Autowired
    //@Qualifier("itemServiceFein")
    @Qualifier("itemServiceRestTempleate") //to change Rest Template
    public ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();        
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id,cantidad);
    }

}