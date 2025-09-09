package com.getafe.tienda.negocio;

import java.util.Set;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;

public interface Tienda {

	// devuelve todos los productos ordenados por descripcion
	
	Set<Producto> getProductos();
	
	// devuelve los productos que contienen descripcion ordenados por su descripcion
	
	Set<Producto> getProductos(String descripcion);
	
	// Devuelve todos los fabricantes ordenados por el nombre
	Set<Fabricante> getFabricantes();
	
}
