/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.passageiro;

/**
 *
 * @author Itamar Jr
 */
public class PassageiroJaEstaNaViagemException extends Exception {

    public PassageiroJaEstaNaViagemException() {
        super("Esse passageiro já está nesta viagem");
    }
    
}
