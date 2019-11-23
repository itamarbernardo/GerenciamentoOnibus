package br.uag.ufrpe.negocio.entidades;

/**
 * Esta classe junta os atributos comuns de um objeto Pessoa.
 * 
 * @author Gabriel / Jackson
 */

public abstract class Pessoa {
    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String telefone;

    public Pessoa(String nomeCompleto, String cpf, String rg, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;

    } 
    
    public  String getNomeCompleto() {
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
    
    @Override
    public String toString(){
        return "Pessoa{" + "Nome Completo = " + nomeCompleto + "Cpf = " + cpf + "Rg = " + rg + "Telefone = " + telefone + "}"; 
    }
}
