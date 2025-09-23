package es.cursosanblas.examen.modelo;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class Asignatura implements Comparable<Asignatura>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignatura")
	private int id_asignatura;
	private String asignatura;
	private int creditos;
	private String facultad;
	
	@ManyToOne
	@JoinColumn(name = "fk_profesor")
	private Profesor profesor;
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, creditos, facultad, id_asignatura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(asignatura, other.asignatura) && creditos == other.creditos
				&& Objects.equals(facultad, other.facultad) && id_asignatura == other.id_asignatura;
	}

	public Asignatura(int id_asignatura, String asignatura, int creditos, String facultad) {
		super();
		this.id_asignatura = id_asignatura;
		this.asignatura = asignatura;
		this.creditos = creditos;
		this.facultad = facultad;
	}

	@Override
	public int compareTo(Asignatura o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Asignatura[] generaAsignatura() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
