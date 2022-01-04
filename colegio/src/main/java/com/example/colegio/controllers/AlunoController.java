package com.example.colegio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/alterar"); 
		Aluno aluno = alunoDao.getOne(id);
		mv.addObject("aluno", aluno);
		return mv;
		
	}
	
	// ADICIONANDO ALUNO 

	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoDao.save(aluno);
		mv.setViewName("redirect:/lista-alunos");
		return mv;
	}
	
	// DELETANDO ALUNO 
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") long id) {
		alunoDao.deleteById(id);
		return "redirect:/lista-alunos";
	}
	


}
