/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import br.ufes.enums.EnumUF;
import java.sql.Timestamp;

/**
 *
 * @author Maycon
 */
public final class NotaFiscal {
    
    protected final Timestamp id;
    private final double valorIcms;
    private final Pedido pedido;

    public NotaFiscal(Pedido pedido) {
        this.id = new Timestamp(System.currentTimeMillis());
        this.pedido = pedido;
        
        if (this.getPedido().getCarrinho().getCliente().getEndereco().getUf() == EnumUF.ES) {
            this.valorIcms = this.pedido.getValorAPagar() * 0.17;
        }   else {
            this.valorIcms = this.pedido.getValorAPagar() * 0.12;
        }
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
