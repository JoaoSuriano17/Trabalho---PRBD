package br.edu.ifsp.scl.rede_museu.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Premio{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String titulo;

    @Column(nullable=false)
    private int ano;

    @Column(nullable=false, length=100) 
    private String honorifico;
    
    @OneToOne
    @JoinColumn(name="id_exposicao")
    private Exposicao exposicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getHonorifico() {
        return honorifico;
    }

    public void setHonorifico(String honorifico) {
        this.honorifico = honorifico;
    }

    public Exposicao getExposicao() {
        return exposicao;
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }


}