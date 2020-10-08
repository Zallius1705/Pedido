/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.regrasDeDesconto;

import br.ufes.model.Compra;

/**
 *
 * @author Lucas
 */
public abstract class AbstractDescontoHandler implements DescontoHandler  {
    protected DescontoHandler proximo;
    
    public final void setProximo(DescontoHandler proximo) {
        this.proximo = proximo;
    }
    
    @Override
    public final void handleRequest(Compra compra) throws Exception {
        if (accept(compra)) {
            doHandle(compra);
        }   else if (this.proximo != null) {
           this.proximo.handleRequest(compra);
        }   else {
            throw new Exception("Não foi possivel enviar a compra");
        }
    }
    
    public abstract boolean accept(Compra compra);
    
    public abstract void doHandle(Compra compra);
}
