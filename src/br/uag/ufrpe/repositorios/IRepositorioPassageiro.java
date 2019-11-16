package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Passageiro;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioPassageiro
 * @author Jackson
 */
public interface IRepositorioPassageiro {
    void adicionarPassageiro(Passageiro passageiro);
    boolean alterarPassageiro(Passageiro passageiro);
    Passageiro procurarPassageiro(String cpf);
    void removerPassageiro(Passageiro passageiro);
    List<Passageiro> listagemPassageiros();
}
