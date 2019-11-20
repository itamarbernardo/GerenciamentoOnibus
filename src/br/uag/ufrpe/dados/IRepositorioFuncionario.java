package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.Funcionario;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioFuncionario
 * @author Jackson
 */
public interface IRepositorioFuncionario {
    void adicionarFuncionario(Funcionario funcionario);
    void alterarFuncionario(Funcionario funcionario);
    Funcionario procurarFuncionario(String cpf);
    void removerFuncionario(Funcionario funcionario);
    List<Funcionario> listagemFuncionarios();
}
