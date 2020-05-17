package com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.dao;

import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.entity.Producto;

import org.springframework.data.repository.CrudRepository;


public interface ProductoDao extends CrudRepository< Producto, Long> {

}