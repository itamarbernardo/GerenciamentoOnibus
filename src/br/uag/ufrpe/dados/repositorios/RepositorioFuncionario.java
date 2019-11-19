package br.uag.ufrpe.dados.repositorios;

import br.uag.ufrpe.dados.interfaces.IRepositorioFuncionario;
import br.uag.ufrpe.negocio.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Funcionários
 * 
 * @author Jackson
 */
public class RepositorioFuncionario implements IRepositorioFuncionario {

    private final List<Funcionario> funcionarios;

    public RepositorioFuncionario() {
        funcionarios = new ArrayList<>();
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
       funcionarios.add(funcionario);
    }

    @Override
    public void alterarFuncionario(Funcionario funcionario) {
        int i = funcionarios.indexOf(funcionario);
        funcionarios.set(i, funcionario);
    }

    @Override
    public Funcionario procurarFuncionario(String cpf) {
        Funcionario encontrado = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                encontrado = funcionario;
                return encontrado;
            }
        }
        return encontrado;
    }

    @Override
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
    
    @Override
     public List<Funcionario> listagemFuncionarios() {
        List<Funcionario> funcionariosCopia = new ArrayList<>();
        for(Funcionario f : funcionarios){
            funcionariosCopia.add(f);
        }
        
        return funcionariosCopia;
    }

}
