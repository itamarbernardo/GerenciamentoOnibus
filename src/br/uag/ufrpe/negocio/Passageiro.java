/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

import static br.uag.ufrpe.negocio.Data.converterDataParaLocalDate;
import java.time.LocalDate;
/**
 * Esta classe tem a função de representar um Passageiro da Viagem.
 * 
 * @author Jackson / Gabriel
 */
public class Passageiro extends Pessoa {
     
    private String dataNascimento;
    private boolean possuiIdJovem;

     public Passageiro(String nomeCompleto, String cpf, String rg, String telefone, String dataNascimento, boolean possuiIdJovem ) {
        super(nomeCompleto, cpf, rg,  telefone);
        this.dataNascimento = dataNascimento; 
        this.possuiIdJovem = possuiIdJovem;
    }
    
       
    public boolean isPossuiIdJovem() {
        return possuiIdJovem;
    }

    public void setPossuiIdJovem(boolean possuiIdJovem) {
        this.possuiIdJovem = possuiIdJovem;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    public boolean equals(Object obj){
        if(obj instanceof Passageiro){
            Passageiro passageiro = (Passageiro)obj;
            return getCpf().equals(passageiro.getCpf());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Passageiro{" + super.toString() + "Data de Nascimento=" +dataNascimento+ ", possuiIdJovem=" + possuiIdJovem + '}';
    }

}
