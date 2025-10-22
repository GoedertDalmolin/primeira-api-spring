package com.bruno_goedert.org.projeto.dto;

public class TurmaResponse {
    private Long id;
    private String nome;
    private Integer anoLetivo;
    private String periodo;
    private Boolean ativa;

    public TurmaResponse() {}

    public TurmaResponse(Long id, String nome, Integer anoLetivo, String periodo, Boolean ativa) {
        this.id = id;
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
