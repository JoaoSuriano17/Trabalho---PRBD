package br.edu.ifsp.scl.rede_museu.model.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artista{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @DateTimeFormat(iso=ISO.DATE)
    @Column(name="data_nasc", nullable=false, columnDefinition="DATE")
    private LocalDate data_nascimento;

    @DateTimeFormat(iso=ISO.DATE)
    @Column(columnDefinition="DATE")
    private LocalDate data_obito;

    private int qtde_premios;

    @Column(length=140)
    private String pais_origem;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public LocalDate getData_obito() {
        return data_obito;
    }

    public int getQtde_premios() {
        return qtde_premios;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setData_obito(LocalDate data_obito) {
        this.data_obito = data_obito;
    }

    public void setQtde_premios(int qtde_premios) {
        this.qtde_premios = qtde_premios;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }
}