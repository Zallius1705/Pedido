/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import Enum.EnumUF;

/**
 *
 * @author Maycon
 */
public class Endereco {
    private final String logradouro;
    private final int numero;
    private final String complemento;
    private final String cep;
    private final String bairro;
    private final String cidade;
    private final EnumUF uf;

    public Endereco(String logradouro, int numero, String complemento, String cep, String bairro, String cidade, EnumUF uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public EnumUF getUf() {
        return uf;
    }
    
}
