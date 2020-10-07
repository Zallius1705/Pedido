/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Maycon
 */
public class NotaFiscal {
    
    private final long id;
    private double valorNF;
    private double valorIcms;
    private Pedido pedido;
    private IArquivo arquivo;

    public NotaFiscal(long id, double valorNF, double valorIcms, Pedido pedido, IArquivo arquivo) {
        this.id = id;
        this.valorNF = valorNF;
        this.valorIcms = valorIcms;
        this.pedido = pedido;
        this.arquivo = arquivo;
    }
    
    public long getId() {
        return id;
    }

    public double getValorNF() {
        return valorNF;
    }

    public double getValorIcms() {
        return valorIcms;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
    
}
