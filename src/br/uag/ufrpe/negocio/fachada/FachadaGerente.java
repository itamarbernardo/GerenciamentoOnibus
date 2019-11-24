/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio.fachada;

import br.uag.ufrpe.negocio.NegocioFuncionario;
import br.uag.ufrpe.negocio.NegocioOnibus;
import br.uag.ufrpe.negocio.NegocioPassageiro;
import br.uag.ufrpe.negocio.NegocioPassagem;
import br.uag.ufrpe.negocio.NegocioViagem;
import br.uag.ufrpe.negocio.entidades.Funcionario;
import br.uag.ufrpe.negocio.entidades.Onibus;
import br.uag.ufrpe.negocio.entidades.Passageiro;
import br.uag.ufrpe.negocio.entidades.Passagem;
import br.uag.ufrpe.negocio.entidades.Viagem;
import br.uag.ufrpe.negocio.excecoes.viagem.IndisponibilidadeDeAssentoException;
import br.uag.ufrpe.negocio.excecoes.viagem.IndisponibilidadeTipoDePassagemException;
import br.uag.ufrpe.negocio.excecoes.datas.IntervaloDeDatasInvalidoException;
import br.uag.ufrpe.negocio.excecoes.funcionario.FuncionarioJaExisteException;
import br.uag.ufrpe.negocio.excecoes.funcionario.FuncionarioNaoEncontradoException;
import br.uag.ufrpe.negocio.excecoes.motorista.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusCheioException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusJaExisteException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.passageiro.PassageiroJaEstaNaViagemException;
import br.uag.ufrpe.negocio.excecoes.passageiro.PassageiroNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.passagem.PassagemNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.passagem.PassagemNaoPertenceAViagemException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemJaExisteException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemNaoExisteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itamar Jr
 */
public class FachadaGerente extends FachadaFuncionario {

    private static FachadaGerente fachadaGerente;
    private NegocioFuncionario negocioFuncionario;

    private FachadaGerente() {
        super();
        this.negocioFuncionario = new NegocioFuncionario();
    }

    public static FachadaGerente getFachadaGerente() {
        if (fachadaGerente == null) {
            fachadaGerente = new FachadaGerente();
        }
        return fachadaGerente;
    }

    public void adicionarViagem(String placa, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada) throws ViagemJaExisteException, MotoristaNaoDisponivelException, OnibusNaoDisponivelException, OnibusNaoExisteException {

        Onibus onibus = negocioOnibus.procurarOnibus(placa);
        if (onibus == null) {
            throw new OnibusNaoExisteException();
        }
        Viagem viagem = new Viagem(onibus, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);

        negocioViagem.adicionar(viagem);
    }

    public void removerViagem(int codigo) throws ViagemNaoExisteException {
        negocioViagem.remover(codigo);
    }

    public void alterarViagem(int codigo, String placa, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada) throws OnibusNaoExisteException, ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        Onibus onibus = negocioOnibus.procurarOnibus(placa);
        if (onibus == null) {
            throw new OnibusNaoExisteException();
        }
        viagem.setOnibus(onibus);
        viagem.setOrigem(origem);
        viagem.setDestino(destino);
        viagem.setHorarioSaida(horarioSaida);
        viagem.setHorarioChegada(horarioChegada);
        viagem.setDataSaida(dataSaida);
        viagem.setDataChegada(dataChegada);
    }

    public void aplicarDescontoEmTodasAsPassagens(int codigo, double desconto) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        viagem.aplicarDescontoEmTodasAsPassagens(desconto);
    }

    public double calculaPorcentagemLanchePorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemLanchePorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);
    }

    public double calculaPorcentagemLanchePorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemLanchePorDatasEDestino(origem, destino, dataInicio, dataFim);
    }

    public double calculaPorcentagemLanchePorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemLanchePorDatas(dataInicio, dataFim);
    }

    public double calculaPorcentagemPassageirosPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemPassageirosPorDatas(dataInicio, dataFim);
    }

    public double calculaPorcentagemPassageirosPorDatasEViagens(String horario, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemPassageirosPorDatasEViagens(horario, origem, destino, dataInicio, dataFim);
    }

    public double calculaPorcentagemPassageirosPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calculaPorcentagemPassageirosPorDatasEDestino(origem, destino, dataInicio, dataFim);
    }

    public double calcularLucroTotalPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calcularLucroTotalPorDatas(dataInicio, dataFim);
    }

    public double calcularLucroTotalPorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calcularLucroTotalPorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);
    }

    public double calcularLucroTotalPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return negocioViagem.calcularLucroTotalPorDatasEDestino(origem, destino, dataInicio, dataFim);
    }

    public void adicionarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        if (funcionario == null) {
            negocioFuncionario.adicionarFuncionario(funcionario);
        } else {
            throw new FuncionarioJaExisteException();
        }

    }

    public void alterarFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
        //funcionario = negocioFuncionario.procurarFuncionario(funcionario.getCpf());

        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException();
        } else {
            negocioFuncionario.alterarFuncionario(funcionario);
        }
    }

    public Funcionario procurarFuncionario(Funcionario funcionario) {
        return negocioFuncionario.procurarFuncionario(funcionario.getCpf());
    }

    public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException();
        } else {
            negocioFuncionario.removerFuncionario(funcionario);
        }

    }

}
