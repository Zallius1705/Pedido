package br.ufes;

import br.ufes.arquivo.ArquivoJSON;
import br.ufes.arquivo.ArquivoPDF;
import br.ufes.model.Cliente;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Endereco;
import br.ufes.enums.EnumUF;
import br.ufes.model.Compra;
import br.ufes.model.NotaFiscal;
import br.ufes.model.Pedido;
import br.ufes.model.Produto;
import br.ufes.regrasDeDesconto.Desconto;
import br.ufes.regrasDeDesconto.DescontoPorTipoItem;
import java.time.LocalDate;

/**
 *
 * @author Clayton, adaptado da solução de Pedro Henrique Robadel
 */
public class Principal {

    public static void main(String[] args) {

        try {
            Endereco endereco1 = new Endereco("Rua José das Pontes", 188, "apt. 202", "29500-877", "Laranjeiras", "Serra", EnumUF.ES);
            Cliente cliente1 = new Cliente("Fulano", "123.456.789-01",  LocalDate.now(), endereco1);
 
            Produto produto1 = new Produto("Caneta", "Material escolar", 3.50, 80);
            Produto produto2 = new Produto("Lápis nº 2", "Material escolar", 1.00, 100);
            Produto produto3 = new Produto("Cabo USB", "Informática", 13.50, 20);
            Produto produto4 = new Produto("Capa p/ celular", "Acessório", 10.00, 30);
            
            CarrinhoDeCompra car1 = new CarrinhoDeCompra(cliente1, produto1, 5);        
            car1.addItem(new Produto("Folha Papel A4", "Material escolar", 0.05, 10), 10);
            car1.addItem(produto2, 3);
            
            Compra compra1 = new Compra(car1);
            
            NotaFiscal nota1 = new NotaFiscal(compra1.fechar());
            
            System.out.println(nota1.getPedido().getCarrinho());
            
            ArquivoJSON json = new ArquivoJSON();
            ArquivoPDF pdf = new ArquivoPDF();
            
            json.gerar(nota1);
            pdf.gerar(nota1);
            

        } catch (RuntimeException rte) {
            System.err.println("Falha: " + rte.getMessage());

        }

    }

}
