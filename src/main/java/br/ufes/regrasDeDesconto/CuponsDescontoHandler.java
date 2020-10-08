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
public class CuponsDescontoHandler extends Desconto{
    @Override
    public void desconto(Compra compra) {
        if(compra.getCarrinho().getCliente().getCupons() >= 10) {
            compra.setValorDesconto(0.15 + compra.getValorDesconto());
            compra.getCarrinho().getCliente().setCupons(compra.getCarrinho().getCliente().getCupons() - 10);
        }
        
        if(proximo != null) {
            proximo.desconto(compra);
        }
    }
}
