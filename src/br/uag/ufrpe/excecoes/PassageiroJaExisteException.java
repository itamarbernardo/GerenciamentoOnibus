package br.uag.ufrpe.excecoes;

/**
 *
 * @author Jackson
 */
public class PassageiroJaExisteException extends Exception {

    public PassageiroJaExisteException() {
        super("Passageiro ja existe no repositorio");
    }
    
}
