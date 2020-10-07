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
        pedido.verificaVencimento();
        
        if(pedido.getEstado() == EnumSituacao.EM_ANDAMENTO) {
            pedido.setEstado(EnumSituacao.PAGO);
            
            pedido.getCarrinho().getItens().forEach(item -> {
                item.getProduto().getEstoque().setQuantidade(item.getProduto().getEstoque().getQuantidade() - item.getQuantidade());
            });

            pedido.getCarrinho().getCliente().setCupons(pedido.getCarrinho().getCliente().getCupons() + (int) (pedido.getValorAPagar() * 0.02));
        }   else {
            throw new RuntimeException("Pedido não está mais em andamento!");
        }
    }
}
