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
    private String telefone;
    private Endereco endereco;

    public Pessoa(String nomeCompleto, String cpf, String rg, String email,Endereco endereco,String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
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
        if(cpf.length() == 11){
            this.cpf = cpf;
        }
        else{
            System.out.println("CPF invalido !!");
        }
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.length() == 11){
            this.telefone = telefone;
        }
        else{
            System.out.println("Telefone invalido !");
        }
    }
    
}
