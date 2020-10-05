/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Lucas
 */
public class Pedido {
    private Long codigo;
    private CarrinhoDeCompra carrinho;
    private Situacao estado;
    protected double desconto;
    protected double valorDesconto;
    protected double valorAPagar;
    protected IDescontosStrategy descontoStrategy;

    public Pedido(Long codigo, CarrinhoDeCompra carrinho, IDescontosStrategy descontoStrategy) {
        this.codigo = codigo;
        this.carrinho = carrinho;
        this.descontoStrategy = descontoStrategy;
        this.aplicarDesconto();
    }
    
    private void aplicarDesconto() {
        this.desconto = this.descontoStrategy.calculaDesconto(this.carrinho);
        this.valorDesconto = carrinho.getValor() * desconto;
        this.valorAPagar = carrinho.getValor() - valorDesconto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public Situacao getEstado() {
        return estado;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }
    
}
