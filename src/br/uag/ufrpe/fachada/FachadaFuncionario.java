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
import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Passagem;
import br.uag.ufrpe.negocio.Viagem;
import br.uag.ufrpe.negocio.excecoes.DisponibilidadeDeAssentoException;
import br.uag.ufrpe.negocio.excecoes.DisponibilidadeTipoDePassagemException;
import br.uag.ufrpe.negocio.excecoes.OnibusCheioException;
import br.uag.ufrpe.negocio.excecoes.PassageiroJaEstaNaViagemException;
import br.uag.ufrpe.negocio.excecoes.PassageiroNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoPertenceAViagemException;
import br.uag.ufrpe.negocio.excecoes.ViagemNaoExisteException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Itamar Jr
 */
public class FachadaFuncionario {

    private NegocioViagem negocioViagem;
    private NegocioOnibus negocioOnibus;
    private NegocioPassagem negocioPassagem;
    private NegocioPassageiro negocioPassageiro;

    public FachadaFuncionario(NegocioViagem negocioViagem, NegocioOnibus negocioOnibus, NegocioPassagem negocioPassagem, NegocioPassageiro negocioPassageiro) {
        this.negocioViagem = negocioViagem;
        this.negocioOnibus = negocioOnibus;
        this.negocioPassagem = negocioPassagem;
        this.negocioPassageiro = negocioPassageiro;
    }

    public Viagem procurarViagem(int codigo) {
        return negocioViagem.procurar(codigo);

    }

    public Viagem procurarViagem(String dataSaida, String horaSaida, String origem, String destino) {
        return negocioViagem.procurar(dataSaida, horaSaida, origem, destino);

    }

    public void venderPassagem(int codigoViagem, int codigoPassagem) throws ViagemNaoExisteException, DisponibilidadeDeAssentoException, DisponibilidadeTipoDePassagemException, PassageiroJaEstaNaViagemException, OnibusCheioException, PassagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigoViagem);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        Passagem passagem = negocioPassagem.procurarPassagem(codigoPassagem);
        if (passagem == null) {
            throw new PassagemNaoExisteException();
        }
        viagem.venderPassagem(passagem);
    }

    public void cancelarPassagem(int codigoViagem, String cpf) throws ViagemNaoExisteException, PassageiroNaoExisteException, PassagemNaoPertenceAViagemException {
        Viagem viagem = negocioViagem.procurar(codigoViagem);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        Passageiro passageiro = negocioPassageiro.procurarPassageiro(cpf);
        if (passageiro == null) {
            throw new PassageiroNaoExisteException();
        }
        viagem.cancelarPassagem(viagem.procurarPassagem(passageiro));
    }

    public List<Viagem> listagemViagens() {
        return negocioViagem.listagemViagens();
    }

    public int calculaPoltronasVaziasNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.calculaPoltronasVazias();
    }

    public int calculaQuantidadeLancheNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.calculaQuantidadeLanche();
    }

    public double calcularPorcentagemLancheNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.calcularPorcentagemLanche();
    }

    public int calcularQuantidadeDePassageirosNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.calcularQuantidadeDePassageiros();
    }

    public double calcularPorcentagemPassageirosNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.calcularPorcentagemPassageiros();
    }

    public int getQuantidadeIdJovem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.getQuantidadeIdJovem();
    }

    public int getQuantidadeIdJovemParcial(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.getQuantidadeIdJovemParcial();
    }

    public int getQuantidadeIdoso(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.getQuantidadeIdoso();
    }

    public int getQuantidadeIdosoParcial(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.getQuantidadeIdosoParcial();
    }

    public boolean passageiroEstaNaViagem(int codigo, String cpf) throws ViagemNaoExisteException, PassageiroNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        Passageiro passageiro = negocioPassageiro.procurarPassageiro(cpf);
        if (passageiro == null) {
            throw new PassageiroNaoExisteException();
        }

        return viagem.estaNaViagem(passageiro);
    }

    public String procurarUltimasViagensDeUmPassageiro(int codigo, String cpf) throws ViagemNaoExisteException, PassageiroNaoExisteException {
        Passageiro passageiro = negocioPassageiro.procurarPassageiro(cpf);
        if (passageiro == null) {
            throw new PassageiroNaoExisteException();
        }
        return negocioViagem.procurarUltimasViagensDeUmPassageiro(passageiro);
    }

    public List<Passagem> listaPassagensNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.listagemPassagens();
    }

    public List<Passageiro> listaPassageirosNaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.listagemPassageirosNaViagem();
    }

    public Map<Integer, String> listaPoltronasDaViagem(int codigo) throws ViagemNaoExisteException {
        Viagem viagem = negocioViagem.procurar(codigo);
        if (viagem == null) {
            throw new ViagemNaoExisteException();
        }
        return viagem.listaPoltronas();
    }

    public NegocioViagem getNegocioViagem() {
        return negocioViagem;
    }

    public void setNegocioViagem(NegocioViagem negocioViagem) {
        this.negocioViagem = negocioViagem;
    }

    public NegocioOnibus getNegocioOnibus() {
        return negocioOnibus;
    }

    public void setNegocioOnibus(NegocioOnibus negocioOnibus) {
        this.negocioOnibus = negocioOnibus;
    }

    public NegocioPassagem getNegocioPassagem() {
        return negocioPassagem;
    }

    public void setNegocioPassagem(NegocioPassagem negocioPassagem) {
        this.negocioPassagem = negocioPassagem;
    }

    public NegocioPassageiro getNegocioPassageiro() {
        return negocioPassageiro;
    }

    public void setNegocioPassageiro(NegocioPassageiro negocioPassageiro) {
        this.negocioPassageiro = negocioPassageiro;
    }

}
