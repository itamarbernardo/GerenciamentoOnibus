package br.uag.ufrpe.negocio;

import br.uag.ufrpe.excecoes.PassageiroNaoEncontradoException;
import br.uag.ufrpe.excecoes.PassageiroJaExisteException;
import br.uag.ufrpe.dados.interfaces.IRepositorioPassageiro;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class NegocioPassageiro{
    private final IRepositorioPassageiro repositorio;

    public NegocioPassageiro(IRepositorioPassageiro repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarPassageiro(Passageiro passageiro) throws PassageiroJaExisteException, PassageiroNaoEncontradoException{
        if(procurarPassageiro(passageiro.getCpf()) == null){
            repositorio.adicionarPassageiro(passageiro);
        }
        else{
            throw new PassageiroJaExisteException();
        }
    }
    
    public void alterarPassageiro(Passageiro passageiro) throws PassageiroNaoEncontradoException{
        int index = repositorio.listagemPassageiros().indexOf(passageiro);
        
        if(index == -1){
            throw new PassageiroNaoEncontradoException();
        }
        else{
            repositorio.alterarPassageiro(passageiro);
        }
    }
    
    public Passageiro procurarPassageiro(String cpf){
       return repositorio.procurarPassageiro(cpf);
    }
    
    public void removerPassageiro(Passageiro passageiro) throws PassageiroNaoEncontradoException{
        Passageiro encontrado = procurarPassageiro(passageiro.getCpf());
        
        if(encontrado != null){
            repositorio.removerPassageiro(encontrado);
        }
        else{
            throw new PassageiroNaoEncontradoException();
        }
    }

    public List<Passageiro> listagemPassageiros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}