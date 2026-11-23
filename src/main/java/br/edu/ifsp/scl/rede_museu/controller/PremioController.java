package br.edu.ifsp.scl.rede_museu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.scl.rede_museu.model.dao.PremioDAO;
import br.edu.ifsp.scl.rede_museu.model.domain.Premio;

@RestController
@RequestMapping("/premios")
public class PremioController {

    @Autowired
    private PremioDAO dao;

    @GetMapping("/listar")
    public List<Premio> getPacientes(){
        return dao.findAll();
    }

    @GetMapping("/listar/{id}")
    public Premio getPaciente(@PathVariable("id") Long id){
        Premio p = null;

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
