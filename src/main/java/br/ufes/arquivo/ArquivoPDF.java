/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.arquivo;

import br.ufes.model.Item;
import br.ufes.model.NotaFiscal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Paulo
 */
public class ArquivoPDF implements IArquivo{
    
    @Override
    public void gerar(NotaFiscal nota) {
        
        Document documento = new Document();
        String nome = nota.getPedido().getCarrinho().getCliente().getNome();
        
        String aux = "Nota Fiscal nº " + nota.getId() + "\n";
        aux += "---------------------------------------------------------\n";
        aux += "Cliente\n";
        aux += "    Nome: " + nota.getPedido().getCarrinho().getCliente().getNome() + "\n";
        aux += "    CPF/CNPJ: " + nota.getPedido().getCarrinho().getCliente().getCNPJOuCPF() + "\n";
        aux += "    Data de Nasc: " + nota.getPedido().getCarrinho().getCliente().getDataNascimento() + "\n";
        aux += "---------------------------------------------------------\n";
        aux += "Endereco\n";
        aux += "    Logradouro: " + nota.getPedido().getCarrinho().getCliente().getEndereco().getLogradouro() + ", ";
        aux += nota.getPedido().getCarrinho().getCliente().getEndereco().getNumero() + ", ";
        aux += nota.getPedido().getCarrinho().getCliente().getEndereco().getComplemento() + "\n";
        aux += "    Bairro: " + nota.getPedido().getCarrinho().getCliente().getEndereco().getBairro() + "\n";
        aux += "    Cidade: " + nota.getPedido().getCarrinho().getCliente().getEndereco().getCidade() + ", ";
        aux += nota.getPedido().getCarrinho().getCliente().getEndereco().getUf() + "\n";
        aux += "    CEP: " + nota.getPedido().getCarrinho().getCliente().getEndereco().getCep() + "\n";
        aux += "---------------------------------------------------------\n";
        aux += "Itens do pedido:\n";
        for (Item item : nota.getPedido().getCarrinho().getItens())
            aux += "    -" + item.toString() + "\n";
        aux += "---------------------------------------------------------\n";
        aux += "Valor sem desconto: R$ " + nota.getPedido().getCarrinho().getValor() + "        ";
        aux += "ICMS: " + nota.getValorIcms() + "       Total R$: " + ((nota.getPedido().getCarrinho().getValor()) + (nota.getValorIcms())) + "\n";
        aux += "    Desconto: R$ " + "\n\n";

        aux += "Total a pagar: R$ " + nota.getPedido().getValorAPagar() + "\n";
        
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("NotaFisca" + nome + ".pdf"));
            documento.open();
            documento.add(new Paragraph(aux));
            documento.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ArquivoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

