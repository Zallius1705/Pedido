package br.ufes.model;

import java.time.LocalDate;

public final class Cliente {

    private final String nome;
    private final String cNPJOuCPF;
    private final LocalDate dataNascimento;
    private double cupons;
    private Endereco endereco;

    public Cliente(String nome, String codigo, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cNPJOuCPF = codigo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCNPJOuCPF() {
        return cNPJOuCPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getCupons() {
        return cupons;
    }

    public void setCupons(double cupons) {
        this.cupons = cupons;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + cNPJOuCPF;
    }

}
