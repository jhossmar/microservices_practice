package com.formacionbdi.springboot.app.productos.springbootservicioproducto.controllers;

import java.util.List;

import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.entity.Producto;
import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControler {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/listar")
    public List<Producto> listar(){
        return productoService.findALL();
    }
    
    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id){
        return productoService.findById(id);
    }
    
    
}