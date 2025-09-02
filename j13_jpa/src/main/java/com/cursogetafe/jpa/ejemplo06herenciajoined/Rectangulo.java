package com.cursogetafe.jpa.ejemplo06herenciajoined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rectangulo_02")
public class Rectangulo extends Figura {
	
	@Column(name = "l1")
	private double lado1;
	@Column(name = "l2")
	private double lado2;
	
	public Rectangulo(double x, double y, double lado1, double lado2) { // constructor
		super(x, y); // constructor de mi padre, lo primero que hace un constructor es llamar al padre, siempre lo primero
		this.lado1 = lado1;
		this.lado2 = lado2;	
	}
	public Rectangulo() {}
	

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	// calculo del area
	@Override
	public double area() {
		return lado1 * lado2;
	}
	// calculo del perimetro
	@Override
	public double perimetro() {
		return 2 * (lado1 + lado2);
	}
	
	public boolean equals(Object otro) {
		if(!super.equals(otro)) return false;
		Rectangulo r = (Rectangulo)otro;
		return this.lado1 == r.lado1 && this.lado2 == r.lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}

	@Override
	public double diametro() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
