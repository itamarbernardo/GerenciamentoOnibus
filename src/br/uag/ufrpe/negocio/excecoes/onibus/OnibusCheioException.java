/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio.excecoes.onibus;

/**
 *
 * @author Itamar Jr
 */
public class OnibusCheioException extends Exception {

    public OnibusCheioException() {
        super("Não há mais assentos disponíveis neste onibus.");
    }
    
}
