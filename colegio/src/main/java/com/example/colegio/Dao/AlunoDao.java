package com.example.colegio.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.model.Aluno;


@Repository
public interface AlunoDao extends JpaRepository<Aluno, Long> {

}
