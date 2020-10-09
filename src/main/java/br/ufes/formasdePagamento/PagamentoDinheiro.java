/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.formasdePagamento;

import br.ufes.estadoPedido.EstadoInicial;
import br.ufes.estadoPedido.EstadoPago;
import br.ufes.estadoPedido.EstadoVencido;
import br.ufes.model.Pedido;

/**
 *
 * @author Lucas
 */
public class PagamentoDinheiro implements IPagamentoStrategy{
    
    @Override
    public void realiza(Pedido pedido) {
        
        if(pedido.getEstado() == new EstadoInicial()) {
            pedido.setEstado(new EstadoPago());
            pedido.setPagamentoStrategy(this);
            
            pedido.getCarrinho().getItens().forEach(item -> {
                item.getProduto().getEstoque().setQuantidade(item.getProduto().getEstoque().getQuantidade() - item.getQuantidade());
            });

            pedido.getCarrinho().getCliente().setCupons(pedido.getCarrinho().getCliente().getCupons() + (int) (pedido.getValorAPagar() * 0.02));
        }   else {
            pedido.setEstado(new EstadoVencido());
            throw new RuntimeException("Pedido vencido!");
        }
    }
}
