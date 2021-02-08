package com.lotomania.api.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Apostador {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
private Long id;
@Column(unique = true, nullable = false)
private String email;
@OneToMany(mappedBy = "apostador")
private Set<Aposta> apostas;

public Apostador() {
	// TODO Auto-generated constructor stub
}

public Apostador( String email) {
	super();
	this.apostas=new HashSet<>();
	this.email = email;
}
public void addAposta(Aposta aposta) {
	 this.apostas.add(aposta);	
		
}
public Set<Aposta> getApostas(){
    return Collections.unmodifiableSet(apostas);
}
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
