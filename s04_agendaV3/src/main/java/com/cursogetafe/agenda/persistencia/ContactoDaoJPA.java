package com.cursogetafe.agenda.persistencia;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.cursogetafe.agenda.modelo.Contacto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

@Repository("contactoDao")
@Profile({"jpa", "default"})
public class ContactoDaoJPA implements ContactoDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ContactoDaoJPA() {
	}
	
	@Autowired
	public ContactoDaoJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void insertar(Contacto c) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public void actualizar(Contacto c) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public boolean eliminar(int idContacto) {
		em = emf.createEntityManager();
		Contacto eliminar = em.find(Contacto.class, idContacto);
		if (eliminar != null) {
			try {
				em.getTransaction().begin();
				em.remove(eliminar);
				em.getTransaction().commit();
				return true;
			} catch(Exception e) {
				e.printStackTrace();  // hacer un log
				em.getTransaction().rollback();
				return false;
			} finally {
				em.close();
			}
		} else
			return false;
	}

	@Override
	public boolean eliminar(Contacto c) {
		return eliminar(c.getIdContacto());
	}

	// Debe retornar el contacto con sus telefonos y correos
	@Override
	public Contacto buscar(int idContacto) {
		em = emf.createEntityManager();
		String jpql = 
			"select c from Contacto c "
			+ "left join fetch c.telefonos "
			+ "left join fetch c.correos "
			+ "where c.idContacto = :id";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		q.setParameter("id", idContacto);
		Contacto buscado = q.getSingleResultOrNull();
		em.close();
		return buscado;
	}

	// Debe retornar el contacto con sus telefonos y correos
//	@Override
	public Contacto buscarX(int idContacto) {
		em = emf.createEntityManager();
		Contacto buscado = em.find(Contacto.class, idContacto);
		if(buscado != null) {
			buscado.getTelefonos().size();
			buscado.getCorreos().size();
		}
		em.close();
		return buscado;
	}
	
	// Debe retornar los contactos sin telefonos ni correos
	@Override
	public Set<Contacto> buscar(String cadena) {
		em = emf.createEntityManager();
		String jpql = 
			"select c from Contacto c "
			+ "where c.nombre like :cad"
			+ " or c.apellidos like :cad"
			+ " or c.apodo like :cad";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		q.setParameter("cad", "%" + cadena + "%");
		
		HashSet<Contacto> resu = new HashSet<Contacto>(q.getResultList());
		em.close();
		return resu;
	}

	// Debe retornar los contactos sin telefonos ni correos
	@Override
	public Set<Contacto> buscarTodos() {
		em = emf.createEntityManager();
		String jpql = "select c from Contacto c";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		
		HashSet<Contacto> resu = new HashSet<Contacto>(q.getResultList());
		em.close();
		return resu;
	}

}
