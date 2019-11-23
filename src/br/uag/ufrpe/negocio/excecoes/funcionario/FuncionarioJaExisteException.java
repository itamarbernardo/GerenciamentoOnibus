/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio.excecoes.funcionario;

/**
 *
 * @author Jackson
 */
public class FuncionarioJaExisteException extends Exception {

    public FuncionarioJaExisteException() {
        super("Funcionario ja existe no Repositorio");
    }
    
}
