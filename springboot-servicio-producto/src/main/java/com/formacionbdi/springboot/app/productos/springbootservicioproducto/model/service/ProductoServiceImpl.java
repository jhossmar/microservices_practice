package com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findALL() {
       
        return (List<Producto> )productoDao.findAll();
        
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        
        // orElse retorna si no se encuentra un producto con ese id
        return productoDao.findById(id).orElse((null));
    }

    
}