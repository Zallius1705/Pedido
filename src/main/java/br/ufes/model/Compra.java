package br.ufes.model;

import br.ufes.regrasDeDesconto.Desconto;
import br.ufes.regrasDeDesconto.DescontoPorAniversario;
import br.ufes.regrasDeDesconto.DescontoPorCupons;
import br.ufes.regrasDeDesconto.DescontoPorTipoItem;
import br.ufes.regrasDeDesconto.SemDesconto;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Compra {
    protected final CarrinhoDeCompra carrinho;
    protected double valorDesconto = 0;
    protected LocalDate dataCompra;

    public Compra(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        this.dataCompra = LocalDate.now();
        calculaDesconto();
    }
    
    public Pedido fechar() {
        Pedido pedido = new Pedido(this.carrinho, this.dataCompra, (this.carrinho.getValor() - this.getValorDesconto()));
        return pedido;
    }
    
    public final void calculaDesconto() {
        final Desconto descontoPorAniversario = new DescontoPorAniversario();
        final Desconto descontoPorCupons = new DescontoPorCupons();
        final Desconto descontoPorTipoItem = new DescontoPorTipoItem();
        final Desconto semDesconto = new SemDesconto();
        
        descontoPorAniversario.setProximo(descontoPorCupons);
        descontoPorCupons.setProximo(descontoPorTipoItem);
        descontoPorTipoItem.setProximo(semDesconto);
        
        descontoPorAniversario.calcular(this);
    }

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }
    
    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
