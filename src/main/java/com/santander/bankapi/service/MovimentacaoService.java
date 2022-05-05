package com.santander.bankapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.bankapi.dto.NovaMovimentacao;
import com.santander.bankapi.model.Correntista;
import com.santander.bankapi.model.Movimentacao;
import com.santander.bankapi.model.MovimentacaoTipo;
import com.santander.bankapi.repository.CorrentistaRepository;
import com.santander.bankapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	private MovimentacaoRepository repository;
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();

		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		movimentacao.setDatehora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(novaMovimentacao.getValor());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null); // se o ID for encontrado pelo id 200, caso contrario NUll
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		
		repository.save(movimentacao);
	}
}
