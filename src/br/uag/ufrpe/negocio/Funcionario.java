/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 * Esta classe representa um funcionário da empresa.
 * 
 * @author Gabriel / Jackson
 */
public class Funcionario extends Pessoa{
    
    private String senha; 
    private String email;
    private boolean eGerente;

    public Funcionario(String senha, String email, String nomeCompleto, String cpf, String rg, String telefone, Endereco endereco, boolean eGerente) {
        super(nomeCompleto, cpf, rg, telefone, endereco);
        this.senha = senha;
        this.email = email;
        this.eGerente = eGerente;
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

    public boolean setSenha(String senha) {
        if(senha.length() > 3){
            this.senha = senha;
            return true;
        }
        return false;      
    }

    public void seteGerente(boolean eGerente) {
        this.eGerente = eGerente;
    }
    
    public boolean eGerente(){
        return eGerente;
    }
   
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Funcionario){
            Funcionario funcionario = (Funcionario)obj;
            return getCpf().equals(funcionario.getCpf());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Funcionario{" + super.toString() + "senha=" + senha + ", email=" + email + ", eGerente=" + eGerente + '}';
    }
    

}
