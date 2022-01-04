package com.example.colegio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.colegio.Dao.AlunoDao;
import com.example.colegio.model.Aluno;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDao alunoDao;
	
	@GetMapping("/inserirAluno")
	public ModelAndView formAluno() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/formAluno");
		mv.addObject("aluno", new Aluno());
		
		return mv;
	}
	
	
	@PostMapping("InsertStudens")
	public ModelAndView inserirAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/lista-alunos");
		alunoDao.save(aluno);
		return mv;
		
	}
	
	@GetMapping("lista-alunos")
	public ModelAndView listaDeAluno() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/listarAlunos");
		mv.addObject("umalistadealunos", alunoDao.findAll());
		return mv;
	}


}
