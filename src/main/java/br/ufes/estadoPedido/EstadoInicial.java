/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.estadoPedido;

import br.ufes.model.NotaFiscal;
import br.ufes.model.Pedido;

/**
 *
 * @author Lucas
 */
public class EstadoInicial implements EstadoSituacao{
    @Override
    public void alterarEstado(Pedido pedido) {
        pedido.setEstado(this);
    }

    @Override
    public NotaFiscal gerarNotaFiscal(Pedido pedido) {
        return null;
    }
    
    
}
