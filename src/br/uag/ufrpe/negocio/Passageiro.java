/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

/**
 *
 * @author Itamar Jr
 */
public class Passageiro {
    private String dataNascimento;
    private boolean possuiIdJovem;
    private String cpf;

    public Passageiro(boolean possuiIdJovem, String cpf) {
        this.possuiIdJovem = possuiIdJovem;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
    public int calcularIdade(){
        return 20;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isPossuiIdJovem() {
        return possuiIdJovem;
    }

    public void setPossuiIdJovem(boolean possuiIdJovem) {
        this.possuiIdJovem = possuiIdJovem;
    }

    @Override
    public String toString() {
        return "Passageiro{" + "dataNascimento=" + dataNascimento + ", possuiIdJovem=" + possuiIdJovem + '}';
    }
    
    
    
}
