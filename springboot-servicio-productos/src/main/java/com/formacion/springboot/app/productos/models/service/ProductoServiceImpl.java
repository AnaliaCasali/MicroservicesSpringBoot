package com.formacion.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.springboot.app.productos.models.entity.Producto;
import com.formacion.springboot.app.productos.models.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
			return (List<Producto>)  productoRepository.findAll();
	}

	@Override
	public Producto findById(Long Id) {
		return productoRepository.findById(Id).orElse(null);
	}

}
