/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio.excessoes;

/**
 *
 * @author miyyu
 */
public class PassagemJaExisteException extends Exception {
    
    public PassagemJaExisteException(){
        super("Passagem já está em repositório.");
    }
    
}
