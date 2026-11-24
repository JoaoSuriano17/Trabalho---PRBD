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

    @PostMapping("/inserir/")
    public Artista inserirArtista(@RequestBody Artista artista){
        return dao.save(artista);
    }
    /*
    @PutMapping("/alterar/{id}")
    public Artista alterarArtista(@PathVariable("id") Long id, @RequestBody Artista artista){
        Artista a=dao.findById(id).get();
        a.setNome(artista.getNome());
        a.setData_nascimento(artista.getData_nascimento());
        a.setData_obito(artista.getData_obito());
        a.setPais_origem(artista.getPais_origem());
        a.setQtde_premios(artista.getQtde_premios());
        return dao.save(a);
    }
    */
    @PutMapping("/alterar/")
    public Artista alterarArtista(@RequestBody Artista artista){
        return dao.save(artista);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletarArtista(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "Artista deletado com sucesso!";
    }
}