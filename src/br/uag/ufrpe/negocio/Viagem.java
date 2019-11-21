/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.PassageiroJaEstaNaViagemException;
import br.uag.ufrpe.negocio.excecoes.OnibusCheioException;
import br.uag.ufrpe.negocio.excecoes.DisponibilidadeTipoDePassagemException;
import br.uag.ufrpe.negocio.excecoes.DisponibilidadeDeAssentoException;
import br.uag.ufrpe.negocio.excecoes.PassagemNaoPertenceAViagemException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa uma representa uma Viagem e gera algumas informações
 * como o lucro total da viagem, a quantidade de passageiros que querem lanche.
 * É a classe que une as entidades principais do domínio do projeto.
 *
 * @author Itamar Jr
 */
public class Viagem {

    private static int totalViagens;
    private String dataSaida;
    private String dataChegada;
    private final int codigo;
    private final List<Passagem> passagens;
    private Onibus onibus;
    private String origem;
    private String destino;
    private String horarioSaida;
    private String horarioChegada;

    private int quantidadeIdJovem;
    private int quantidadeIdJovemParcial;
    private int quantidadeIdoso;
    private int quantidadeIdosoParcial;

    private final Map<Integer, String> poltronas;

    public Viagem(Onibus onibus, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada) {

        this.passagens = new ArrayList<>();
        this.onibus = onibus;
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.horarioChegada = horarioChegada;
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
        this.codigo = totalViagens; //O codigo vai ser o numero de viagens
        totalViagens++;

        this.poltronas = new HashMap<>();
        copiarValoresPoltronas();
        
        this.quantidadeIdJovem = 0;
        this.quantidadeIdoso = 0;
        this.quantidadeIdJovemParcial = 0;
        this.quantidadeIdosoParcial = 0;
    }

    private void copiarValoresPoltronas() {
        for (int i = 1; i <= onibus.getPoltronas().size(); i++) {
            poltronas.put(i, onibus.getPoltronas().get(i));
        }
    }

    public void aplicarDescontoEmTodasAsPassagens(double desconto) {
        int tamanho = passagens.size();
        for (int i = 0; i < tamanho; i++) {
            double preco = passagens.get(i).getPreco();
            double novoPreco = preco - (preco * desconto);
            passagens.get(i).setPreco(novoPreco);
        }
    }

    public int calcularQuantidadeDePassageiros() {
        return passagens.size();
    }

    public double calcularPorcentagemPassageiros() {
        double porcentagem = 0;

        if(onibus.getTotalPoltronas() != 0){
            porcentagem = passagens.size() / onibus.getTotalPoltronas();
        }
        return porcentagem;
    }

    public double calcularPorcentagemLanche() {
        double porcentagem = 0; 
        
        if(passagens.size() != 0){
            porcentagem = calculaQuantidadeLanche() / passagens.size();        
        }

        return porcentagem;
    }

    public List<Passageiro> listagemPassageirosNaViagem() {
        List<Passageiro> passageiros = new ArrayList<>();
        for (Passagem p : passagens) {
            passageiros.add(p.getPassageiro());
        }
        return passageiros;
    }

    public int calculaQuantidadeLanche() {
        int quantidade = 0;
        for (Passagem p : passagens) {
            if (p.isLanche()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public double calculaLucro() {
        double lucroTotal = 0.0;
        for (Passagem p : passagens) {
            lucroTotal = lucroTotal + p.getPrecoTotal();
        }
        return lucroTotal;
    }

    /**
     * Método que verifica se essa viagem possui assentos "especiais" que o
     * cliente pode escolher e se ainda estão vagos.
     *
     * @param p o objeto do tipo Passagem que conterá o tipo de assento.
     * @return Retorna uma mensagem de erro se houver algum problema com relação
     * a disponibilidade do assento. Se ocorrer tudo bem, retorna uma string
     * vazia.
     */
    public String verificarDisponibilidadeAssento(Passagem p) {
        //Aqui eu tenho que fazer as verificações se a pessoa quis assentos reclináveis e se tem disponível ainda esses assentos

        String mensagemErro = "";

        if ((poltronas.get(p.getCodigoPoltrona())).equals(p.getTipoDeAssento())) {
            poltronas.put(p.getCodigoPoltrona(), "Ocupado");

        } else if (poltronas.get(p.getCodigoPoltrona()).equals("Ocupado")) {
            mensagemErro = "A poltrona já está ocupada.";
        } else {
            mensagemErro = "O tipo de Assento não está disponível nesta poltrona.";
        }

        return mensagemErro;
    }
    /**
     * Este método verifica a quantidade de poltronas vazias na Viagem.
     *
     * @return retorna a quantidade de poltronas vazias
     */
    public int calculaPoltronasVazias() {
        int quantidadePoltronasVazias = 0;

        for (int i = 1; i <= poltronas.size(); i++) {
            if (!(poltronas.get(i).equals("Ocupado"))) {
                quantidadePoltronasVazias++;
            }
        }
        return quantidadePoltronasVazias;
    }

    /**
     * Este método verifica se ainda há vagas parciais ou totais para idosos e
     * estudantes que possuirem ID Jovem.
     *
     * @param p o objeto do tipo Passagem que conterá o tipo de passagem
     * escolhido.
     * @return Retorna uma string com a mensagem de erro. Se ocorrer tudo bem,
     * retorna uma string vazia.
     */
    public String verificarDisponibilidadeTipoDePassagem(Passagem p) {
        String mensagemErro = "";
        if (p.getTipoDePassagem().equals("IdJovem") && quantidadeIdJovem < 2) {
            quantidadeIdJovem++;
        } else if (p.getTipoDePassagem().equals("IdJovem") && quantidadeIdJovem == 2) {
            mensagemErro = mensagemErro + "Não há mais vagas de GRATUIDADE com ID Jovem ";
        } else if (p.getTipoDePassagem().equals("ParcialIdJovem") && quantidadeIdJovemParcial < 2) {
            quantidadeIdJovemParcial++;
        } else if (p.getTipoDePassagem().equals("ParcialIdJovem") && quantidadeIdJovemParcial == 2) {
            mensagemErro = mensagemErro + "Não há mais vagas de GRATUIDADE PARCIAL com ID Jovem ";
        } else if (p.getTipoDePassagem().equals("Idoso") && quantidadeIdoso < 2) {
            quantidadeIdoso++;

        } else if (p.getTipoDePassagem().equals("Idoso") && quantidadeIdoso == 2) {
            mensagemErro = mensagemErro + "Não há mais vagas de GRATUIDADE para Idoso";

        } else if (p.getTipoDePassagem().equals("ParcialIdoso") && quantidadeIdosoParcial < 2) {
            quantidadeIdosoParcial++;
        } else if (p.getTipoDePassagem().equals("ParcialIdoso") && quantidadeIdosoParcial == 2) {
            mensagemErro = mensagemErro + "Não há mais vagas de GRATUIDADE PARCIAL para Idoso";
        }

        return mensagemErro;
    }

    /**
     * Este método verifica se um passageiro está na viagem.
     * @param p Passageiro que se deseja rerificar.
     * @return Retorna true se ele estiver e false se não estiver.
     */
    public boolean estaNaViagem(Passageiro p) {

        for (Passageiro passageiro : listagemPassageirosNaViagem()) {
            if (p.equals(passageiro)) {
                return true; //Esse passageiro já está na viagem
            }
        }
        return false; //O passageiro nao esta nessa viagem
    }

    /**
     * Este método vende uma passagem após checar se há disponibilidade de
     * assentos e do tipo de passagem escolhido.
     *
     * @param p o objeto do tipo Passagem que será adicionado na lista de
     * passagens.
     */
    public void venderPassagem(Passagem p) throws DisponibilidadeDeAssentoException, DisponibilidadeTipoDePassagemException, PassageiroJaEstaNaViagemException, OnibusCheioException {
        /*Retorna uma String com uma mensagem pois ele tem que saber 
         qual foi o erro dado. Com o exception, pode retornar a exception */
        String mensagemErro = ""; //Se ocorrer tudo bem, retorna uma string vazia
        if (estaNaViagem(p.getPassageiro()) == false) {

            if (calculaPoltronasVazias() != 0) {

                /*Verifico a disponibilidade do assento que o cliente quer 
                 e verifico se há vagas para ID Jovem e Idoso
                 Se mensagemErro.length() for maior que zero é porque algo está errado.
                 */
                mensagemErro = verificarDisponibilidadeAssento(p) + verificarDisponibilidadeTipoDePassagem(p);
                if (mensagemErro.length() == 0) {
                    passagens.add(p);
                }
                else if(verificarDisponibilidadeAssento(p).length() != 0){
                    throw new DisponibilidadeDeAssentoException(verificarDisponibilidadeAssento(p));
                }
                else if(verificarDisponibilidadeTipoDePassagem(p).length() != 0){
                    throw new DisponibilidadeTipoDePassagemException(verificarDisponibilidadeTipoDePassagem(p));
                }
                

            } else {
                throw new OnibusCheioException(); 
            }
        } else {
            throw new PassageiroJaEstaNaViagemException();
        }

    }

    public void cancelarPassagem(Passagem p) throws PassagemNaoPertenceAViagemException {
        int index = passagens.indexOf(p);
        
        if(index != -1){
           passagens.remove(p);
        }else{
            throw new PassagemNaoPertenceAViagemException();
        }

    }
    
    /**
     * Este método procura uma passagem na viagem por um passageiro, 
     * já que um mesmo passageiro não pode tirar duas passagens.
     * @param passageiro Passageiro que pode ou não ter uma passagem nessa viagem.
     * @return Retorna a passagem que o passageiro possui na viagem ou null se ele não possuir passagem.
     */
    public Passagem procurarPassagem(Passageiro passageiro){
        boolean verifica = estaNaViagem(passageiro);
        if(verifica){
            for(Passagem passagem : passagens){
                if(passagem.getPassageiro().equals(passageiro)){
                    return passagem;
                }
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Viagem) {
            Viagem viagem = (Viagem) obj;
            if (codigo == viagem.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public List<Passagem> listagemPassagens() {
        List<Passagem> passagensCopia = new ArrayList<>();
        for(Passagem p : passagens){
            passagensCopia.add(p);
        }
        
        return passagensCopia;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(String horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public static int getTotalViagens() {
        return totalViagens;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidadeIdJovem() {
        return quantidadeIdJovem;
    }

    public int getQuantidadeIdJovemParcial() {
        return quantidadeIdJovemParcial;
    }

    public int getQuantidadeIdoso() {
        return quantidadeIdoso;
    }

    public int getQuantidadeIdosoParcial() {
        return quantidadeIdosoParcial;
    }

    public Map<Integer, String> listaPoltronas() {
        Map<Integer, String> poltronasCopia = new HashMap<>();
        
        for (int i = 1; i <= poltronas.size(); i++) {
            poltronasCopia.put(i, poltronas.get(i));
        }
        return poltronas;
    }

    @Override
    public String toString() {
        return "Viagem{" + "dataSaida=" + dataSaida + ", dataChegada=" + dataChegada + ", codigo=" + codigo + ", passagens=" + passagens + ", onibus=" + onibus + ", origem=" + origem + ", destino=" + destino + ", horarioSaida=" + horarioSaida + ", horarioChegada=" + horarioChegada + '}';
    }

}
