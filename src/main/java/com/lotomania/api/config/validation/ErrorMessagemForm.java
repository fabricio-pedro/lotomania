package com.lotomania.api.config.validation;
 
public class ErrorMessagemForm  {
 private String campo;
 private String erro;
public ErrorMessagemForm(String campo, String erro) {
	super();
	this.campo = campo;
	this.erro = erro;
}
public String getCampo() {
	return campo;
}
public String getErro() {
	return erro;
}
 
 
	
}
