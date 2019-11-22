package br.uag.ufrpe.negocio.excecoes;

/**
 *
 * @author Jackson
 */
public class PassageiroNaoExisteException extends Exception {

    public PassageiroNaoExisteException() {
        super("Passageiro não existe no Repositorio");
    }
    
}
