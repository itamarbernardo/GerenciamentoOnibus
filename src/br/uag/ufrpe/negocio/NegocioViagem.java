/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.entidades.Data;
import br.uag.ufrpe.negocio.entidades.Passageiro;
import br.uag.ufrpe.negocio.entidades.Viagem;
import br.uag.ufrpe.dados.IRepositorioViagem;
import br.uag.ufrpe.dados.RepositorioViagem;
import br.uag.ufrpe.negocio.excecoes.datas.IntervaloDeDatasInvalidoException;
import br.uag.ufrpe.negocio.excecoes.motorista.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemJaExisteException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemNaoExisteException;
import java.util.List;

/**
 *
 * @author Itamar Jr
 */
public class NegocioViagem {

    private IRepositorioViagem repositorio;

    public NegocioViagem() {
        this.repositorio = new RepositorioViagem();
    }

    public void adicionar(Viagem v) throws ViagemJaExisteException, MotoristaNaoDisponivelException, OnibusNaoDisponivelException {
        Viagem viagem = repositorio.procurarViagem(v.getCodigo());
        String cpfMotorista = v.getOnibus().getMotorista().getCpf();
        if (viagem == null) { //Esta viagem não existe no repositorio. Vou checar os horarios dos motoristas e dos onibus
            String dataSaidaViagem = v.getDataSaida() + " " + v.getHorarioSaida();
            String dataChegadaViagem = v.getDataChegada() + " " + v.getHorarioChegada();

            for (Viagem via : repositorio.listagemViagens()) {
                String cpf = via.getOnibus().getMotorista().getCpf();
                String dataHoraSaida = via.getDataSaida() + " " + via.getHorarioSaida();
                String dataHoraChegada = via.getDataChegada() + " " + via.getHorarioChegada();
                boolean bateHorario = Data.verificarInterseccaoDatasHoras(dataHoraSaida, dataHoraChegada, dataSaidaViagem, dataChegadaViagem);
                if ((bateHorario && v.getOnibus().getPlaca().equals(via.getOnibus().getPlaca()))) {

                    if (cpf.equals(cpfMotorista)) { //Usar a sobrescrita do metodo equals para Motorista
                        //Achei uma outra viagem do motorista
                        throw new MotoristaNaoDisponivelException();
                    } else {
                        throw new OnibusNaoDisponivelException();

                    }
                }

            }
            repositorio.adicionarViagem(v); //Não disparou nenhuma exception, então tá ok, pode adicionar.
        } else {
            throw new ViagemJaExisteException();
        }

    }

    public Viagem procurar(int codigo) {
        return repositorio.procurarViagem(codigo);
    }

    public Viagem procurar(String dataSaida, String horaSaida, String origem, String destino) {
        return repositorio.procurarViagem(dataSaida, horaSaida, origem, destino);
    }

    public void remover(Viagem v) throws ViagemNaoExisteException {
        Viagem viagem = repositorio.procurarViagem(v.getCodigo());
        if (viagem != null) {
            repositorio.removerViagem(viagem);
        } else {
            throw new ViagemNaoExisteException();
        }

    }

    public void remover(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = repositorio.procurarViagem(codigo);
        if (viagem != null) {
            repositorio.removerViagem(viagem);
        } else {
            throw new ViagemNaoExisteException();
        }

    }

    public void alterar(Viagem v) throws ViagemNaoExisteException {
        int index = repositorio.listagemViagens().indexOf(v);
        if (index == -1) {
            throw new ViagemNaoExisteException();
        } else {
            repositorio.alterarViagem(v);
        }
    }

    public List<Viagem> listagemViagens() {
        return repositorio.listagemViagens();
    }

    public String procurarUltimasViagensDeUmPassageiro(Passageiro passageiro) {
        return repositorio.procurarUltimasViagensDeUmPassagiro(passageiro);
    }

    public double calculaPorcentagemLanchePorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemLanchePorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);

        } else {
            throw new IntervaloDeDatasInvalidoException();
        }

    }

    public double calculaPorcentagemLanchePorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemLanchePorDatasEDestino(origem, destino, dataInicio, dataFim);

        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calculaPorcentagemLanchePorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemLanchePorDatas(dataInicio, dataFim);
        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calculaPorcentagemPassageirosPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemPassageirosPorDatas(dataInicio, dataFim);

        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calculaPorcentagemPassageirosPorDatasEViagens(String horario, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemPassageirosPorDatasEViagens(horario, origem, destino, dataInicio, dataFim);

        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calculaPorcentagemPassageirosPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calculaPorcentagemPassageirosPorDatasEDestino(origem, destino, dataInicio, dataFim);
        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calcularLucroTotalPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calcularLucroTotalPorDatas(dataInicio, dataFim);
        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calcularLucroTotalPorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calcularLucroTotalPorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);
        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }

    public double calcularLucroTotalPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        if (Data.verificaDataInicioDataFimValida(dataInicio, dataFim)) {
            return repositorio.calcularLucroTotalPorDatasEDestino(origem, destino, dataInicio, dataFim);
        } else {
            throw new IntervaloDeDatasInvalidoException();
        }
    }
    
    
    
    
}
