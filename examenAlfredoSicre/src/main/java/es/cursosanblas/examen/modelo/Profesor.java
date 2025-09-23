package es.cursosanblas.examen.modelo;

import java.io.Serializable;
import java.util.Set;
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
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_persona;
	private String nro_seg_social;
	
	@OneToMany(mappedBy = "profesor")
	private Set<Asignatura>  asignatura;
	
	public Profesor() {
	}
	
	public Profesor(int id_persona, String nro_seg_social) {
		super();
		this.id_persona = id_persona;
		this.nro_seg_social = nro_seg_social;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNro_seg_social() {
		return nro_seg_social;
	}

	public void setNro_seg_social(String nro_seg_social) {
		this.nro_seg_social = nro_seg_social;
	}
	
}
