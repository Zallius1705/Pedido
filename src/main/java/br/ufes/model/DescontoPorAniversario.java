/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Lucas
 */
public class DescontoPorAniversario {
    public double calculaDesconto(CarrinhoDeCompra carrinhoDeCompra) {
        if (carrinhoDeCompra.getCliente().getDataNascimento().getDayOfYear() == carrinhoDeCompra.getData().getDayOfYear()) return 0.2;
        
        return 0;
    }
}
