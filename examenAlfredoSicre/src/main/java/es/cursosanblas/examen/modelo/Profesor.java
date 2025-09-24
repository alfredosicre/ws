package es.cursosanblas.examen.modelo;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Embeddable
@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

	private String nro_seg_social;
	
	@Column(name = "nro_seg_social")
	private Set<Asignatura>  asignatura;
	
	public Profesor() {
	}
	
	public Set<Asignatura> getAsignatura() {
		return asignatura;
	}

	public Profesor(int idPersona, String dni, String nombre, String apellido1, String apellido2, String telefono,
			String direccion, String ciudad) {
		super(idPersona, dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
	}

	public String getNro_seg_social() {
		return nro_seg_social;
	}

	public void setNro_seg_social(String nro_seg_social) {
		this.nro_seg_social = nro_seg_social;
	}

	
	
}
