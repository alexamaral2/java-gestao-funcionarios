package com.alexjr.gestaofuncionarios.model;

import java.time.LocalDate;

public abstract class Pessoa {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
