package br.uag.ufrpe.dados.repositorios;

import br.uag.ufrpe.dados.interfaces.IRepositorioPassageiro;
import br.uag.ufrpe.negocio.Passageiro;
import java.util.ArrayList;
import java.util.List;
/**
 *Esta classe representa um repositório de Passageiros
 * 
 * @author Jackson
 */
public class RepositorioPassageiro implements IRepositorioPassageiro {
    
    private final List<Passageiro> passageiros;
    
    public RepositorioPassageiro(){
        passageiros = new ArrayList<>();
    }
    
    @Override
    public void adicionarPassageiro(Passageiro passageiro){
        
        if(procurarPassageiro(passageiro.getCpf()) == null){
            passageiros.add(passageiro);
        }     
    }
    
    @Override
    public boolean alterarPassageiro(Passageiro passageiro){
        for (int i = 0; i < passageiros.size(); i++) {
            if (passageiro.equals(passageiros.get(i))) {
                passageiros.set(i, passageiro);
                return true; //So altera se a viagem existir
            }

        }
        return false;
        
   }
    
    @Override
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
    
    @Override
    public void removerPassageiro(Passageiro passageiro){
        Passageiro encontrado = procurarPassageiro(passageiro.getCpf());
        
        if(encontrado != null){
            passageiros.remove(encontrado);           
        }     
    }
    
    @Override
     public List<Passageiro> listagemPassageiros() {
        List<Passageiro> passageirosCopia = new ArrayList<>();
        for(Passageiro p : passageiros){
            passageirosCopia.add(p);
        }
        
        return passageirosCopia;
    }
}
