package br.edu.ifsp.scl.rede_museu.controller;

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

import br.edu.ifsp.scl.rede_museu.model.dao.ArtistaDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Artista;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaDAO dao;

    @GetMapping("/listar")
    public List<Artista> getPacientes(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Artista getPaciente(@PathVariable("id") Long id){
        Artista p = null;

        if ( dao.existsById(id) ){
            p = dao.findById(id).get();
        }

        return p;
    }

    /*
    @DeleteMapping("/remover/{id}")
    public boolean removerPaciente(@PathVariable("id") Long id){
        
        dao.deleteById(id);

        return true;
    }

    @PostMapping("/inserir")
    public Paciente inserirPaciente(
             @RequestBody Paciente paciente){
        return dao.save(paciente);
    }

    @PutMapping("/alterar")
    public Paciente alterarPaciente(
            @RequestBody Paciente paciente){
        return dao.save(paciente);
    }*/

}
