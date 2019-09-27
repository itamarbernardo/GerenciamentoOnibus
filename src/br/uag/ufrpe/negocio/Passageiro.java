/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

import static br.uag.ufrpe.negocio.Data.converterDataParaLocalDate;
import java.time.LocalDate;

/**
 *
 * @author Jackson / Itamar Jr
 */
public class Passageiro extends Pessoa {
    
    private String dataNascimento;
    private boolean possuiIdJovem;
    
    public Passageiro(String nomeCompleto, String dataNascimento, boolean possuiIdJovem, String cpf, String rg, String email, Endereco endereco, String telefone) {
        super(nomeCompleto, cpf, rg, email, endereco, telefone);
        
        this.possuiIdJovem = possuiIdJovem;    
    }
       
    public boolean isPossuiIdJovem() {
        return possuiIdJovem;
    }

    public void setPossuiIdJovem(boolean possuiIdJovem) {
        this.possuiIdJovem = possuiIdJovem;
    }
    
    public int calcularIdade(){
        LocalDate data = converterDataParaLocalDate(this.dataNascimento);
        LocalDate localDate = LocalDate.now();
        
        if(localDate.getMonthValue() < data.getMonthValue() || (localDate.getMonthValue() == data.getMonthValue() && localDate.getDayOfMonth() < data.getDayOfMonth())  ){        
            return(localDate.getYear() - data.getYear()) - 1;  
        }     
        return localDate.getYear() - data.getYear();       
    }
        
    @Override
    public String toString() {
        return "Passageiro{" + "dataNascimento=" + dataNascimento + ", possuiIdJovem=" + possuiIdJovem + '}';
    }  
}
