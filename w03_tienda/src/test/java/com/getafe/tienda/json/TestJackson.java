package com.getafe.tienda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.persistencia.ProductoDao;
import com.getafe.tienda.persistencia.ProductoDaoImpl;

public class TestJackson {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		ProductoDao pDao = new ProductoDaoImpl();
		Producto p = pDao.findById(7);
		System.out.println(p);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(p);
		System.out.println(json);   
		
		
	}

}
