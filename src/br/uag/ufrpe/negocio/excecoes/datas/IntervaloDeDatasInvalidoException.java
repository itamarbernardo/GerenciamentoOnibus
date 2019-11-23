/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.datas;

/**
 *
 * @author Itamar Jr
 */
public class IntervaloDeDatasInvalidoException extends Exception{
    
    public IntervaloDeDatasInvalidoException(){
        super("O intervalo de datas informado é inválido");
    }
}
