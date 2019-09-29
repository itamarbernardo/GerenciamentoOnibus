package br.uag.ufrpe.negocio;


public class Motorista extends Pessoa{
    private String numeroCarteiraMotorista; 

    public Motorista(String nomeCompleto, String cpf, String rg, String telefone, Endereco endereco, String numeroCarteiraMotoristaString) {
        super(nomeCompleto, cpf, rg,  telefone, endereco);
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
