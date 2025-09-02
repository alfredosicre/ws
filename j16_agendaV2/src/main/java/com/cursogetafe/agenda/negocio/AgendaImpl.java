package com.cursogetafe.agenda.negocio;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.cursogetafe.agenda.config.beanFactory;
import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.persistencia.ContactoDao;
import com.cursogetafe.agenda.persistencia.ContactoDaojpa;

public class AgendaImpl implements Agenda {
	
	private ContactoDao cDao;
	
	public AgendaImpl() {
//		cDao = new ContactoDaoMem();
//		cDao = new ContactoDaoMemSerial();
//		cDao = new ContactoDaoJDBC();
//		cDao = new ContactoDaojpa();
		cDao = beanFactory.getContactoDao(); // de la clase beanFactory coje el valor (get) de ContactoDao.
	}

		
	
	// metodo insertar
	@Override
	public void insertarContacto(Contacto c) {
		cDao.insertar(c);
		
	}
	
	// metodo eliminar
	@Override
	public Contacto eliminar(int idContacto) {
		Contacto aEliminar = cDao.buscar(idContacto);
		cDao.eliminar(idContacto);
		return aEliminar;
	}

	@Override
	public boolean eliminar(Contacto c) {
		return eliminar(c.getIdContacto()) != null;
	}

	// actualizar
	@Override
	public void modificar(Contacto c) {
		cDao.actualizar(c);
		
	}

	// necesitamos un comparator para ordenar por apodo. para defir un orden que no es el natural.
	private Comparator<Contacto> getComparatorApodo(){
		return (c1, c2) -> {
			Collator col = Collator.getInstance(new Locale("es"));
			return col.compare(c1.getApodo(), c2.getApodo());
		};
		
	}
	// buscar todos y retornar ordenados por apodo
	@Override
	public Set<Contacto> buscarTodos() {
		Set<Contacto> resu = new TreeSet<Contacto>(getComparatorApodo());
		resu.addAll(cDao.buscarTodos());
		return resu;
		
	}
	// buscar por nombre del contacto
	@Override
	public Set<Contacto> buscarContactoPorNombre(String buscado) {
		Set<Contacto> resu = new TreeSet<Contacto>(getComparatorApodo());
		resu.addAll(cDao.buscar(buscado));
		return resu;
		
	}

	@Override
	public int importarCSV(String fichero) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// buscar por id de contacto
	@Override
	public Contacto buscar(int idContacto) {
		
		return cDao.buscar(idContacto);
	}
	

}
