package br.edu.ifsp.scl.rede_museu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.scl.rede_museu.model.domain.Obra;

public interface ObraDAO extends JpaRepository <Obra, Long>{

}
