/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.passagem;

/**
 *
 * @author Itamar Jr
 */
public class PassagemNaoPertenceAViagemException extends Exception{
    
    public PassagemNaoPertenceAViagemException(){
        super("A passagem não pertence a esta viagem.");
    }
    
}
