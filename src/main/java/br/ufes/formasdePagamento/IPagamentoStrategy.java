/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.formasdePagamento;

import br.ufes.model.Pedido;

/**
 *
 * @author Lucas
 */
public interface IPagamentoStrategy {
    public void realiza(Pedido pedido);
}
