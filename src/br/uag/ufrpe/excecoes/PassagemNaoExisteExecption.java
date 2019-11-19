/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author miyyu
 */
class passagemNaoExisteException extends Exception {
    
    public passagemNaoExisteException(){
        super("Passagem não existe no repositório.");
    }
    
}
