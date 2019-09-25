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
    
    public void alterarPassageiro(Passageiro passageiro){
        Passageiro encontrado = procurarPassageiro(passageiro.getCpf());
        
        if(encontrado != null){
            
        }
    }
    
    public Passageiro procurarPassageiro(String cpf){
        Passageiro encontrado = null;
        
        Passageiro[] lista = passageiros.toArray(new Passageiro[passageiros.size()]);
        for(int i = 0; i < passageiros.size(); i++){
            if(lista[i].getCpf().equals(cpf)){
                encontrado = lista[i];
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
