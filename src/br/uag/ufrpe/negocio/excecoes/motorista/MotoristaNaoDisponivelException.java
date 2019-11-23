/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.motorista;

/**
 *
 * @author Itamar Jr
 */
public class MotoristaNaoDisponivelException extends Exception {

    public MotoristaNaoDisponivelException() {
        super("O motorista já está em outra viagem neste mesmo horário");
    }
    
}
