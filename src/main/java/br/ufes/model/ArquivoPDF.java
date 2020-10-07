/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

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
    public void geraNota(NotaFiscal nota) {
        
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("NotaFiscal.pdf"));
            documento.open();
            documento.add(new Paragraph("asdfaldsfçj pdf"));
            documento.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ArquivoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("PDF gerado!");
        
        
    }
    
}

