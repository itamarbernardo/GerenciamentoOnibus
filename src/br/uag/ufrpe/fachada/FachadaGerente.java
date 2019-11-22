/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.fachada;

import br.uag.ufrpe.negocio.NegocioOnibus;
import br.uag.ufrpe.negocio.NegocioPassageiro;
import br.uag.ufrpe.negocio.NegocioPassagem;
import br.uag.ufrpe.negocio.NegocioViagem;
import br.uag.ufrpe.negocio.Onibus;
import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Passagem;
import br.uag.ufrpe.negocio.Viagem;
import br.uag.ufrpe.negocio.excecoes.IndisponibilidadeDeAssentoException;
import br.uag.ufrpe.negocio.excecoes.IndisponibilidadeTipoDePassagemException;
import br.uag.ufrpe.negocio.excecoes.IntervaloDeDatasInvalidoException;
import br.uag.ufrpe.negocio.excecoes.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.OnibusCheioException;
import br.uag.ufrpe.negocio.excecoes.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassageiroJaEstaNaViagemException;
import br.uag.ufrpe.negocio.excecoes.PassageiroNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoPertenceAViagemException;
import br.uag.ufrpe.negocio.excecoes.ViagemJaExisteException;
import br.uag.ufrpe.negocio.excecoes.ViagemNaoExisteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itamar Jr
 */
public class FachadaGerente extends FachadaFuncionario{

    
    public FachadaGerente(NegocioViagem negocioViagem, NegocioOnibus negocioOnibus, NegocioPassagem negocioPassagem, NegocioPassageiro negocioPassageiro) {
        super(negocioViagem, negocioOnibus, negocioPassagem, negocioPassageiro);

    }

    public void adicionarViagem(String placa, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada) throws ViagemJaExisteException, MotoristaNaoDisponivelException, OnibusNaoDisponivelException, OnibusNaoExisteException {
        
        Onibus onibus = getNegocioOnibus().procurarOnibus(placa);
        if(onibus == null){
            throw new OnibusNaoExisteException();
        }
        Viagem viagem = new Viagem(onibus, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);

        getNegocioViagem().adicionar(viagem);
        
    }

    public void removerViagem(int codigo) throws ViagemNaoExisteException {
        getNegocioViagem().remover(codigo);

    }

    
    public void alterarViagem(int codigo, String placa, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada) throws OnibusNaoExisteException, ViagemNaoExisteException{
        Viagem viagem = getNegocioViagem().procurar(codigo);
        if(viagem == null){
            throw new ViagemNaoExisteException();
        }
        Onibus onibus = getNegocioOnibus().procurarOnibus(placa);
        if(onibus == null){
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
    
    public void aplicarDescontoEmTodasAsPassagens(int codigo, double desconto) throws ViagemNaoExisteException{
        Viagem viagem = getNegocioViagem().procurar(codigo);
        if(viagem == null){
            throw new ViagemNaoExisteException();
        }
        viagem.aplicarDescontoEmTodasAsPassagens(desconto);
    }
    
    public double calculaPorcentagemLanchePorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException{
        return getNegocioViagem().calculaPorcentagemLanchePorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);
    }
    
    public double calculaPorcentagemLanchePorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calculaPorcentagemLanchePorDatasEDestino(origem, destino, dataInicio, dataFim);
    }
    
    public double calculaPorcentagemLanchePorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException  {
        return getNegocioViagem().calculaPorcentagemLanchePorDatas(dataInicio, dataFim);
    }
    
    public double calculaPorcentagemPassageirosPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calculaPorcentagemPassageirosPorDatas(dataInicio, dataFim);
    }
    
    public double calculaPorcentagemPassageirosPorDatasEViagens(String horario, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calculaPorcentagemPassageirosPorDatasEViagens(horario, origem, destino, dataInicio, dataFim);
    }
    
    public double calculaPorcentagemPassageirosPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calculaPorcentagemPassageirosPorDatasEDestino(origem, destino, dataInicio, dataFim);
    }
    
    public double calcularLucroTotalPorDatas(String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calcularLucroTotalPorDatas(dataInicio, dataFim);
    }
    
    public double calcularLucroTotalPorDatasEViagens(String horarioSaida, String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calcularLucroTotalPorDatasEViagens(horarioSaida, origem, destino, dataInicio, dataFim);
    }
    
    public double calcularLucroTotalPorDatasEDestino(String origem, String destino, String dataInicio, String dataFim) throws IntervaloDeDatasInvalidoException {
        return getNegocioViagem().calcularLucroTotalPorDatasEDestino(origem, destino, dataInicio, dataFim);
    }
    
    
    
}
