package com.mv.APIRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mv.APIRest.models.Estabelecimento;


public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
	
	//Estabelecimento findById(long id);
}
