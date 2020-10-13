/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.arquivo;

import br.ufes.model.NotaFiscal;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Paulo
 */
public class ArquivoJSON implements IArquivo{

    @Override
    public void gerar(NotaFiscal nota) {
        
        FileWriter arquivo = null;
   
        String nome = nota.getPedido().getCarrinho().getCliente().getNome();
    

        Gson gson = new Gson();
     
        String aux = gson.toJson(nota.getPedido());
           
        try {
            arquivo = new FileWriter("Pedido" + nome + ".json");
            arquivo.write(aux);
            arquivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
 
}
