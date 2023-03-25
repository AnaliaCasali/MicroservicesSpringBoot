package com.formacion.springboot.app.item.models;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	private Producto producto;
	private Integer cantidad;
	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
		
	}
}
