package br.uag.ufrpe.excecoes;

/**
 *
 * @author Jackson
 */
public class FuncionarioNaoEncontradoException extends Exception {

    public FuncionarioNaoEncontradoException() {
        super("Funcionario nao encontrado no repositorio");
    }
    
}
