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
public interface DescontoHandler {
    public void setProximo(DescontoHandler proximo);
    public void handleRequest(Compra compra) throws Exception;
}
