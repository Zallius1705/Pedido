package br.ufes.model;

import br.ufes.regrasDeDesconto.AniversarioDescontoHandler;
import br.ufes.regrasDeDesconto.CuponsDescontoHandler;
import br.ufes.regrasDeDesconto.AbstractDescontoHandler;
import br.ufes.regrasDeDesconto.TipoDescontoHandler;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Compra {
    protected final CarrinhoDeCompra carrinho;
    protected double valorDesconto;
    protected AbstractDescontoHandler desconto;
    protected LocalDate dataCompra;

    public Compra(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        this.dataCompra = LocalDate.now();
        
        //Chain handlers
        AbstractDescontoHandler aniversarioDescontoHandler = new AniversarioDescontoHandler();
        AbstractDescontoHandler cuponsDescontoHandler = new CuponsDescontoHandler();
        AbstractDescontoHandler tipoDescontoHandler = new TipoDescontoHandler();
        
        this.desconto = aniversarioDescontoHandler;
    }
    
    public Pedido fechar() {
        Pedido pedido = new Pedido(this.carrinho, this.dataCompra, (this.carrinho.getValor() - this.getValorDesconto()));
        return pedido;
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
