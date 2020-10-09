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
public class DescontoPorTipoItem implements Desconto{
    private Desconto proximo;
    double aux = 0;
    
    @Override
    public void calcular(Compra compra) {
        for (Item item : compra.getCarrinho().getItens()) {
            if (item.getProduto().getTipo() == "Material escolar") {
                item.setValorItem(item.getValorItem() - (item.getValorItem() * 0.30));
                aux += (item.getValorItem() * 0.30);
            }
        }
        compra.setValorDesconto(compra.getValorDesconto() + aux);
        proximo.calcular(compra);
    }
    
    @Override
    public void setProximo(Desconto proximo) {
       this.proximo = proximo;
    }
}
