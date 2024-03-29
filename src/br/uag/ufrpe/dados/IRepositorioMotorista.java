package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Motorista;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioMotorista
 * @author Jackson
 */
public interface IRepositorioMotorista {
    void adicionarMotorista(Motorista motorista);
    void alterarMotorista(Motorista motorista);
    Motorista procurarMotorista(String numeroCarteiraMotorista);
    void removerMotorista(Motorista motorista);
    List<Motorista> listagemMotorista();
    
}
