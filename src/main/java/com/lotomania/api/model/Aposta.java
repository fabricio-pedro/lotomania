package com.lotomania.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aposta {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id;
private String numeros;
private LocalDateTime dataAposta=LocalDateTime.now();
@ManyToOne(fetch = FetchType.LAZY)
@Cascade(CascadeType.SAVE_UPDATE)
@JsonIgnore
private Apostador apostador;
public Aposta() {
	// TODO Auto-generated constructor stub
}


public Aposta(String numeros, Apostador apostador) {
	super();
	this.numeros = numeros;
	this.apostador = apostador;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNumeros() {
	return numeros;
}
public void setNumeros(String numeros) {
	this.numeros = numeros;
}
public LocalDateTime getDataAposta() {
	return dataAposta;
}
public void setDataAposta(LocalDateTime dataAposta) {
	this.dataAposta = dataAposta;
}
public Apostador getApostador() {
	return apostador;
}
public void setApostador(Apostador apostador) {
	this.apostador = apostador;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Aposta other = (Aposta) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


	
}
