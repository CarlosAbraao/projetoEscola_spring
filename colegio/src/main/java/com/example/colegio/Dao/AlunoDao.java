package com.example.colegio.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.colegio.model.Aluno;


@Repository
public interface AlunoDao extends JpaRepository<Aluno, Long> {
	
	@Query("select t from Aluno t where t.status = 'ATIVO' ")
	public List<Aluno> findByStatusAtivos();

}
