/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.PassagemJaExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoExisteException;
import br.uag.ufrpe.dados.interfaces.IRepositorioPassagem;

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
        
    }
    
    public void alterarPassagem(Passagem passagem) throws PassagemNaoExisteException{
        
    }
    
    public Passagem procurarPassagem(int codigo){
        return null;
    }
    
    public void removerPassagem(Passagem passagem) throws PassagemNaoExisteException{
        
    }
    
    public void removerPassagem(int codigo) throws PassagemNaoExisteException{
        
    }   
    
}
