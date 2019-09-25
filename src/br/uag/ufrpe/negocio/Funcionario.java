/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author USUARIO
 */
public class Funcionario extends Pessoa{
    
    private String senha; 

    public Funcionario(String senha, String nomeCompleto, String cpf, String rg, String email, Endereco endereco) {
        super(nomeCompleto, cpf, rg, email, endereco);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
