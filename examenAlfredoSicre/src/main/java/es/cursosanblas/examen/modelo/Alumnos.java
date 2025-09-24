package es.cursosanblas.examen.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
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
public class Alumnos extends Persona {
	
	private String matricula;
	@Column(name = "anyo_inscripcion")
	private int anio_inscripcion;
	
	// entre los alumnos y las asignatturas debe existir una relacion bidireccional
	
	@ManyToMany
	@JoinTable(name = "matriculados", // nombre de la tabla relacion, el detalle de la relacion.
		joinColumns = @JoinColumn(name = "fk_alumno"), // nombre del fk de la tabla relacion
		inverseJoinColumns = @JoinColumn(name = "fk_asignaturas")) // nombre de la otra fk de la tabla relacion  Las fk's estan en la tabla formada por la relacion	
	
	private Set<Asignatura> asignaturas;

	public Alumnos() {
	}

	public Alumnos(int idPersona, String dni, String nombre, String apellido1, String apellido2, String telefono,
			String direccion, String ciudad) {
		super(idPersona, dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
		
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

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}
	