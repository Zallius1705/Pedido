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
public enum EnumSituacao {
    //PAGO, 
    //VENCIDO, 
    //EM_ANDAMENTO;
    
    PAGO("Pago"),
    VENCIDO("Vencido"),
    EM_ANDAMENTO("Em andamento");
    
    private String valor;
    
    EnumSituacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
