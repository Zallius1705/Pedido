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
public class DescontoPorAniversario implements Desconto {
    private Desconto proximo;
    
    @Override
    public void calcular(Compra compra) {
        if(compra.getCarrinho().getCliente().getDataNascimento().getDayOfYear() == compra.getDataCompra().getDayOfYear()) {
            compra.setValorDesconto(compra.getValorDesconto() + (compra.getCarrinho().getValor() * 0.1));
        }
        proximo.calcular(compra);
    }
    
    @Override
    public void setProximo(Desconto proximo) {
       this.proximo = proximo;
    }
}
