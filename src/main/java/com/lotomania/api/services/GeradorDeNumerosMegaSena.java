package com.lotomania.api.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lotomania.api.exceptions.QuantidadeDeNumerosException;

@Component
@Qualifier("MegaSena")
public class GeradorDeNumerosMegaSena implements GeradorDeNumerosAposta {
  private Set<Integer> numeros=new HashSet<>();
  private Random aposta=new Random();	
	@Override
	public String gerarNumeros(int n) {
		n=n==0 ? 6: n;
		
		if(n<6 ||n>15) {
		 throw new QuantidadeDeNumerosException("Quantidade de numeros incorreta para geraçao da aposta");	
		}
		 this.numeros=new HashSet<>();
		 while (numeros.size()<n) {
			 
		      numeros.add(1+aposta.nextInt(59));	 
		     }
		 StringBuilder sequenciaDeNumeros=new StringBuilder();
	     numeros.stream().forEach((x->{
	    	 sequenciaDeNumeros.append(x+" ");
	     }));
	  return sequenciaDeNumeros.toString();	 
	}

	
}
