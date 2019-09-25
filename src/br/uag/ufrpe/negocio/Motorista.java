package br.uag.ufrpe.negocio;


public class Motorista extends Pessoa{
    private String numeroCarteiraMotorista; 

    public Motorista(String numeroCarteiraMotorista, String nomeCompleto, String cpf, String rg, String email, Endereco endereco, String telefone) {
        super(nomeCompleto, cpf, rg, email, endereco, telefone);
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
    }

    public String getNumeroCarteiraMotorista() {
        return numeroCarteiraMotorista;
    }

    public void setNumeroCarteiraMotorista(String numeroCarteiraMotorista) {
        if(numeroCarteiraMotorista.length() == 11){
            this.numeroCarteiraMotorista = numeroCarteiraMotorista;
        }
        else{
            System.out.println("Carteira invalida");
        }
    }
    
}
