package modelo;

import modelo.Producto;
import modelo.Fabricante;
import config.Config;
import jakarta.persistence.EntityManager;

public class Test01 {
	
	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		Producto p = em.find(Producto.class, 4);
		System.out.println(p);
		
	}

}
