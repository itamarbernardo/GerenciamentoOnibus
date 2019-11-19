package br.uag.ufrpe.dados.interfaces;

import br.uag.ufrpe.negocio.Motorista;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioMotorista
 * @author Jackson
 */
public interface IRepositorioMotorista {
    void adicionarMotorista(Motorista motorista);
    boolean alterarMotorista(Motorista motorista);
    Motorista procurarMotorista(String numeroCarteiraMotorista);
    void removerMotorista(Motorista motorista);
    List<Motorista> listagemMotorista();
    
}
