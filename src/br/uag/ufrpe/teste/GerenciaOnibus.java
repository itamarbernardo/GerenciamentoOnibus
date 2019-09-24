/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.teste;

import br.uag.ufrpe.negocio.Motorista;
import br.uag.ufrpe.negocio.Onibus;
import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Passagem;
import br.uag.ufrpe.negocio.Viagem;
import br.uag.ufrpe.repositorios.RepositorioViagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Itamar Jr
 */
public class GerenciaOnibus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Motorista m = new Motorista("117.980.281-12");
        
        Onibus o = new Onibus(10, 2, 2, 2, m);
        Onibus o2 = new Onibus(10, 2, 2, 2, m);
        
        
        Passageiro p = new Passageiro(true, "117.982.029-10");
        Passageiro p2 = new Passageiro(true, "002.982.029-10");
        
        Passagem passagem = new Passagem("Reclinavel", p, "IdJovem", 1, true);
        Passagem passagem2 = new Passagem("Reclinavel", p2, "IdJovem", 10, true);
        Passagem passagem3 = new Passagem("Reclinavel", p, "ParcialIdJovem", 9, true);
        
        
        Viagem v = new Viagem(o, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "30/09/2019", "30/09/2019");

        System.out.println("Adicionar: " + v.adicionarPassagem(passagem));
        System.out.println("Adicionar: " + v.adicionarPassagem(passagem2));
        
        String resposta = v.adicionarPassagem(passagem3);
       
        System.out.println(resposta);
        
        double lucro = v.calculaLucroTotalDaViagem();
        System.out.println(lucro);
        
        int quantidadePassageiros = v.calcularQuantidadeDePassageirosNaViagem();
        System.out.println(quantidadePassageiros);
        
        List<Passageiro> passageiros = v.listagemPassageirosNaViagem();
        v.imprimeListaPassageirosNaViagem(passageiros);
        
        int quantidadeLanche = v.calculaQuantidadeLanche();
        System.out.println(quantidadeLanche);
        
        System.out.println("Codigo viagem: " + v.getCodigo());
        
        Viagem v2 = new Viagem(o2, "Garanhuns", "Cabrobo", "01:00", "19:20", 0.0, "30/09/2019", "30/09/2019");
        v2.adicionarPassagem(passagem);
        v2.adicionarPassagem(passagem2);
        /*Tem que criar um mecanismo para procurar se o onibus que 
        está indo não choca com horarios de outras viagens*/
        System.out.println("Codigo viagem: " + v2.getCodigo());
       
        RepositorioViagem repositorioViagem = new RepositorioViagem();
        
        repositorioViagem.adicionarViagem(v);
        String resposta2 = repositorioViagem.adicionarViagem(v2);
        
        //Imprime os ultimos destinos do passageiro P
        System.out.println(resposta2);
        
        Viagem v3 = new Viagem(o2, "Garanhuns", "Cabrobo", "01:00", "19:20", 0.0, "30/09/2019", "30/09/2019");
        Viagem v4 = new Viagem(o2, "Garanhuns", "Cabrobo", "01:00", "19:20", 0.0, "30/09/2019", "30/09/2019");
        System.out.println(v3.equals(v3));
        
        
        
    }
    
}
