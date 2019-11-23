package br.uag.ufrpe.negocio.excecoes.funcionario;

/**
 *
 * @author Jackson
 */
public class FuncionarioNaoEncontradoException extends Exception {

    public FuncionarioNaoEncontradoException() {
        super("Funcionario nao encontrado no repositorio");
    }
    
}
