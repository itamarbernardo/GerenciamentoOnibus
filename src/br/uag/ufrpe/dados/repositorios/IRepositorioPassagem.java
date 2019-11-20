package br.uag.ufrpe.dados.repositorios;

import br.uag.ufrpe.negocio.Passagem;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioPassagem
 * @author Jackson
 */

public interface IRepositorioPassagem {
    boolean adicionarPassagem(Passagem passagem);
    boolean alterarPassagem(Passagem passagem);
    Passagem procurarPassagem(int codigo);
    boolean removerPassagem(int codigo);
    boolean removerPassagem(Passagem passagem);
    List<Passagem> listagemPassagem();
    
}
