
package teste;


public class Motorista extends Pessoa{
    private int numeroCarteiraMotorista; 

    public Motorista(int numeroCarteiraMotorista, String nomeCompleto, String cpf, String rg, String email, String login, Endereco endereco) {
        super(nomeCompleto, cpf, rg, email, login, endereco);
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
    }
    
    public int getNumeroCarteiraMotorista() {
        return numeroCarteiraMotorista;
    }
    
    public void setNumeroCarteiraMotorista(int numeroCarteiraMotorista) {
        this.numeroCarteiraMotorista = numeroCarteiraMotorista;
    }
    
}
