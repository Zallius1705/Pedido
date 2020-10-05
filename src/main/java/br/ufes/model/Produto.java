package br.ufes.model;

import java.util.ArrayList;

public final class Produto {

    private String nome;
    private double valorUnitario;
    private double valorUltimaCompra;
    private String tipo;
    private Estoque estoque;

    public Produto(String nome, String tipo, double valorUnitario, double quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        setValorUnitario(valorUnitario);
        this.estoque = new Estoque(quantidade);
    }

    public boolean estoqueDisponivel(double quantidadeNecessaria) {
        return this.estoque.getQuantidade() >= quantidadeNecessaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorUltimaCompra() {
        return valorUltimaCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new RuntimeException("Nome inválido: " + nome);
        }
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new RuntimeException("Valor inválido: " + valorUnitario);
        }
        this.valorUltimaCompra = this.valorUnitario;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Produto: " + nome
                + ", tipo: " + tipo
                + ", valor unitario: R$" + valorUnitario
                + ", valor da ultima compra: R$" + valorUltimaCompra
                + ", quantidade em estoque: " + estoque;
    }

}
