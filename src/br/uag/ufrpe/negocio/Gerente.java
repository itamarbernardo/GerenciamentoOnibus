package br.uag.ufrpe.negocio;

import java.time.LocalDate;
/**
 *
 * @author Jackson
 */
public class Gerente extends Pessoa{
       
    private String senha;

    public Gerente(String nomeCompleto, String cpf,String rg, String email, String identificador, String telefone, 
            Endereco endereco, LocalDate dataNasc, String senha) {
        super(nomeCompleto, cpf, rg, email, endereco, telefone);
        
        this.senha = senha;
    }
               
    public String getSenha(String senha){
        return senha;
    }
    
    public void setSenha(String senha){
        if(senha.length() > 3){
            this.senha = senha;
        }
        else{
            System.out.println("Senha muito curta, Tente novamente");
        }
    }
}
