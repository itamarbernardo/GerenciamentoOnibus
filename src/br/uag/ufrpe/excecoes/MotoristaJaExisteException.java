/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
pacote  br.uag.ufrpe.excecoes;

/**
 *
 * @author Gabriel
 */
public class MotoristaJaExisteException extends Exception {

    public MotoristaJaExisteException() {
        super("Motoista já existe");
    }
    
}
