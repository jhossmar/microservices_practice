package com.formacionbdi.springboot.app.productos.springbootservicioproducto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.entity.Producto;
import com.formacionbdi.springboot.app.productos.springbootservicioproducto.model.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControler {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findALL().stream().map(producto -> {
            // producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            producto.setPort((int) port);
            return producto;
        }).collect(Collectors.toList());

    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {// throws Exception{
        Producto producto = productoService.findById(id);
        // producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort((int) port);
        boolean ok = false;
        // if (ok== false){
        // throw new Exception("No se pudo carga el producto");
        // }
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return producto;
    }
    
    
}