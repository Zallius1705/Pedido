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
public class AniversarioDescontoHandler extends AbstractDescontoHandler{
    @Override
    public boolean accept(Compra compra) {
        if(compra.getCarrinho().getCliente().getDataNascimento().getDayOfYear() == compra.getDataCompra().getDayOfYear()) {
            return true;
        }
        return false;
    }

    @Override
    public void doHandle(Compra compra) {
        compra.setValorDesconto(0.1 + compra.getValorDesconto());
    }
}
