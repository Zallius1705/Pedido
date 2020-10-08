/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.regrasDeDesconto;

import br.ufes.model.Compra;
import br.ufes.model.Item;

/**
 *
 * @author Lucas
 */
public class TipoDescontoHandler extends AbstractDescontoHandler{
    /*private boolean aux = false;
    @Override
    public void handleRequest(Compra compra) {
        compra.getCarrinho().getItens().stream().filter(item -> ("Material Escolar".equals(item.getProduto().getTipo()))).map(item -> {
            compra.setValorDesconto(compra.getValorDesconto() + (item.getValorItem() * 0.30));
            return item;
        }).forEachOrdered((Item item) -> {
            item.setValorItem(item.getValorItem() - (item.getValorItem() * 0.30));
        });
        if(proximo != null) {
            proximo.handleRequest(compra);
        }
    }
    */
    @Override
    public boolean accept(Compra compra) {
        for (Item item : compra.getCarrinho().getItens()) {
            
        }
        return false;
    }

    @Override
    public void doHandle(Compra compra) {
        
    }
}
