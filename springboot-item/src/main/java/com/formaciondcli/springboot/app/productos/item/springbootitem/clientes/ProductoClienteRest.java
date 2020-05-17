package com.formaciondcli.springboot.app.productos.item.springbootitem.clientes;

import java.util.List;

import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-producto", url= "localhost:8001")
public interface ProductoClienteRest {
    @GetMapping("/listar")
    public List<Producto> listar();
    
    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}