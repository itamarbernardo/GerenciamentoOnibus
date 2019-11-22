package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.PassageiroNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassageiroJaExisteException;

import br.uag.ufrpe.dados.IRepositorioPassageiro;

/**
 *
 * @author Jackson
 */
public class NegocioPassageiro{
    private final IRepositorioPassageiro repositorio;

    public NegocioPassageiro(IRepositorioPassageiro repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarPassageiro(Passageiro passageiro) throws PassageiroJaExisteException, PassageiroNaoExisteException{
        if(procurarPassageiro(passageiro.getCpf()) == null){
            repositorio.adicionarPassageiro(passageiro);
        }
        else{
            throw new PassageiroJaExisteException();
        }
    }
    
    public void alterarPassageiro(Passageiro passageiro) throws PassageiroNaoExisteException{
        int index = repositorio.listagemPassageiros().indexOf(passageiro);
        
        if(index == -1){
            throw new PassageiroNaoExisteException();
        }
        else{
            repositorio.alterarPassageiro(passageiro);
        }
    }
    
    public Passageiro procurarPassageiro(String cpf){
       return repositorio.procurarPassageiro(cpf);
    }
    
    public void removerPassageiro(Passageiro passageiro) throws PassageiroNaoExisteException{
        Passageiro encontrado = procurarPassageiro(passageiro.getCpf());
        
        if(encontrado != null){
            repositorio.removerPassageiro(encontrado);
        }
        else{
            throw new PassageiroNaoExisteException();
        }
    }

   
}