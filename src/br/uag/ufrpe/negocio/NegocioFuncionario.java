package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.entidades.Funcionario;
import br.uag.ufrpe.negocio.excecoes.funcionario.FuncionarioNaoEncontradoException;
import br.uag.ufrpe.negocio.excecoes.funcionario.FuncionarioJaExisteException;

import br.uag.ufrpe.dados.IRepositorioFuncionario;
import br.uag.ufrpe.dados.RepositorioFuncionario;

/**
 *
 * @author Jackson
 */
public class NegocioFuncionario {
    private final IRepositorioFuncionario repositorio;
    
    public NegocioFuncionario(){
        this.repositorio = new RepositorioFuncionario();
    }
    
    public void adicionarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{
        if(procurarFuncionario(funcionario.getCpf()) == null){
            repositorio.adicionarFuncionario(funcionario);
        }
        else{
            throw new FuncionarioJaExisteException();
        }
    }
    
    public void alterarFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
        int index = repositorio.listagemFuncionarios().indexOf(funcionario);
        
        if(index == -1){
            throw new FuncionarioNaoEncontradoException();
        }
        else{
            repositorio.alterarFuncionario(funcionario);
        }
    }
    
    public Funcionario procurarFuncionario(String cpf){
        return repositorio.procurarFuncionario(cpf);
    }
    
    public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
        Funcionario encontrado = procurarFuncionario(funcionario.getCpf());
        
        if(encontrado != null){
            repositorio.removerFuncionario(encontrado);
        }
        else{
            throw new FuncionarioNaoEncontradoException();
        }
    }
    
}
