package br.uag.ufrpe.negocio;


public class Motorista extends Pessoa{
    private int numeroCarteiraMotorista; 

    public Motorista(int numeroCarteiraMotorista, String nomeCompleto, String cpf, String rg, String email, Endereco endereco) {
        super(nomeCompleto, cpf, rg, email, endereco);
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
    }
    
    public int getNumeroCarteiraMotorista() {
        return numeroCarteiraMotorista;
    }
    
    public void setNumeroCarteiraMotorista(int numeroCarteiraMotorista) {
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
    }
    
}
