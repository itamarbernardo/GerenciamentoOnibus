/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Data;
import br.uag.ufrpe.negocio.entidades.Passageiro;
import br.uag.ufrpe.negocio.entidades.Viagem;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe é um Repositorio de Viagens e gera os relatórios desejados no
 * projeto.
 *
 * @author Itamar Jr
 */
public class RepositorioViagem implements IRepositorioViagem {

    private final List<Viagem> viagens;

    public RepositorioViagem() {
        viagens = new ArrayList<>();
    }

    /**
     * Este método calcula a porcentagem de passageiros que querem lanche em um
     * intervalo de datas nas viagens de determinado horario e destino.
     *
     * @param horarioSaida Horario de saída da viagem.
     * @param origem Cidade onde a viagem inicia.
     * @param destino Destino da Viagem.
     * @param dataInicio Data de inicio do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna a porcentagem de passageiros que querem lanche
     */
    @Override
    public double calculaPorcentagemLanchePorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalPassageiros = 0.0;
        double totalPassageirosQueremLanche = 0.0;
        //Supondo que está nesse intervalo
        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());

            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getHorarioSaida().equals(horarioSaida) && viagem.getOrigem().equals(origem)) {
                //Verifico o intervalo das datas, o horario e o destino

                totalPassageirosQueremLanche = totalPassageirosQueremLanche + viagem.calculaQuantidadeLanche();
                totalPassageiros = totalPassageiros + viagem.calcularQuantidadeDePassageiros();

            }
        }
        if (totalPassageiros != 0) {
            porcentagem = totalPassageirosQueremLanche / totalPassageiros;

        }

        return porcentagem;
    }

    /**
     * Este método calcula a porcentagem da quantidade de passageiros que querem
     * lancge num intervalo de datas em certo destino
     *
     * @param origem Cidade onde a viagem inicia.
     * @param destino Destino da viagem.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna a porcentagem.
     */
    @Override
    public double calculaPorcentagemLanchePorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalPassageiros = 0.0;
        double totalPassageirosQueremLanche = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());

            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getOrigem().equals(origem)) {
                //Verifico o intervalo das datas, o horario e o destino

                totalPassageirosQueremLanche = totalPassageirosQueremLanche + viagem.calculaQuantidadeLanche();
                totalPassageiros = totalPassageiros + viagem.calcularQuantidadeDePassageiros();

            }
        }

        if (totalPassageiros != 0) {
            porcentagem = totalPassageirosQueremLanche / totalPassageiros;
        }

        return porcentagem;
    }

    /**
     * Este método calcula a porcentagem de passageiros que querem lanche em
     * certo intervalo de datas em todas as viagens.
     *
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna a porcentagem da quantidade de passageiros que querem
     * lanche.
     */
    @Override
    public double calculaPorcentagemLanchePorDatas(String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalPassageiros = 0.0;
        double totalPassageirosQueremLanche = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());
            if (estaNoIntervalo) { //Tem que verificar o intervalo das datas

                totalPassageirosQueremLanche = totalPassageirosQueremLanche + viagem.calculaQuantidadeLanche();
                totalPassageiros = totalPassageiros + viagem.calcularQuantidadeDePassageiros();

            }
        }
        if (totalPassageiros != 0) {
            porcentagem = totalPassageirosQueremLanche / totalPassageiros;
        }

        return porcentagem;
    }

    /**
     * Este método calcula a porcentagem da quantidade de passageiros em todas
     * as viagens em um intervalo de datas para determinar a lotação das viagens
     * nesse intervalo.
     *
     * @param dataInicio Data inicial do intervalo.
     * @param dataFim Data Final do intervalo
     * @return Retorna a porcentagem de passageiros nesse intervalo
     */
    @Override
    public double calculaPorcentagemPassageirosPorDatas(String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalCapacidadeOnibus = 0.0;
        double totalQuantidadePassageiros = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());
            if (estaNoIntervalo) {
                //Tem que verificar o intervalo das datas
                totalCapacidadeOnibus = totalCapacidadeOnibus + viagem.getOnibus().getTotalPoltronas();
                totalQuantidadePassageiros = totalQuantidadePassageiros + viagem.calcularQuantidadeDePassageiros();

            }
        }
        if (totalCapacidadeOnibus != 0) {
            porcentagem = totalQuantidadePassageiros / totalCapacidadeOnibus;
        }

        return porcentagem;
    }

    /**
     * Este método calcula a porcentagem de passageiros em um intervalo de datas
     * nas viagens de determinado horario e destino.
     *
     * @param horario Horario da Viagem.
     * @param origem Cidade onde a viagem inicia.
     * @param destino Destino da Viagem.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna a porcentagem de passageiros por viagem nas viagens de
     * certo horário e destino.
     */
    @Override
    public double calculaPorcentagemPassageirosPorDatasEViagens(String horario, String origem, String destino, String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalCapacidadeOnibus = 0.0;
        double totalQuantidadePassageiros = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());
            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getOrigem().equals(origem) && viagem.getHorarioSaida().equals(horario)) {
                //Tem que verificar o intervalo das datas, o horario e o destino
                totalCapacidadeOnibus = totalCapacidadeOnibus + viagem.getOnibus().getTotalPoltronas();
                totalQuantidadePassageiros = totalQuantidadePassageiros + viagem.calcularQuantidadeDePassageiros();
            }
        }

        if (totalCapacidadeOnibus != 0) {
            porcentagem = totalQuantidadePassageiros / totalCapacidadeOnibus;
        }

        return porcentagem;
    }

    /**
     * Este método calcula a porcentagem de passageiros nas viagens de certo
     * destino.
     *
     * @param destino Destino da viagem.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data de fim do intervalo.
     * @return Retorna a porcentagem.
     */
    @Override
    public double calculaPorcentagemPassageirosPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) {

        double porcentagem = 0.0;
        double totalCapacidadeOnibus = 0.0;
        double totalQuantidadePassageiros = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());
            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getOrigem().equals(origem)) {
                //Tem que verificar o intervalo das datas, o horario e o destino
                totalCapacidadeOnibus = totalCapacidadeOnibus + viagem.getOnibus().getTotalPoltronas();
                totalQuantidadePassageiros = totalQuantidadePassageiros + viagem.calcularQuantidadeDePassageiros();
            }
        }
        if (totalCapacidadeOnibus != 0) {
            porcentagem = totalQuantidadePassageiros / totalCapacidadeOnibus;
        }
        
        return porcentagem;
    }

    /**
     * Este método calcula o lucro total obtido em todas as viagens em certo
     * intervalo de datas.
     *
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna o lucro total obtido.
     */
    @Override
    public double calcularLucroTotalPorDatas(String dataInicio, String dataFim) {
        double lucroTotal = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());
            if (estaNoIntervalo) { //Tem que verificar o intervalo dado
                lucroTotal = lucroTotal + viagem.calculaLucro();
            }
        }
        return lucroTotal;
    }

    /**
     * Este método calcula o lucro total nas viagens de certos horários e
     * destinos em certo intervalo de datas.
     *
     * @param horarioSaida Horário de saída da viagem.
     * @param origem Cidade onde a viagem inicia.
     * @param destino Destino da Viagem.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna o lucro obtido.
     */
    @Override
    public double calcularLucroTotalPorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) {
        double lucroTotal = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());

            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getOrigem().equals(origem) && viagem.getHorarioSaida().equals(horarioSaida)) { //Tem que verificar o intervalo dado e se é essa viagem nesse horario e destino
                lucroTotal = lucroTotal + viagem.calculaLucro();
            }
        }
        return lucroTotal;
    }

    /**
     * Este método calcula o lucro total das viagens de certo destino em um
     * intervalo de datas.
     *
     * @param origem Cidade onde a viagem inicia.
     * @param destino Destino da viagem.
     * @param dataInicio Data de início do intervalo.
     * @param dataFim Data final do intervalo.
     * @return Retorna o lucro total obtido.
     */
    @Override
    public double calcularLucroTotalPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) {
        double lucroTotal = 0.0;

        for (Viagem viagem : viagens) {
            boolean estaNoIntervalo = Data.verificarDataEstaNoIntervalo(dataInicio, dataFim, viagem.getDataSaida());

            if (estaNoIntervalo && viagem.getDestino().equals(destino) && viagem.getOrigem().equals(origem)) { //Tem que verificar o intervalo dado e se é essa viagem nesse horario e destino
                lucroTotal = lucroTotal + viagem.calculaLucro();
            }
        }
        return lucroTotal;
    }

    @Override
    public String procurarUltimasViagensDeUmPassagiro(Passageiro passageiro) {
        String ultimosDestinos = "CPF: " + passageiro.getCpf() + "\nNome: " + passageiro.getNomeCompleto() + "\n"; //Adicionar o nome também

        for (Viagem viagem : viagens) {
            for (Passageiro p : viagem.listagemPassageirosNaViagem()) {
                if (p.getCpf().equals(passageiro.getCpf())) {
                    ultimosDestinos = ultimosDestinos + "\nOrigem: " + viagem.getOrigem() + "\nDestino: " + viagem.getDestino() + "\nData de saída: " + viagem.getDataSaida() + "\nHorario Saída: " + viagem.getHorarioSaida() + "\nData de chegada: " + viagem.getDataChegada() + "\nHora de chegada: " + viagem.getHorarioChegada() + "\n";
                }
            }
        }
        return ultimosDestinos;
    }

    @Override
    public void adicionarViagem(Viagem v) {
        viagens.add(v);

    }

    @Override
    public void removerViagem(Viagem viagem) {
        viagens.remove(viagem);

    }

    @Override
    public void alterarViagem(Viagem viagem) {
        int index = viagens.indexOf(viagem);
        viagens.set(index, viagem);
    }

    @Override
    public Viagem procurarViagem(int codigo) {
        for (Viagem viagem : viagens) {
            if (viagem.getCodigo() == codigo) {
                return viagem;
            }
        }
        return null; //Não achou a viagem
    }

    @Override
    public Viagem procurarViagem(String dataSaida, String horaSaida, String origem, String destino) {
        for (Viagem viagem : viagens) {
            if (viagem.getDataSaida().equals(dataSaida) && viagem.getHorarioSaida().equals(horaSaida) && viagem.getOrigem().equals(origem) && viagem.getDestino().equals(destino)) {
                return viagem;
            }
        }
        return null; //Se não achou a viagem
    }

    @Override
    public List<Viagem> listagemViagens() {
        List<Viagem> viagensCopia = new ArrayList<>();
        for (Viagem v : viagens) {
            viagensCopia.add(v);
        }

        return viagensCopia;
    }

}
