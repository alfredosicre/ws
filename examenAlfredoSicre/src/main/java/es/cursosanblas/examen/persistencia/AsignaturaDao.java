package es.cursosanblas.examen.persistencia;

import java.util.Map;
import java.util.Set;

import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;

public interface AsignaturaDao {

	/**
	 * Inserta una nueva asignatura
	 * @param asignatura a insertar
	 * @return true si la inserción fue correcta, false en caso contrario
	 */
	public void insertar(Asignatura asignatura); // hecho ESTO ESTA MAL
	
	/**
	 * Actualiza una asignatura
	 * @param asignatura a modificar
	 * @return true si la actualización fue correcta, false en caso contrario
	 */
	public boolean actualizar(Asignatura asignatura); // hecho
	
	/**
	 * Elimina una asignatura
	 * @param asignatura a eliminar
	 * @return true si se eliminino correctamente, false en caso contrario
	 */
	public boolean eliminar(Asignatura asignatura); // hecho
	
	/**
	 * Busca una asignatura por su id
	 * La asignatura debe cargar toda su información. No debe quedar ningún atributo en modo Lazy
	 * @param idAsignatura a buscar
	 * @return la asignatura buscada o null en caso que no exista o falle
	 */
	public Asignatura buscar(int idAsignatura); // hecho
	
	/**
	 * Retorna todas las asignaturas que imparte un profesor. No se deben cargar los alumnos que la cursan
	 * @param profesor
	 * @return un Set con las asignaturas impartidas por ese profesor. En caso que no imparta ninguna, retorna un Set vacío.
	 */
	public Set<Asignatura> buscarPorProfesor(Profesor profesor); // hecho

	/**
	 * Busca todas las asignaturas existentes. No se deben cargar los alumnos que la cursan.
	 * @return un Map conformado por el idAsignatura y la asignatura
	 */
	public Map<Integer, Asignatura> buscarTodas(); // hecho

	/**
	 * Retorna todas las asignaturas que no tienen asignado un profesor. No se deben cargar los alumnos que la cursan
	 * 
	 * @return un Set con las asignaturas que no tienen asignado un profesro. En caso que no imparta ninguna, retorna un Set vacío.
	 */
	public Set<Asignatura> buscarSinProfesor(); // hecho
	

}
