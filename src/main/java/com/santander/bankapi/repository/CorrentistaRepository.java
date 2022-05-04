package com.santander.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.bankapi.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
