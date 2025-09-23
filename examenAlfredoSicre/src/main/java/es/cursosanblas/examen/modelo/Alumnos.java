package es.cursosanblas.examen.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "alumnos")
public class Alumnos implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // estoy diciendo que la clave primaria es isPersona
	private int idPersona;
	private String matricula;
	private int anio_inscripcion;
	public int getIdPersona() {
		return idPersona;
	}
	
	// entre los alumnos y las asignatturas debe existir una relacion bidireccional
	
	@ManyToMany
	@JoinTable(name = "asignaturas", // nombre de la tabla relacion, el detalle de la relacion.
		joinColumns = @JoinColumn(name = "id_asignatura"), // nombre del fk de la tabla relacion
		inverseJoinColumns = @JoinColumn(name = "id_persona")) // nombre de la otra fk de la tabla relacion  Las fk's estan en la tabla formada por la relacion		
	private Set<Asignatura> asignaturas;
	
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAnio_inscripcion() {
		return anio_inscripcion;
	}
	public void setAnio_inscripcion(int anio_inscripcion) {
		this.anio_inscripcion = anio_inscripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anio_inscripcion, idPersona, matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnos other = (Alumnos) obj;
		return anio_inscripcion == other.anio_inscripcion && idPersona == other.idPersona
				&& Objects.equals(matricula, other.matricula);
	}
	
	public Alumnos(int idPersona, String matricula, int anio_inscripcion) {
		super();
		this.idPersona = idPersona;
		this.matricula = matricula;
		this.anio_inscripcion = anio_inscripcion;
	}

}
	