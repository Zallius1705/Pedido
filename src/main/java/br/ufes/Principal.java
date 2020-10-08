package br.ufes;

import br.ufes.model.Cliente;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Endereco;
import Enum.EnumUF;
import br.ufes.model.Produto;
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

            Produto produto1 = new Produto("Caneta", "Material escolar", 3.50, 8);

            CarrinhoDeCompra pedido1 = new CarrinhoDeCompra(cliente1,
                    produto1, 5
            );

            pedido1.addItem(new Produto("Folha Papel A4", "Material escolar", 0.05, 10), 10);

            System.out.println(pedido1);

        } catch (RuntimeException rte) {
            System.err.println("Falha: " + rte.getMessage());

        }

    }

}
