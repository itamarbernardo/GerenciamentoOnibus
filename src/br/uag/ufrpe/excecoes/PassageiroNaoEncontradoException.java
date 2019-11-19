package br.uag.ufrpe.excecoes;

/**
 *
 * @author Jackson
 */
public class PassageiroNaoEncontradoException extends Exception {

    public PassageiroNaoEncontradoException() {
        super("Passageiro não existe no Repositorio");
    }
    
}
