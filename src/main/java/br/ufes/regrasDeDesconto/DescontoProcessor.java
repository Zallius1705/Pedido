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
public class DescontoProcessor {
    private DescontoHandler successor;
    private DescontoHandler first;
    
    public DescontoProcessor() {}
    
    public void addDescontoHandler(DescontoHandler descontoHandler) {
        if(this.first == null) {
            this.first = descontoHandler;
        }   else {
            this.successor.setProximo(descontoHandler);
        }
        this.successor = descontoHandler;
    }
    
    public void handleRequest (Compra compra) throws Exception {
        first.handleRequest(compra);
    }
}
