/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import java.util.ArrayList;
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
    private int codigo;
    private List<Passagem> passagens;
    private Onibus onibus;
    private String origem;
    private String destino;
    private String horarioSaida;
    private String horarioChegada;
    private double desconto;

    private int quantidadeIdJovem;
    private int quantidadeIdJovemParcial;
    private int quantidadeIdoso;
    private int quantidadeIdosoParcial;

    //private int quantidadeAssentosReclinaveis;
    //private int quantidadeAssentosTotalmenteReclinaveis;
    //private int quantidadeAssentosObeso;
    private Map<Integer, String> poltronas;

    public Viagem(Onibus onibus, String origem, String destino, String horarioSaida, String horarioChegada, double desconto, String dataSaida, String dataChegada) {

        this.passagens = new ArrayList<>();
        this.onibus = onibus;
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.horarioChegada = horarioChegada;
        this.desconto = desconto;
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
        this.codigo = totalViagens; //O codigo vai ser o numero de viagens
        totalViagens++;

        this.poltronas = onibus.getPoltronas();

        this.quantidadeIdJovem = 0;
        this.quantidadeIdoso = 0;
        this.quantidadeIdJovemParcial = 0;
        this.quantidadeIdosoParcial = 0;
    }

    public void aplicarDescontoEmTodasAsPassagens() {
        int tamanho = passagens.size();
        for (int i = 0; i < tamanho; i++) {
            double preco = passagens.get(i).getPreco();
            double novoPreco = preco - (preco * desconto);
            passagens.get(i).setPreco(novoPreco);
        }
    }

    public int calcularQuantidadeDePassageirosNaViagem() {
        return passagens.size();
    }

    public double calcularPorcentagemPassageirosNaViagem() {
        double porcentagem = passagens.size() / onibus.getTotalPoltronas();

        return porcentagem;
    }

    public double calcularPorcentagemLancheNaViagem() {
        double porcentagem = calculaQuantidadeLanche() / passagens.size();

        return porcentagem;
    }

    public List<Passageiro> listagemPassageirosNaViagem() {
        List<Passageiro> passageiros = new ArrayList<>();
        for (Passagem p : passagens) {
            passageiros.add(p.getPassageiro());
        }
        return passageiros;
    }

    public void imprimeListaPassageirosNaViagem(List<Passageiro> passageiros) {
        for (Passageiro p : passageiros) {
            System.out.println(p.toString());
        }
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

    public double calculaLucroTotalDaViagem() {
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

        if (poltronas.get(p.getCodigo()).equals(p.getTipoDeAssento())) {
            poltronas.put(p.getCodigo(), "Ocupado");

        } else if (poltronas.get(p.getCodigo()).equals("Ocupado")) {
            mensagemErro = "Erro. A poltrona já está ocupada.";
        } else {
            mensagemErro = "Erro. O tipo de Assento não está disponível nesta poltrona.";
        }

        return mensagemErro;
    }

    /**
     * Este método verifica se o código da poltrona informado na passagem é
     * válido. Ele será válido se estiver dentro do intervalo da quantidade de
     * assentos no ônibus e se a poltrona não já estiver ocupada.
     *
     * @param p o objeto do tipo Passagem que possui o codigo da poltrona.
     * @return retorna um true se o cógigo da poltrona for válido e um false se
     * não for.
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
            mensagemErro = mensagemErro + "\nNão há mais vagas de GRATUIDADE com ID Jovem ";
        } else if (p.getTipoDePassagem().equals("ParcialIdJovem") && quantidadeIdJovemParcial < 2) {
            quantidadeIdJovemParcial++;
        } else if (p.getTipoDePassagem().equals("ParcialIdJovem") && quantidadeIdJovemParcial == 2) {
            mensagemErro = mensagemErro + "\nNão há mais vagas de GRATUIDADE PARCIAL com ID Jovem ";
        } else if (p.getTipoDePassagem().equals("Idoso") && quantidadeIdoso < 2) {
            quantidadeIdoso++;

        } else if (p.getTipoDePassagem().equals("Idoso") && quantidadeIdoso == 2) {
            mensagemErro = mensagemErro + "\nNão há mais vagas de GRATUIDADE para Idoso";

        } else if (p.getTipoDePassagem().equals("ParcialIdoso") && quantidadeIdosoParcial < 2) {
            quantidadeIdosoParcial++;
        } else if (p.getTipoDePassagem().equals("ParcialIdoso") && quantidadeIdosoParcial == 2) {
            mensagemErro = mensagemErro + "\nNão há mais vagas de GRATUIDADE PARCIAL para Idoso";
        }

        return mensagemErro;
    }

    public boolean estaNaViagem(Passageiro p) {
        List<Passageiro> passageiros = listagemPassageirosNaViagem();

        for (Passageiro passageiro : passageiros) {
            if (p.getCpf().equals(passageiro.getCpf())) {
                return true; //Esse passageiro já está na viagem
            }
        }
        return false; //O passageiro nao esta nessa viagem
    }

    /**
     * Este método adiciona uma passagem após checar se há disponibilidade de
     * assentos e do tipo de passagem escolhido.
     *
     * @param p o objeto do tipo Passagem que será adicionado na lista de
     * passagens.
     * @return Retorna uma string com a mensagem do erro que ocorreu. Se estiver
     * tudo certo, retorna uma string vazia.
     */
    public String adicionarPassagem(Passagem p) {
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
                    return mensagemErro;
                } else {
                    return mensagemErro;
                }

            } else {
                return "Não há mais assentos disponíveis neste onibus.";
            }
        } else {
            return "Esse passageiro já está nesta viagem";
        }

    }

    public void cancelarPassagem(Passagem p) {
        passagens.remove(p);
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

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public static int getTotalViagens() {
        return totalViagens;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Map<Integer, String> getPoltronas() {
        return poltronas;
    }
    
    

    @Override
    public String toString() {
        return "Viagem{" + "dataSaida=" + dataSaida + ", dataChegada=" + dataChegada + ", codigo=" + codigo + ", passagens=" + passagens + ", onibus=" + onibus + ", origem=" + origem + ", destino=" + destino + ", horarioSaida=" + horarioSaida + ", horarioChegada=" + horarioChegada + ", desconto=" + desconto + '}';
    }

}
