package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Viagem;
import java.util.List;

/**
 * Interface responsavel pelos contratos do RepositorioViagem
 * @author Jackson
 */
public interface IRepositorioViagem {
    double calculaPorcentagemLanchePorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim);
    double calculaPorcentagemLanchePorDatasEDestino(String origem, String destino, String dataInicio, String dataFim);
    double calculaPorcentagemLanchePorDatas(String dataInicio, String dataFim);
    double calculaPorcentagemPassageirosPorDatas(String dataInicio, String dataFim);
    double calculaPorcentagemPassageirosPorDatasEViagens(String horario, String origem, String destino, String dataInicio, String dataFim);
    double calculaPorcentagemPassageirosPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim);
    double calcularLucroTotalPorDatas(String dataInicio, String dataFim);
    double calcularLucroTotalPorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim);
    double calcularLucroTotalPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim);
    String procurarUltimasViagensDeUmPassagiro(Passageiro passageiro);
    void adicionarViagem(Viagem v);
    void removerViagem(Viagem viagem);
    void alterarViagem(Viagem viagem);
    Viagem procurarViagem(int codigo);
    Viagem procurarViagem(String dataSaida, String horaSaida, String origem, String destino);
    List<Viagem> listagemViagens();
    
}
