/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;
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
    protected IDescontosStrategy descontoStrategy;
    protected IPagamentoStrategy pagamentoStrategy;
    protected IArquivo arquivo;

    public Pedido(CarrinhoDeCompra carrinho, LocalDate data) {
        this.codigo = new Timestamp(System.currentTimeMillis());
        this.carrinho = carrinho;
        this.situacao = EnumSituacao.EM_ANDAMENTO;
        this.data = data;
        this.dataValidade = data.plusDays(5);
    }
    
    public Pedido(CarrinhoDeCompra carrinho, LocalDate data, IDescontosStrategy descontoStrategy, IPagamentoStrategy pagamentoStrategy, IArquivo arquivo) {
        this.codigo = new Timestamp(System.currentTimeMillis());
        this.carrinho = carrinho;
        this.descontoStrategy = descontoStrategy;
        this.situacao = EnumSituacao.EM_ANDAMENTO;
        this.aplicarDesconto();
        this.data = data;
        this.dataValidade = data.plusDays(5);
        this.pagamentoStrategy = pagamentoStrategy;
        this.arquivo = arquivo;
    }
    
    private void aplicarDesconto() {
        this.valorDesconto = this.descontoStrategy.calculaDesconto(this.carrinho) * carrinho.getValor();
        this.valorAPagar = carrinho.getValor() - valorDesconto;
    }

    
    public void removerItemPedidoPorNome(String nomeProduto){
        try{
            this.carrinho.removerItem(nomeProduto);
        }catch(Exception e) {
            System.err.println("Falha: " + e.getMessage()); 
        }
    }
    
    public void alterarQuantidadeItemPedido(String nomeProduto, double quantidade){
        try{
            this.carrinho.alterarQuantidadeItemPorNome(nomeProduto, quantidade);
        }catch(Exception e) {
            System.err.println("Falha: " + e.getMessage()); 
        }
    }
    
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
