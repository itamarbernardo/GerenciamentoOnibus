package br.uag.ufrpe.dados.interfaces;

import br.uag.ufrpe.negocio.Funcionario;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioFuncionario
 * @author Jackson
 */
public interface IRepositorioFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    boolean alterarFuncionario(Funcionario funcionario);
    Funcionario procurarFuncionario(String cpf);
    void removerFuncionario(Funcionario funcionario);
    List<Funcionario> listagemFuncionarios();
}
