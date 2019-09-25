/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String email; 
    private Endereco endereco;

    public Pessoa(String nomeCompleto, String cpf, String rg, String email,Endereco endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.endereco = endereco;
    }

    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

  
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public String getRg() {
        return rg;
    }

  
    public void setRg(String rg) {
        this.rg = rg;
    }

   
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

   
    public Endereco getEndereco() {
        return endereco;
    }

    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    

   
}
