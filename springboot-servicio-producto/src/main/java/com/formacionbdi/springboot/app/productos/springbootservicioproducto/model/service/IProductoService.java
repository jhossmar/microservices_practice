package com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.entity.Producto;

public interface IProductoService {
    public List<Producto> findALL();
    public Producto findById(Long id);

}