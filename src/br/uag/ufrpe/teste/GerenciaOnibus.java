/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.teste;

import br.uag.ufrpe.negocio.Onibus;
import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Passagem;
import br.uag.ufrpe.negocio.Viagem;
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
        Onibus o = new Onibus(10, 2, 2, 2);
        Passageiro p = new Passageiro(true);
        Passagem passagem = new Passagem("Reclinavel", p, "IdJovem", 1, true);
        Passagem passagem2 = new Passagem("Reclinavel", p, "IdJovem", 10, true);
        Passagem passagem3 = new Passagem("Reclinavel", p, "ParcialIdJovem", 9, true);
        
        
        List<Passagem> passagens = new ArrayList<>();
        Viagem v = new Viagem(passagens, o, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "30/09/2019");
        v.adicionarPassagem(passagem);
        v.adicionarPassagem(passagem2);
        
        String resposta = v.adicionarPassagem(passagem3);
       
        System.out.println(resposta);
        
        double lucro = v.calculaLucroTotalDaViagem();
        System.out.println(lucro);
        
        int quantidadePassageiros = v.calcularQuantidadeDePassageirosNaViagem();
        System.out.println(quantidadePassageiros);
        
        List<Passageiro> passageiros = v.listagemPassageirosNaViagem();
        v.imprimeListaPassageirosNaViagem(passageiros);
        
        int quantidadeLanche = v.calculaQuantidadeDePassageirosQueQueremLanche();
        System.out.println(quantidadeLanche);
        
        System.out.println("Codigo viagem: " + v.getCodigo());
        
        Viagem v2 = new Viagem(passagens, o, "Garanhuns", "Cabrobo", "01:00", "19:20", 0.0, "30/09/2019");
        /*Tem que criar um mecanismo para procurar se o onibus que 
        está indo não choca com horarios de outras viagens*/
        System.out.println("Codigo viagem: " + v2.getCodigo());
       
        
    }
    
}
