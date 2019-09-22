package br.uag.ufrpe.negocio;

import java.time.LocalDate;
/**
 *
 * @author Jackson
 */
public class Gerente {
    
    private String nome;
    private String cpf;
    private String identificador;
    private String telefone;
    private Endereco endereco;
    private LocalDate dataNasc;
    
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public Endereco getEndereco(){
        return endereco;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public LocalDate getDataNasc(){
        return dataNasc;
    }
    
    public void setDatanasc(LocalDate dataNasc){
        this.dataNasc = dataNasc;
    }
    

}
