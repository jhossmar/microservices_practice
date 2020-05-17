package com.formaciondcli.springboot.app.productos.item.springbootitem.models.entity;

public class Item {
    private Producto producto;
	private Integer cantidad;
	private Double total;
   
    public Item(){

    }

    public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.total= calcular();

	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
    }
    
    public  Double  calcular(){
        return producto.getPrecio()*cantidad.doubleValue();
    }

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
    
}