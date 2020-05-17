package com.formaciondcli.springboot.app.productos.item.springbootitem.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Item;
import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("itemServiceRestTempleate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar/", Producto[].class));
        return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());

    }

    @Override
    public Item findById(Long id,Integer cantidad) {
        Map<String,String> pathVariable = new HashMap<String,String>();
        pathVariable.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}",Producto.class,pathVariable);
        return new Item(producto,cantidad);
    }
    
}