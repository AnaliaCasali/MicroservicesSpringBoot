package com.formacion.springboot.app.item.service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacion.springboot.app.item.models.Item;
import com.formacion.springboot.app.item.models.Producto;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest; //Debe estar registrado en AppConfig
	
	
	@Override
	public List<Item> findAll() {
		//Arrays.asList convierte el array de productos que devuelve el clienteRest en una lista de productos
		List<Producto>productos =Arrays.asList( clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p-> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto =clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto,cantidad);
	}

}
