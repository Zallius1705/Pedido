/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;
import br.ufes.enums.EnumSituacao;
import br.ufes.formasdePagamento.IPagamentoStrategy;
import br.ufes.regrasDeDesconto.IDescontosStrategy;
import br.ufes.arquivo.IArquivo;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Pedido {
    private final Timestamp codigo;
    private final CarrinhoDeCompra carrinho;
    private EnumSituacao situacao;
    protected double valorDesconto;
    protected double valorAPagar;
    protected final LocalDate data;
    protected final LocalDate dataValidade;
    protected IPagamentoStrategy pagamentoStrategy;

    public Pedido(CarrinhoDeCompra carrinho, LocalDate data) {
        this.codigo = new Timestamp(System.currentTimeMillis());
        this.carrinho = carrinho;
        this.situacao = EnumSituacao.EM_ANDAMENTO;
        this.data = data;
        this.dataValidade = data.plusDays(5);
    }
    /*
    private void aplicarDesconto() {
        this.valorDesconto = this.descontoStrategy.calculaDesconto(this.carrinho) * carrinho.getValor();
        this.valorAPagar = carrinho.getValor() - valorDesconto;
    }
    */
    
    public void verificaVencimento() {
        if(LocalDate.now().isAfter(this.dataValidade)) {
            this.situacao = EnumSituacao.VENCIDO;
        }        
    }
    
    public Timestamp getCodigo() {
        return codigo;
    }

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public EnumSituacao getEstado() {
        return situacao;
    }
    
    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setEstado(EnumSituacao estado) {
        this.situacao = estado;
    }
    
}
