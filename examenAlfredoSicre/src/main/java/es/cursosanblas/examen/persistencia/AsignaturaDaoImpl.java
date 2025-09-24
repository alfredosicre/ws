package es.cursosanblas.examen.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.io.Serializable;
import es.cursosanblas.examen.config.Config;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import org.hibernate.LazyInitializationException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class AsignaturaDaoImpl implements AsignaturaDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AsignaturaDaoImpl() {
		emf = Config.getEmf();	
	}
	
	public AsignaturaDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void insertar(Asignatura a) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}
	
	@Override
	public boolean actualizar(Asignatura a) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
 		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		return true;
	}
	
	public boolean eliminar(int idAsignatura) {
		em = emf.createEntityManager();
		Asignatura eliminar = em.find(Asignatura.class, idAsignatura);
		if(eliminar != null) {
			try {
				em.getTransaction().begin();
				em.remove(eliminar);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace(); 
				em.getTransaction().rollback();
				return false;
			}finally {
				em.close();
			}
		} else {
			return false;
		}
	}

	@Override
	public Asignatura buscar(int idAsignatura) {
		em = emf.createEntityManager();
		Asignatura buscado = em.find(Asignatura.class, idAsignatura);
		if(buscado != null) {
			buscado.getAsignatura();
			buscado.getCreditos();
			buscado.getFacultad();
		}
		em.close();
		return buscado;
	}
	
	
	@Override
	public Map<Integer, Asignatura> buscarTodas() { //REVISAR TODO ESTE
		em = emf.createEntityManager();
		String jpql = "select a from asignaturas a";
		
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
	
		HashMap<Integer, Asignatura> resu = new HashMap<Integer, Asignatura>((Map<? extends Integer, ? extends Asignatura>) q.getResultList());
		em.close();
		return resu;
	}

	@Override
	public Set<Asignatura> buscarPorProfesor(Profesor profesor) {
		em = emf.createEntityManager();
		String jpql = "select a from asignaturas a where a.fk_profesor = profesor";
		
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		HashSet<Asignatura> resu = new HashSet<Asignatura>(q.getResultList());
		em.close();
		return resu;

	}

	@Override
	public Set<Asignatura> buscarSinProfesor() {
		em = emf.createEntityManager();
		String jpql = "select a from asignaturas a where a.fk_profesor is null";
		
		TypedQuery<Asignatura> q = em.createQuery(jpql, Asignatura.class);
		HashSet<Asignatura> resu = new HashSet<Asignatura>(q.getResultList());
		em.close();
		return resu;
	}

	@Override
	public boolean eliminar(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return false;
	}
	
}