package br.ufes.model;

import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Compra {
    protected final CarrinhoDeCompra carrinho;
    protected double valorDesconto;
    protected LocalDate dataCompra;

    public Compra(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        this.dataCompra = LocalDate.now();
    }
    
    public Pedido fechar() {
        Pedido pedido = new Pedido(this.carrinho, this.dataCompra, (this.carrinho.getValor() - this.getValorDesconto()));
        return pedido;
    }   

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }
    
    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
