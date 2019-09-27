package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Gerente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class RepositorioGerente {
    
    private final List<Gerente> gerentes;
    
    public RepositorioGerente() {
        gerentes = new ArrayList<>();        
    }
    
    public void adicionarGerente(Gerente gerente) {
        if (procurarGerente(gerente.getCpf()) == null) {
            gerentes.add(gerente);
        }        
    }
    
    public boolean alterarGerente(Gerente gerente) {
        Gerente novoGerente = procurarGerente(gerente.getCpf());
        
        if (novoGerente != null) {
            gerentes.remove(novoGerente);
            gerentes.add(gerente);
            return true;
        }
        return false;
    }
    
    public Gerente procurarGerente(String cpf) {
        Gerente encontrado = null;
        
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf().equals(cpf)) {
                encontrado = gerentes.get(i);
            }
        }
        return encontrado;
    }
    
    public void removerGerente(Gerente gerente) {
        Gerente encontrado = procurarGerente(gerente.getCpf());
        
        if (encontrado != null) {
            gerentes.remove(encontrado);
        }
    }
    
}
