/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.estado;

import br.ufes.model.NotaFiscal;
import br.ufes.model.Pedido;

/**
 *
 * @author Lucas
 */
public interface EstadoSituacao {
    public void alterarEstado(Pedido pedido);
    public NotaFiscal gerarNotaFiscal(Pedido pedido);
}
