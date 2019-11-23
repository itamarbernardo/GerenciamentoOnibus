package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Onibus;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioOnibus
 * @author Jackson
 */
public interface IRepositorioOnibus {
    void adicionarOnibus(Onibus oni);
    void alterarOnibus(Onibus oni);
    Onibus procurarOnibus(String placa);
    void removerOnibus(String placa);
    void removerOnibus(Onibus o);
    List<Onibus> listagemOnibus();
}
