package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Funcionario;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioFuncionario
 * @author Jackson
 */
public interface iRepositorioFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    boolean alterarFuncionario(Funcionario funcionario);
    Funcionario procurarFuncionario(String cpf);
    void removerFuncionario(Funcionario funcionario);
    List<Funcionario> listagemFuncionarios();
}
