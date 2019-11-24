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
import br.uag.ufrpe.negocio.entidades.Passageiro;
import br.uag.ufrpe.negocio.entidades.Passagem;
import br.uag.ufrpe.negocio.entidades.Viagem;
import br.uag.ufrpe.negocio.excecoes.viagem.IndisponibilidadeDeAssentoException;
import br.uag.ufrpe.negocio.excecoes.viagem.IndisponibilidadeTipoDePassagemException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusCheioException;
import br.uag.ufrpe.negocio.excecoes.passageiro.PassageiroJaEstaNaViagemException;
import br.uag.ufrpe.negocio.excecoes.passageiro.PassageiroJaExisteException;
import br.uag.ufrpe.negocio.excecoes.passageiro.PassageiroNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.passagem.PassagemNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.passagem.PassagemNaoPertenceAViagemException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemNaoExisteException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Itamar Jr
 */
public class FachadaFuncionario {

    private static FachadaFuncionario fachadaFuncionario;
    
    protected NegocioViagem negocioViagem;
    protected NegocioOnibus negocioOnibus;
    protected NegocioPassagem negocioPassagem;
    protected NegocioPassageiro negocioPassageiro;
    

    FachadaFuncionario() {
        this.negocioViagem = new NegocioViagem();
        this.negocioOnibus = new NegocioOnibus();
        this.negocioPassagem = new NegocioPassagem();
        this.negocioPassageiro = new NegocioPassageiro();
        
    }

    
    //Padrão de projeto Singleton - evita que tenham multiplas fachadas
    public static FachadaFuncionario getFachadaFuncionario(){
        if(fachadaFuncionario == null){
            fachadaFuncionario = new FachadaFuncionario();
        }
        return fachadaFuncionario;
    }
    
    
    public Viagem procurarViagem(int codigo) {
        return negocioViagem.procurar(codigo);

    }

    public Viagem procurarViagem(String dataSaida, String horaSaida, String origem, String destino) {
        return negocioViagem.procurar(dataSaida, horaSaida, origem, destino);

    }

    public void venderPassagem(int codigoViagem, int codigoPassagem) throws ViagemNaoExisteException, IndisponibilidadeDeAssentoException, IndisponibilidadeTipoDePassagemException, PassageiroJaEstaNaViagemException, OnibusCheioException, PassagemNaoExisteException {
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
    
    public void adicionarPassageiro(Passageiro passageiro) throws PassageiroJaExisteException, PassageiroNaoExisteException{
        if(passageiro == null){
            negocioPassageiro.adicionarPassageiro(passageiro);
        }
        else{
            throw new PassageiroJaExisteException();
        }
    }
    
    public void alterarPassageiro(Passageiro passageiro) throws PassageiroNaoExisteException{
        if(passageiro == null){
            throw new PassageiroNaoExisteException();
        }
        else{
            negocioPassageiro.alterarPassageiro(passageiro);
        }
    }
    
    public Passageiro procurarPassageiro(Passageiro passageiro){
        return negocioPassageiro.procurarPassageiro(passageiro.getCpf());
    }
    
    public void removerPassageiro(Passageiro passageiro) throws PassageiroNaoExisteException{
        if(passageiro == null){
            throw new PassageiroNaoExisteException();
        }
        else{
            negocioPassageiro.removerPassageiro(passageiro);
        }
    }



}
