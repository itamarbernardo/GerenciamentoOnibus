package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Passageiro;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioPassageiro
 * @author Jackson
 */
public interface IRepositorioPassageiro {
    void adicionarPassageiro(Passageiro passageiro);
    void alterarPassageiro(Passageiro passageiro);
    Passageiro procurarPassageiro(String cpf);
    void removerPassageiro(Passageiro passageiro);
    List<Passageiro> listagemPassageiros();
}
