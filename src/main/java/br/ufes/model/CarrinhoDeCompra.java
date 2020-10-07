package br.ufes.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class CarrinhoDeCompra {

    protected Cliente cliente;
    protected double valor;
    protected final ArrayList<Item> itens = new ArrayList<>();

    public CarrinhoDeCompra(Cliente cliente, Produto produto, double quantidade) {
        if (cliente == null) {
            throw new RuntimeException("Informe um cliente válido");
        }
        
        this.cliente = cliente;
        this.addItem(produto, quantidade);
    }

    public final void addItem(Produto produto, double quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("Informe uma quantidade válida!");
        }
        if (this.getItemPorNome(produto.getNome()).isPresent()) {
            throw new RuntimeException("Produto já existe! Remova-o ou altere a quantidade");
        }
        itens.add(new Item(produto, quantidade));
        calcularValor();
    }
    
    protected void alterarQuantidadeItemPorNome(String nomeProduto, double quantidade){
          if(this.getItemPorNome(nomeProduto) == null){
              throw new RuntimeException("Produto não encontrado");
          }
          if(quantidade == 0) removerItem(nomeProduto);
          else{
              this.getItemPorNome(nomeProduto).get().setQuantidade(quantidade);
          }
    }
    
    protected Optional<Item> getItemPorNome(String nomeProduto) {
        Optional<Item> itemEncontrado = Optional.empty();
        for (Item item : itens) {
            if (item.getProduto().getNome().toLowerCase().equals(nomeProduto.toLowerCase())) {
                itemEncontrado = Optional.of(item);
            }
        }
        return itemEncontrado;
    }

    private void calcularValor() {
        valor = 0;
        for (Item item : itens) {
            valor += item.getValorItem();
        }
    }
    
    public Pedido fechar() {
        Pedido pedido = new Pedido(this, LocalDate.now());
        
        return pedido;
    }

    public void removerItem(String nomeProduto) {

        Optional<Item> produtoEncontrado = getItemPorNome(nomeProduto);
        if (!produtoEncontrado.isPresent()) {
            throw new RuntimeException("Item " + nomeProduto + " não encontrado");
        }

        itens.remove(produtoEncontrado.get());
        calcularValor();
    }

    public double getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String retorno = "Carrinho de compras\n";
        retorno += cliente + "\n";
        retorno += "Valor sem desconto: R$ " + df.format(getValor()) + "\n";
        retorno += "Itens do pedido:\n";
        for (Item item : itens) {
            retorno += "\t- " + item.toString() + "\n";
    }

        return retorno;
    }

}