package com.bruno_goedert.org.projeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "turmas")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private Integer anoLetivo;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String periodo; // ex.: MANHA | TARDE | NOITE

    @NotNull
    @Column(nullable = false)
    private Boolean ativa = true;

    public TurmaEntity() {}

    public TurmaEntity(String nome, Integer anoLetivo, String periodo, Boolean ativa) {
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.periodo = periodo;
        this.ativa = ativa;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getAnoLetivo() { return anoLetivo; }
    public void setAnoLetivo(Integer anoLetivo) { this.anoLetivo = anoLetivo; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public Boolean getAtiva() { return ativa; }
    public void setAtiva(Boolean ativa) { this.ativa = ativa; }
}
