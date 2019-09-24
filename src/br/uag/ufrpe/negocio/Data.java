/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta classe ajuda a manipular datas
 * @author Itamar Jr
 */
public class Data {
    
    public Data(){
        
    }
    
    public static boolean verificarDataEstaNoIntervalo(String dataInicio, String dataFim, String data){
        LocalDate localDateInicio = converterDataParaLocalDate(dataInicio);
        LocalDate localDateFim = converterDataParaLocalDate(dataFim);
        LocalDate localDate = converterDataParaLocalDate(data);

        return (localDateInicio.isBefore(localDate) || localDateInicio.isEqual(localDate)) && (localDateFim.isAfter(localDate) || localDateFim.isEqual(localDate)); 
    }
    
    public static LocalDate converterDataParaLocalDate(String data){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formato);
        
        return localDate;
    }
    
    public static String converterDataParaString(LocalDate data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return data.format(formato); //Deixa no formato conhecido.
    }
    
        public static LocalDateTime converteStringEmDataHora(String dataHora){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dataHora, formato);
        
        return localDateTime;
    }
    
    public static boolean verificarDataHoraEstaNoIntervalo(String dataHoraInicio, String dataHoraFim, String dataHoraSaida, String dataHoraChegada){
        LocalDateTime dataInicio = converteStringEmDataHora(dataHoraInicio);
        LocalDateTime dataFim = converteStringEmDataHora(dataHoraFim);
        LocalDateTime dataSaida = converteStringEmDataHora(dataHoraSaida);
        LocalDateTime dataChegada = converteStringEmDataHora(dataHoraChegada);
        
        boolean verificacao1 = (dataInicio.isBefore(dataSaida) || dataInicio.isEqual(dataSaida)) && (dataFim.isAfter(dataSaida) || dataFim.isEqual(dataSaida));
        boolean verificacao2 = (dataSaida.isBefore(dataInicio) || dataSaida.isEqual(dataInicio)) && (dataChegada.isAfter(dataFim) || dataChegada.isEqual(dataFim));
        
        return (verificacao1 || verificacao2);
    }
    
    public static String converteDataHoraEmString(LocalDateTime dataHora){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        return dataHora.format(formato);
    }
    

    
}
