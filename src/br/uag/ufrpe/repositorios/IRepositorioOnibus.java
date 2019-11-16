package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Onibus;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioOnibus
 * @author Jackson
 */
public interface IRepositorioOnibus {
    boolean adicionarOnibus(Onibus oni);
    boolean alterarOnibus(Onibus oni);
    Onibus procurarOnibus(String placa);
    boolean removerOnibus(String placa);
    boolean removerOnibus(Onibus o);
    List<Onibus> listagemOnibus();
}
