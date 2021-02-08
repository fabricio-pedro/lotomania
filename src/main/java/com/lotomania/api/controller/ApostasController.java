package com.lotomania.api.controller;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lotomania.api.dtos.ApostaDto;
import com.lotomania.api.forms.ApostadorForm;
import com.lotomania.api.model.Aposta;
import com.lotomania.api.services.ApostasService;

@RestController
@RequestMapping("/apostas")
public class ApostasController {

@Autowired	
private ApostasService apostasServices;	
	
@PostMapping	
public ResponseEntity<ApostaDto> gerarApostas(@RequestBody @Valid ApostadorForm apostador,UriComponentsBuilder uriBuilder) {
    Aposta aposta=apostasServices.criar(apostador);  
	URI uri=uriBuilder.path("/apostas/{id}").buildAndExpand(aposta.getId()).toUri();
	return ResponseEntity.created(uri).body(new ApostaDto(aposta)) ;
	
  }
@GetMapping
public ResponseEntity<List<ApostaDto>> listaApostas(@RequestBody ApostadorForm form){
 List<ApostaDto> listaView=apostasServices.mostraApostas(form).stream()
		                   .map(ApostaDto::new)
		                   .collect(Collectors
		                    .toList());
 return ResponseEntity.ok(listaView);
}


}
