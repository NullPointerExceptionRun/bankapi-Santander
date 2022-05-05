package com.santander.bankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.bankapi.dto.NovoCorrentista;
import com.santander.bankapi.model.Correntista;
import com.santander.bankapi.model.Movimentacao;
import com.santander.bankapi.repository.CorrentistaRepository;
import com.santander.bankapi.repository.MovimentacaoRepository;
import com.santander.bankapi.service.CorrentistaService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista){
		service.save(correntista);
	}
}
