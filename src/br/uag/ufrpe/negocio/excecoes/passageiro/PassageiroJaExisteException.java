package br.uag.ufrpe.negocio.excecoes.passageiro;

/**
 *
 * @author Jackson
 */
public class PassageiroJaExisteException extends Exception {

    public PassageiroJaExisteException() {
        super("Passageiro ja existe no repositorio");
    }
    
}
