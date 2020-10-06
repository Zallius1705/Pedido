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
public class PagamentoDinheiro implements IPagamentoStrategy{
    @Override
    public void realizaPagamento(Pedido pedido) {
        if(pedido.getEstado() == Situacao.EM_ANDAMENTO) {
            pedido.setEstado(Situacao.PAGO);
        }   else {
            throw new RuntimeException("Pedido não está mais em andamento!");
        }
    }
}
