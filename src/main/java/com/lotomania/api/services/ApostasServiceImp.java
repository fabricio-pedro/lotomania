package com.lotomania.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.lotomania.api.dtos.ApostaDto;
import com.lotomania.api.forms.ApostadorForm;
import com.lotomania.api.model.Aposta;
import com.lotomania.api.model.Apostador;
import com.lotomania.api.repositories.ApostadorRepository;
import com.lotomania.api.repositories.ApostasRepository;
@Service
public class ApostasServiceImp implements ApostasService {

   @Autowired	
   @Qualifier("MegaSena")
   private GeradorDeNumerosAposta geradorDeNumeros;
   @Autowired
   private ApostadorRepository apostadorRepository;
   @Autowired
   private ApostasRepository apostasRepository;
   private Aposta aposta;	
   private Apostador apostador;
   
   @Override
   @Transactional
	public Aposta criar(ApostadorForm form) {
		// TODO Auto-generated m
	  Optional<Apostador> apostadorOp= apostadorRepository.findByEmail(form.getEmail());
	  if(apostadorOp.isPresent()) {
	   this.apostador=apostadorOp.get();
	   System.err.println("diga o codigo:"+this.apostador.getId());
	  }else {
		this.apostador=new Apostador(form.getEmail());  
	  }
	  this.aposta=new Aposta(geradorDeNumeros.gerarNumeros(form.getQtdNumAposta()),apostador);   	  
	  System.out.println(geradorDeNumeros.gerarNumeros(6));
	  this.apostador.addAposta(this.aposta);
	  this.apostadorRepository.save(this.apostador);
	  this.apostasRepository.save(this.aposta);
	  return this.aposta;
			  
	   
	
	}

@Override
public List<Aposta> mostraApostas(ApostadorForm form) {
	// TODO Auto-generated method stub
	List<Aposta> listaDeApostas=this.apostasRepository.findByEmail(form.getEmail());
	
	return listaDeApostas;
}

}
