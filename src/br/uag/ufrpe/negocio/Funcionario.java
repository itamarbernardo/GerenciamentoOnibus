/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author Gabriel / Jackson
 */
public class Funcionario extends Pessoa{
    
    private String senha; 
    private String email;
    private final Endereco endereco;

    public Funcionario(String senha, String email, String nomeCompleto, String cpf, String rg, String telefone, Endereco endereco) {
        super(nomeCompleto, cpf, rg, telefone, endereco);
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
