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
 * @author Jackson
 */
public class Passageiro {
    
    private String nomeCompleto;    
    private String dataNascimento;
    private String rg;
    private String cpf;
    private String telefone;
    private boolean possuiIdJovem;

    public Passageiro(String nomeCompleto, String dataNascimento, String rg, String cpf, String telefone, boolean possuiIdJovem) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.possuiIdJovem = possuiIdJovem;
    }
    
       
    public boolean isPossuiIdJovem() {
        return possuiIdJovem;
    }

    public void setPossuiIdJovem(boolean possuiIdJovem) {
        this.possuiIdJovem = possuiIdJovem;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
            if(cpf.equals(passageiro.getCpf())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Passageiro{" + "nomeCompleto=" + nomeCompleto + ", dataNascimento=" + dataNascimento + ", rg=" + rg + ", cpf=" + cpf + ", telefone=" + telefone + ", possuiIdJovem=" + possuiIdJovem + '}';
    }

}
