package com.mv.APIRest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.APIRest.repository.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.mv.APIRest.models.*;
@RestController
@RequestMapping(value="/api")
@Api(value="APIRest MV")
@CrossOrigin(origins="*")
public class ProfissionalController {
	
	@Autowired
	ProfissionalRepository profissionalRespository;
	
	@GetMapping("/profissional")
	@ApiOperation(value="Retorna todos Profissionais")
	public List<Profissional> listaProfissional(){
		return profissionalRespository.findAll();
	}
	
	@GetMapping("/profissional/{id}")
	@ApiOperation(value="Retorna apenas um Profissional")
	public Profissional idProfissional(@PathVariable(value="id") long id){
		return profissionalRespository.findById(id);
	}
	
	@PostMapping("/profissional")
	@ApiOperation(value="Adiciona um Profissional")
	public Profissional addProfissional(@RequestBody Profissional profissional) {
		return profissionalRespository.save(profissional);
	}
	
	@DeleteMapping("/profissional")
	@ApiOperation(value="Deleta um Profissional")
	public void deletaProfissional(@RequestBody Profissional profissional) {
		profissionalRespository.delete(profissional);
		System.out.print("Profissional Deletado");
	}
	
	@PutMapping("/profissional/{id}")
	@ApiOperation(value="Alterar um Profissional")
	public Profissional alterarProfissional(@RequestBody Profissional profissional) {
		return profissionalRespository.save(profissional);
	}
	
}
