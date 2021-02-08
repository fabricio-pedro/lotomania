package com.lotomania.api.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;

public class ApostadorForm {

@NotBlank(message = "Esse campo é obrigatorio")	
@Email( message="O email informado não é está no formato válido")
private String email;
private int qtdNumAposta;

 
 public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getQtdNumAposta() {
	return qtdNumAposta;
}

public void setQtdNumAposta(int qtdNumAposta) {
	this.qtdNumAposta = qtdNumAposta;
}
 
}

