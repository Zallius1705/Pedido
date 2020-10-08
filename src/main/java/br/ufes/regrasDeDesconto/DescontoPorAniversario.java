/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.regrasDeDesconto;

import br.ufes.model.Pedido;

/**
 *
 * @author Lucas
 */
public class DescontoPorAniversario {
    public double calcula(Pedido pedido) {
        if (pedido.getCarrinho().getCliente().getDataNascimento().getDayOfYear() == pedido.getData().getDayOfYear()) return 0.2;
        
        return 0;
    }
}
