package tienda.test;

import tienda.config.Config;
import tienda.modelo.Producto;
import jakarta.persistence.EntityManager;

public class Test01 {
	
	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		Producto p = em.find(Producto.class, 4);
		System.out.println(p);
		
	}

}
