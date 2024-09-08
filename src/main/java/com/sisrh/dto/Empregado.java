package com.sisrh.dto;

import java.util.Date;

public class Empregado {

    private String matricula;
    private String nome;
    private Date admissao;
    private Date desligamento;
    private double salario;

    public Empregado() {
    }

    public Empregado(String matricula, String nome, Date admissao, Date desligamento, double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.admissao = admissao;
        this.desligamento = desligamento;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Date getDesligamento() {
        return desligamento;
    }

    public void setDesligamento(Date desligamento) {
        this.desligamento = desligamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
