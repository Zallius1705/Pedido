/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegrasDeDesconto;

import br.ufes.model.CarrinhoDeCompra;

/**
 *
 * @author Lucas
 */
public class DescontoPorTipo implements IDescontosStrategy{
    public double calcula(CarrinhoDeCompra carrinhoDeCompra) {
        for(int cont = 0; cont < carrinhoDeCompra.getItens().size(); cont++) {
            if(!"Material escolar".equals(carrinhoDeCompra.getItens().get(cont).getProduto().getTipo())) return 0;
        }
        return 0.3;
    }
}
