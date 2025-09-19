 package com.cursogetafe.jpa.ejemplo12muchosamuchos;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos_03")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipo;
	private String equipo;
	
	@ManyToMany
	@JoinTable(name = "equipos_jugadores_03", // nombre de la tabla relacion, el detalle de la relacion.
		joinColumns = @JoinColumn(name = "idequipo"), // nombre del fk de la tabla relacion
		inverseJoinColumns = @JoinColumn(name = "idjugador")) // nombre de la otra fk de la tabla relacion  Las fk's estan en la tabla formada por la relacion		
	private Set<Jugador> jugadores;
	

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEquipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return idEquipo == other.idEquipo;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", jugadores=" + jugadores + "]";
	}
	
	

}
