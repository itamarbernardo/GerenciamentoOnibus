package br.uag.ufrpe.negocio;

/**
 *
 * @author Gabriel / Jackson
 */

public abstract class Pessoa {
    protected String nomeCompleto;
    protected String cpf;
    protected String rg;
    protected String telefone;
    private Endereco endereco;

    public Pessoa(String nomeCompleto, String cpf, String rg, String telefone, Endereco endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }  
    
    @Override
    public String toString(){
        return "Pessoa{" + "Nome Completo = " + nomeCompleto + "Cpf = " + cpf + "Rg = " + rg + "Telefone = " + telefone + "Endereco = " + endereco + "}"; 
    }
}
