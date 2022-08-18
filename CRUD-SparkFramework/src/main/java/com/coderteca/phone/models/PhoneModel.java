package com.coderteca.phone.models;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PhoneModel
 */
@Entity
@Table(name = "phone")
public class PhoneModel implements Comparable,Serializable {
	@Id
	@Column(name = "id",length = 20)
	private String id;

	@Column(name = "model")
	private String modelo;
	
	@Column( name = "mark" )
	private String marca;
	
	@Column( name = "memory" )
	private float memoria;

	public PhoneModel() {
	}

	public PhoneModel(String id, String marca, String modelo, float memoria) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.memoria = memoria;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof PhoneModel) {
			PhoneModel phoneParameter = (PhoneModel) o;
			return this.id.compareToIgnoreCase(phoneParameter.id);
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof PhoneModel) {
			PhoneModel phoneParameter = (PhoneModel) obj;
			return this.id.equalsIgnoreCase(phoneParameter.id);
		}
		return super.equals(obj);
	}

	// Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getMemoria() {
		return memoria;
	}

	public void setMemoria(float memoria) {
		this.memoria = memoria;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Phone:{ id:" + this.id + ", model:" + this.modelo + ", mark:"+this.marca+", memory"+this.memoria+"}";
	}

}
