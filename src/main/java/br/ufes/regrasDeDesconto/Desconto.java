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
public abstract class Desconto {
    protected Desconto proximo;
    
    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }
    
    public abstract void desconto(Compra compra);
}
