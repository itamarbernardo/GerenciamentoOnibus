/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.excecoes;

/**
 *
 * @author Gabriel
 */
public class MotoristaNaoExisteException extends Exception {

    public MotoristaNaoExisteException() { 
        super("Motorista não existe"); 
    }
    
    
}
