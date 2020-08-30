package com.formaciondcli.springboot.app.productos.item.springbootitem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Item;
import com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity.Producto;
import com.formaciondcli.springboot.app.productos.item.springbootitem.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
private static Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    @Qualifier("itemServiceFein")
    //@Qualifier("itemServiceRestTempleate") //to change Rest Template
    public ItemService itemService;

    @Value("${configuracion.text}")
    private String texto;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();        
    }

    @HystrixCommand (fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id,cantidad);
    }

    /**
     * 
     * @param id
     * @param cantidad
     * @return   default item
     * This function return a defaultItem when Producto-service doesn't work!
     */
    public Item metodoAlternativo(Long id, @PathVariable Integer cantidad){
 
        Item item = new Item();
        Producto producto = new Producto();
        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sozy");
        producto.setPrecio(500.00);
        item.setProducto(producto);
        return item;

    }

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){
        log.info(texto);
        Map<String, String > json = new HashMap<>();
        json.put("texto",texto);
        json.put("puerto",puerto);
        return new ResponseEntity<Map<String, String >>(json,HttpStatus.OK);
    }

}