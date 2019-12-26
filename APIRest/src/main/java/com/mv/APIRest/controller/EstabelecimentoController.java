package com.mv.APIRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mv.APIRest.repository.EstabelecimentoRepository;
import com.mv.APIRest.models.Estabelecimento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="APIRest MV")
@CrossOrigin(origins="*")
public class EstabelecimentoController {

	 @Autowired
	 private EstabelecimentoRepository estabelecimentoRepository;
	 
	 @GetMapping(value="/estabelecimento")
	 @ApiOperation(value="retorna estabelecimentos")
	 public List<Estabelecimento> listaEstabelecimento(){
		 return estabelecimentoRepository.findAll();
	 }
	 @GetMapping(value="/estabelecimento/{id}")
	 @ApiOperation(value="retorna um estabelecimento")
	 public ResponseEntity<Estabelecimento> idEstabelecimento(@PathVariable(value="id") long id) {
		Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
		if(estabelecimento.isPresent())
			return new ResponseEntity<Estabelecimento>(estabelecimento.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 
	 @PostMapping(value="/estabelecimento")
	 @ApiOperation(value="adiciona um estabelecimento")
	 public Estabelecimento addEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		 return estabelecimentoRepository.save(estabelecimento);
	 }
	 
	 @PutMapping(value="/estabelecimento/{id}")
	 @ApiOperation(value="alterar um estabelecimento")
	 public ResponseEntity<Estabelecimento> alteraEstabelecimento(@PathVariable(value="id") long id, @RequestBody Estabelecimento novoEstabelecimento ) {
		 Optional<Estabelecimento> oldEstabelecimento = estabelecimentoRepository.findById(id);
		 if(oldEstabelecimento.isPresent()) {
			 Estabelecimento estabelecimento = oldEstabelecimento.get();
			 estabelecimento.novoEstabelecimento(novoEstabelecimento.getNome(), novoEstabelecimento.getEndereco(),novoEstabelecimento.getTelefone(), novoEstabelecimento.getTelefone2());
			 estabelecimentoRepository.save(estabelecimento);
			 return new ResponseEntity<Estabelecimento>(estabelecimento, HttpStatus.OK);
		 }else
			 return new ResponseEntity<Estabelecimento>(HttpStatus.NOT_FOUND); 
		 //return estabelecimentoRepository.save(estabelecimento);
	 }
	 
	 @DeleteMapping(value="/estabelecimento/{id}")
	 @ApiOperation(value="deleta um estabelecimento")
	 public ResponseEntity<Object> deletaEstabelecimento(@PathVariable(value="id") long id) {
	 Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
	 if(estabelecimento.isPresent()) {
		 estabelecimentoRepository.delete(estabelecimento.get());
		 return new ResponseEntity<>(HttpStatus.OK);
	 }else
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
}
