package com.lotomania.api.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.lotomania.api.model.Aposta;

public class ApostaDto {
  
  private String email;
  private String numerosDaAposta;
  private LocalDateTime dataAposta;
  
  public ApostaDto(Aposta aposta) {
	 this.email=aposta.getApostador().getEmail();
	 this.dataAposta=aposta.getDataAposta();
	 this.numerosDaAposta=aposta.getNumeros();
  }
  
  public String getEmail() {
	return email;
  }
  public String getNumerosDaAposta() {
	return numerosDaAposta;
  }
  public String getDataAposta() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	return formatter.format(this.dataAposta);
  }
  
  public static List<ApostaDto> convertListaApostas(List<Aposta> apostas){
	  return apostas.stream().map(ApostaDto::new).collect(Collectors.toList());
  }
  
	

}
