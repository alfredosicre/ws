package tienda.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFabricante;
	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	
	Set<Fabricante>fabricantes;
	
	public int getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	private String fabricante;
	
	@Override
	public int hashCode() {
		return Objects.hash(fabricante, idFabricante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		return Objects.equals(fabricante, other.fabricante) && idFabricante == other.idFabricante;
	}

	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", fabricante=" + fabricante + "]";
	}
	
	
}
