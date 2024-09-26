package com.api.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.school.model.Aluno;
import com.api.school.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public List<Aluno> listar(){
        return repository.findAll();
    }

    @PostMapping
    public void adicionar(@RequestBody Aluno aluno){
       repository.save(aluno);
    }

    @PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
		aluno.setId(id);
		repository.save(aluno);
	}
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
    }
}
