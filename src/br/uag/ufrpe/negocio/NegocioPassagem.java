/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.PassagemJaExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoExisteException;
import br.uag.ufrpe.dados.IRepositorioPassagem;


/**
 *
 * @author Emily Santos
 */
public class NegocioPassagem {
    
    private IRepositorioPassagem repositorio;

    public NegocioPassagem(IRepositorioPassagem repositorio) {
        this.repositorio = repositorio;
    }
    
    // ------------------------------ METODOS ----------------------------------
    
    public void adicionarPassagem(Passagem passagem) throws PassagemJaExisteException{
        if(repositorio.procurarPassagem(passagem) == null){
            repositorio.adicionarPassagem(passagem);
        }
        
        throw new PassagemJaExisteException();
        
    }
    
    public void alterarPassagem(Passagem passagem) throws PassagemNaoExisteException{
        if(repositorio.procurarPassagem(passagem) != null){
            repositorio.alterarPassagem(passagem);
        }
        
        throw new PassagemNaoExisteException();
        
    }
    
    public Passagem procurarPassagem(int codigo){
        if(repositorio.procurarPassagem(codigo) != null){
            return repositorio.procurarPassagem(codigo);
        }
        
        return null;
    }
    
    public Passagem procurarPassagem(Passagem passagem){
        if(repositorio.procurarPassagem(passagem) != null){
            return repositorio.procurarPassagem(passagem);
        }
        
        return null;
    }
    
    public void removerPassagem(Passagem passagem) throws PassagemNaoExisteException{
        if(repositorio.procurarPassagem(passagem) != null){
            repositorio.removerPassagem(passagem);
        }
        
        throw new PassagemNaoExisteException();
        
    }
    
    public void removerPassagem(int codigo) throws PassagemNaoExisteException{
        if(repositorio.procurarPassagem(codigo) != null){
            repositorio.removerPassagem(codigo);
        }
        
        throw new PassagemNaoExisteException();
        
    }
  
}
