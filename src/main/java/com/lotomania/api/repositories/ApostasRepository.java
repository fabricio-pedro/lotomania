package com.lotomania.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lotomania.api.model.Aposta;

public interface ApostasRepository extends JpaRepository<Aposta, Long> {
    @Query("SELECT a from Aposta a,Apostador ap where ap.email=:email  and a.apostador.id=ap.id ORDER BY a.dataAposta" )
	public List<Aposta> findByEmail(@Param("email") String email);
}
