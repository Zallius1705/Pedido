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
    
    private long id;
    private double valorNF;
    private double valorIcms;
    private Pedido pedido;

    public NotaFiscal(long id, double valorNF, double valorIcms, Pedido pedido) {
        this.id = id;
        this.valorNF = valorNF;
        this.valorIcms = valorIcms;
        this.pedido = pedido;
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
