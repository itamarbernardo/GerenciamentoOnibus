package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Passageiro;
import java.util.ArrayList;
import java.util.List;
/**
 *Esta classe representa um repositório de Passageiros
 * 
 * @author Jackson
 */
public class RepositorioPassageiro {
    
    private final List<Passageiro> passageiros;
    
    public RepositorioPassageiro(){
        passageiros = new ArrayList<>();
    }
    
    public void adicionarPassageiro(Passageiro passageiro){
        
        if(procurarPassageiro(passageiro.getCpf()) == null){
            passageiros.add(passageiro);
        }     
    }
    
    public boolean alterarPassageiro(Passageiro passageiro){
        for (int i = 0; i < passageiros.size(); i++) {
            if (passageiro.equals(passageiros.get(i))) {
                passageiros.set(i, passageiro);
                return true; //So altera se a viagem existir
            }

        }
        return false;
        
   }
    
    public Passageiro procurarPassageiro(String cpf){
        Passageiro encontrado = null;
        
        for (Passageiro passageiro : passageiros) {
            if(passageiro.getCpf().equals(cpf)){
                encontrado = passageiro;
                return encontrado;
            }
        }
        return encontrado;
    }
    
    public void removerPassageiro(Passageiro passageiro){
        Passageiro encontrado = procurarPassageiro(passageiro.getCpf());
        
        if(encontrado != null){
            passageiros.remove(encontrado);           
        }     
    }
}
