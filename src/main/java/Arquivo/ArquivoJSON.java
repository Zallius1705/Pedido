/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivo;

import br.ufes.model.NotaFiscal;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author João Paulo
 */
public class ArquivoJSON implements IArquivo{

    @Override
    public void gerar(NotaFiscal nota) {
        
        FileWriter arquivo = null;
        JSONObject objetoJson = new JSONObject();
        
        objetoJson.put("teste", 4);
        objetoJson.put("teste2", "asdlfja");
        
        try {
            arquivo = new FileWriter("NotaFiscal.json");
            arquivo.write(objetoJson.toString());
            arquivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArquivoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(objetoJson.toString());
    }

    
  
}
