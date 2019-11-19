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
        passageiros.add(passageiro);    
    }
    
    @Override
    public void alterarPassageiro(Passageiro passageiro){
        int i = passageiros.indexOf(passageiro);
        passageiros.set(i, passageiro);
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
        passageiros.remove(passageiro);                
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
