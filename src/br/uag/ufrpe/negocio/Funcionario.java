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
public class Funcionario extends Pessoa{
    
    private String senha; 

    public Funcionario(String senha, String nomeCompleto, String cpf, String rg, String email, Endereco endereco, String telefone) {
        super(nomeCompleto, cpf, rg, email, endereco, telefone);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.length() > 3){
            this.senha = senha;
        }
        else{ 
            System.out.println("Senha incorreta");
        }
    }   
}
