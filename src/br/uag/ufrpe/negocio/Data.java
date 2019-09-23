/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Esta classe ajuda a manipular datas
 * @author Itamar Jr
 */
public class Data {
    
    public Data(){
        
    }
    
    public static boolean verificarSeADataEstaDentroDeUmIntervaloDeDatas(String dataInicio, String dataFim, String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDateInicio = LocalDate.parse(dataInicio, formato);
        LocalDate localDateFim = LocalDate.parse(dataFim, formato);
        LocalDate localDate = LocalDate.parse(data, formato);
        
        return (localDateInicio.isBefore(localDate) || localDateInicio.isEqual(localDate)) && (localDateFim.isAfter(localDate) || localDateFim.isEqual(localDate)); 
    }
    
    public static LocalDate converterDataParaLocalDate(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formato);
        
        return localDate;
    }
    
    public static String converterDataParaString(LocalDate data){
        String dataString = data.toString();
                
        return dataString;
    }
    
}
