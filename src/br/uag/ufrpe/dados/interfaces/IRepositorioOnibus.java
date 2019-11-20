package br.uag.ufrpe.dados.interfaces;

import br.uag.ufrpe.negocio.Onibus;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioOnibus
 * @author Jackson
 */
public interface IRepositorioOnibus {
    void adicionarOnibus(Onibus oni);
    void alterarOnibus(Onibus oni);
    Onibus procurarOnibus(String placa);
    Onibus procurarOnibus(Onibus oni);
    void removerOnibus(String placa);
    void removerOnibus(Onibus o);
    List<Onibus> listagemOnibus();
}
