/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.viagem;

/**
 *
 * @author Itamar Jr
 */
public class ViagemNaoExisteException extends Exception{
    
    public ViagemNaoExisteException(){
        super("Esta viagem não existe no repositorio.");
    }
    
}
