package br.ufes.model;

public class Estoque {
    private double quantidade;

    public Estoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Estoque: " + quantidade;
    }
    
}
