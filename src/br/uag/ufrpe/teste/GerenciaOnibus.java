/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.teste;

import br.uag.ufrpe.negocio.Endereco;
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
        Endereco endereco = new Endereco("55293-000", "Rua 10", "Centro", "121-A", "Casa", "Garanhuns", "PE");
        Motorista m = new Motorista("João Silva", "123.456.789-58", "12.456.158-5", "4547-5280", endereco, "12345678982");
        
        List<Integer> poltronasObeso = new ArrayList<>();
        poltronasObeso.add(1);
        poltronasObeso.add(15);

        List<Integer> poltronasReclinavel = new ArrayList<>();
        poltronasReclinavel.add(5);
        poltronasReclinavel.add(13);

        List<Integer> poltronasTotalReclinavel = new ArrayList<>();
        poltronasTotalReclinavel.add(2);
        poltronasTotalReclinavel.add(4);
        poltronasTotalReclinavel.add(21);
        
        Onibus o = new Onibus(m, "ABC - 4080", 45, poltronasObeso, poltronasTotalReclinavel, poltronasReclinavel);
        Onibus o2 = new Onibus(m, "IJK - 1020", 42, poltronasObeso, poltronasTotalReclinavel,poltronasReclinavel);
        
        
        Passageiro p = new Passageiro("Rodrigo Santos", "30/12/1998","9829812", "117.982.029-10",  "45443110", true);
        Passageiro p2 = new Passageiro("Maraia Silva", "19/12/1992","1099922" , "002.982.029-10", "12345678", true);
        
        Passagem passagem = new Passagem(p, 10.00, true, 8, "Convencional", "IdJovem", true, false);
        Passagem passagem2 = new Passagem(p2, 20.00, false, 5, "Parcialmente Reclinada", "Normal", true, false);
        
        
        Viagem v = new Viagem(o, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "30/09/2019", "30/09/2019");

        System.out.println("Adicionar: " + v.adicionarPassagem(passagem));
        System.out.println("Adicionar: " + v.adicionarPassagem(passagem2));
        
        String resposta = v.adicionarPassagem(passagem2);
       
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
