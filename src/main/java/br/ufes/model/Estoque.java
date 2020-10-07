package br.ufes.model;

public class Estoque {
    private double quantidade;

    public Estoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade = quantidade;
        }   else {
            throw new RuntimeException("Quantidade de itens maior que o estoque!");
        }
    }

    @Override
    public String toString() {
        return "Estoque: " + quantidade;
    }
    
}
