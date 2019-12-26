package com.mv.APIRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mv.APIRest.models.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	
	Profissional findById(long id);

}
