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
public interface IPagamentoStrategy {
    public void realizaPagamento(Pedido pedido);
}
