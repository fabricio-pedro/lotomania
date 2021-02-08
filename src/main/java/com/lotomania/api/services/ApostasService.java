package com.lotomania.api.services;

import java.util.List;

import com.lotomania.api.dtos.ApostaDto;
import com.lotomania.api.forms.ApostadorForm;
import com.lotomania.api.model.Aposta;

public interface ApostasService {

 public Aposta criar(ApostadorForm form);
 public List<Aposta> mostraApostas(ApostadorForm form);
 
 	
}
