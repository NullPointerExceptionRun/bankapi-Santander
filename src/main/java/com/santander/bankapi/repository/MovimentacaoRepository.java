package com.santander.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.bankapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
