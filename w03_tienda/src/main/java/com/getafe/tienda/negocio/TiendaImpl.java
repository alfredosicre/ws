package com.getafe.tienda.negocio;
	
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.getafe.tienda.modelo.Fabricante;
import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.persistencia.FabricanteDao;
import com.getafe.tienda.persistencia.FabricanteDaoImpl;
import com.getafe.tienda.persistencia.ProductoDao;
import com.getafe.tienda.persistencia.ProductoDaoImpl;

public class TiendaImpl implements Tienda {
	
	private ProductoDao pDao;
	private FabricanteDao fDao;
	
	public TiendaImpl() {
		pDao = new ProductoDaoImpl();
		fDao = new FabricanteDaoImpl();
	}
		
	@Override
	public Set<Producto> getProductos(){
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDesc());
		resu.addAll(pDao.findAll());
	return resu;
	}

	@Override
	public Set<Producto> getProductos(String descripcion){
		Set<Producto> resu = new TreeSet<Producto>(getComparatorProductoDescLambda());
		resu.addAll(pDao.findByDescripcion(descripcion));
		return resu;
	}
	
	private Comparator<Producto> getComparatorProductoDesc(){
		return new Comparator<Producto>() {
			
			@Override
			public int compare(Producto o1, Producto o2) {
				Collator col = Collator.getInstance(new Locale("es"));
				return col.compare(o1.getProducto(), o2.getProducto());
			}	
		};
	}
	
	private Comparator<Producto> getComparatorProductoDescLambda01(){ // // lo mismo que arriba pero con expresiones lambda
		return (p1,p2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(p1.getProducto(), p2.getProducto());	
		};
	}
	
	private Comparator<Producto> getComparatorProductoDescLambda() { // mismo que lo de arriba pero con expresiones lambda. Esta está por Id de producto
	    return (p1, p2) -> p1.getIdProducto() - p2.getIdProducto();
	       
	}
	
	// Fabricante:
	private Comparator<Fabricante> getComparatorFabricante() { // mismo que lo de arriba pero con expresiones lambda. 
		Collator col = Collator.getInstance(new Locale("es"));
	    return (f1, f2) -> col.compare(f1.getFabricante(), f2.getFabricante());
	}

	@Override
	public Set<Fabricante> getFabricantes() {
		Set<Fabricante> resu = new TreeSet<Fabricante>(getComparatorFabricante());
		resu.addAll(fDao.findAll());
		return resu;
	}
}