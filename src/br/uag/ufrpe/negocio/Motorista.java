package br.uag.ufrpe.negocio;

/**
 * Esta classe representa um Motorista do Onibus
 * 
 * @author Gabriel
 */
public class Motorista extends Pessoa{
    private String numeroCarteiraMotorista; 
    private Endereco endereco;
    
    public Motorista(String nomeCompleto, String cpf, String rg, String telefone, String numeroCarteiraMotorista, Endereco endereco) {
        super(nomeCompleto, cpf, rg,  telefone);
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
        this.endereco = endereco;
    }

    public String getNumeroCarteiraMotorista() {
        return numeroCarteiraMotorista;
    }
    
    
    public boolean setNumeroCarteiraMotorista(String numeroCarteiraMotorista) {
        if(numeroCarteiraMotorista.length() == 11){
            this.numeroCarteiraMotorista = numeroCarteiraMotorista;
            return true;
        }
        return false;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
     public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Motorista) {
            Motorista motorista = (Motorista) obj;
            if (numeroCarteiraMotorista.equals(motorista.getNumeroCarteiraMotorista())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Motorista{" + super.toString() + "numeroCarteiraMotorista=" + numeroCarteiraMotorista + "Endereço=" + endereco +'}';
    }
        
}
