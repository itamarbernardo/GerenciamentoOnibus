package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Passageiro;
import java.util.ArrayList;
import java.util.List;
/**
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
        Passageiro novoPassageiro = procurarPassageiro(passageiro.getCpf());
        
        if(novoPassageiro != null){
            passageiros.remove(novoPassageiro);
            passageiros.add(passageiro);
            return true;            
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
