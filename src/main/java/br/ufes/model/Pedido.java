/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;
import br.ufes.estadoPedido.EstadoInicial;
import br.ufes.estadoPedido.EstadoSituacao;
import br.ufes.formasdePagamento.IPagamentoStrategy;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Pedido {
    protected final Timestamp codigo;
    protected final CarrinhoDeCompra carrinho;
    protected EstadoSituacao estado;
    protected double valorAPagar;
    protected final LocalDate data;
    protected final LocalDate dataValidade;
    protected IPagamentoStrategy pagamentoStrategy;

    public Pedido(CarrinhoDeCompra carrinho, LocalDate data, double valorAPagar) {
        this.codigo = new Timestamp(System.currentTimeMillis());
        this.carrinho = carrinho;
        this.data = data;
        this.dataValidade = data.plusDays(5);
        this.setEstado(new EstadoInicial());
        this.valorAPagar = valorAPagar;
    }
    
    public Timestamp getCodigo() {
        return codigo;
    }

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public EstadoSituacao getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoSituacao estado) {
        this.estado = estado;
    }
    
    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setPagamentoStrategy(IPagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }
}
