package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Funcionários
 * 
 * @author Jackson
 */
public class RepositorioFuncionario implements iRepositorioFuncionario {

    private final List<Funcionario> funcionarios;

    public RepositorioFuncionario() {
        funcionarios = new ArrayList<>();
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        if (procurarFuncionario(funcionario.getCpf()) == null) {
            funcionarios.add(funcionario);
        }
    }

    @Override
    public boolean alterarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionario.equals(funcionarios.get(i))) {
                funcionarios.set(i, funcionario);
                return true;
            }

        }
        return false;
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
        Funcionario encontrado = procurarFuncionario(funcionario.getCpf());

        if (encontrado != null) {
            funcionarios.remove(encontrado);
        }
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
