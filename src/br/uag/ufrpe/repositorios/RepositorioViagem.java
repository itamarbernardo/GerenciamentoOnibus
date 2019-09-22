/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Viagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Itamar Jr
 */
public class RepositorioViagem {
    
    private List<Viagem> viagens;
    
    public RepositorioViagem(){
        viagens = new ArrayList<>();
    }
    
    public double calculaMediaQuantidadePassageirosQueremLancheEmCertoIntervaloDeDatas(String horarioSaida, String destino, String dataInicio, String dataFim){
        //Calcular o intervalo das datas, e procurar em todas as viagens se estão dentro desse intervalo
        
        double media = 0.0;
        double passageiros = 0.0;
        double passageirosComLanche = 0.0;
        //Supondo que está nesse intervalo
        for(Viagem viagem : viagens){
            if(true){ //Tem que verificar o intervalo das datas, o horario e o destino
                
            passageirosComLanche = passageirosComLanche + viagem.calculaQuantidadeDePassageirosQueQueremLanche();
            passageiros = passageiros + viagem.calcularQuantidadeDePassageirosNaViagem();
        
            }
        }
        
        media = passageirosComLanche / passageiros;
        
        return media;
    }
    
    public double calculaMediaPassageirosPorViagemEmCertoIntervaloDeDatas(String horario, String destino, String dataInicio, String dataFim){
        //Calcular o intervalo das datas, e procurar em todas as viagens se estão dentro desse intervalo
        
        double media = 0.0;
        double capacidadeOnibus = 0.0;
        double quantidadePassageiros = 0.0;
        
        for(Viagem viagem : viagens){
           if(true){  //Tem que verificar o intervalo das datas, o horario e o destino
               capacidadeOnibus = capacidadeOnibus + viagem.getOnibus().getQuantidadeAssentos();
               quantidadePassageiros = quantidadePassageiros + viagem.calcularQuantidadeDePassageirosNaViagem();
           }
        }
        
        media  = quantidadePassageiros / capacidadeOnibus;
        return media;
    }
    
    
    public double calcularLucroTotalEmCertoIntervaloDeDatas(String dataInicio, String dataFim){
        double lucroTotal = 0.0;
        
        for(Viagem viagem : viagens){
            if(true){ //Tem que verificar o intervalo dado
                lucroTotal = lucroTotal + viagem.calculaLucroTotalDaViagem();
            }
        }
        return lucroTotal;
    }
    
    public double calcularLucroTotalPorViagemEmCertoIntervaloDeDatas(String horarioSaida, String destino, String dataInicio, String dataFim){
        double lucroTotal = 0.0;
        
        for(Viagem viagem : viagens){
            if(true){ //Tem que verificar o intervalo dado e se é essa viagem nesse horario e destino
                lucroTotal = lucroTotal + viagem.calculaLucroTotalDaViagem();
            }
        }
        return lucroTotal;
    }

    public String procurarViagensDeUmPassagiro(Passageiro passageiro){
        String ultimosDestinos = "CPF: " + passageiro.getCpf() + "\n";
        
        for(Viagem viagem : viagens){
            for(Passageiro p : viagem.listagemPassageirosNaViagem()){
                if(p.getCpf().equals(passageiro.getCpf())){
                    ultimosDestinos = ultimosDestinos + "\nOrigem: " + viagem.getOrigem() + "\nDestino: " + viagem.getDestino() + "\nData: " + viagem.getData() + "\nHorario Saída: " + viagem.getHorarioSaida();
                }
            }
        }
        return ultimosDestinos;
    }
    
    public boolean adicionarViagem(Viagem v){
        Viagem viagem = procurarViagem(v.getCodigo());
        if(viagem == null){
            viagens.add(v);
            return true;
        }
        return false; //Caso essa viagem já exista no repositorio, o método não adiciona novamente
    }
    
    public boolean removerViagem(int codigo){
        Viagem v = procurarViagem(codigo);
        if(v != null){
            viagens.remove(v);
            return true; //Se existir a viagem, ele remove
        }
        return false;
    
    }
    
    public boolean alterarViagem(Viagem v, int codigo){
        Viagem viagem = procurarViagem(codigo);
        if(viagem != null){
            viagens.remove(viagem);
            viagens.add(v);
            return true; //So altera se a viagem existir
        }
        return false;
    }
    
    public Viagem procurarViagem(int codigo){
        for(Viagem viagem : viagens){
            if(viagem.getCodigo() == codigo){
                return viagem;
            }
        }
        return null; //Não achou a viagem
    }
    
    public Viagem procurarViagem(String data, String horaSaida, String destino){
        for(Viagem viagem : viagens){
            if(viagem.getData().equals(data) && viagem.getHorarioSaida().equals(horaSaida) && viagem.getDestino().equals(destino)){
                return viagem;
            }
        }
        return null; //Se não achou a viagem
    }   

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }
    
    
}
