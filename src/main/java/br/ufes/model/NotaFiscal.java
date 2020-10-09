/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.sql.Timestamp;

/**
 *
 * @author Maycon
 */
public class NotaFiscal {
    
    protected final Timestamp id;
    private double valorIcms;
    private Pedido pedido;

    public NotaFiscal(double valorIcms, Pedido pedido) {
        this.id = new Timestamp(System.currentTimeMillis());
        this.valorIcms = valorIcms;
        this.pedido = pedido;
    }
    
    public Timestamp getId() {
        return id;
    }

    public double getValorIcms() {
        return valorIcms;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
    
}
