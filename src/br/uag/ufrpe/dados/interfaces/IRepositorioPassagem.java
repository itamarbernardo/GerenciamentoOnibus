package br.uag.ufrpe.dados.interfaces;

import br.uag.ufrpe.negocio.Passagem;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioPassagem
 * @author Jackson
 */

public interface IRepositorioPassagem {
    void adicionarPassagem(Passagem passagem);
    void alterarPassagem(Passagem passagem);
    Passagem procurarPassagem(int codigo);
    void removerPassagem(int codigo);
    void removerPassagem(Passagem passagem);
    List<Passagem> listagemPassagem();
    
}
