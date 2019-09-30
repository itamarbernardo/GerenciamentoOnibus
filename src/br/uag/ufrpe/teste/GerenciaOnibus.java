/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.teste;

import br.uag.ufrpe.negocio.Endereco;
import br.uag.ufrpe.negocio.Funcionario;
import br.uag.ufrpe.negocio.Motorista;
import br.uag.ufrpe.negocio.Onibus;
import br.uag.ufrpe.negocio.Passageiro;
import br.uag.ufrpe.negocio.Passagem;
import br.uag.ufrpe.negocio.Viagem;
import br.uag.ufrpe.repositorios.RepositorioFuncionario;
import br.uag.ufrpe.repositorios.RepositorioMotorista;
import br.uag.ufrpe.repositorios.RepositorioOnibus;
import br.uag.ufrpe.repositorios.RepositorioPassageiro;
import br.uag.ufrpe.repositorios.RepositorioPassagem;
import br.uag.ufrpe.repositorios.RepositorioViagem;
import java.text.DecimalFormat;
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
        
        RepositorioViagem repositorioViagem = new RepositorioViagem();
        RepositorioOnibus repositorioOnibus = new RepositorioOnibus();
        RepositorioPassagem repositorioPassagem = new RepositorioPassagem();
        RepositorioPassageiro repositorioPassageiro = new RepositorioPassageiro();
        RepositorioFuncionario repositorioFuncionario  = new RepositorioFuncionario();
        RepositorioMotorista repositorioMotorista = new RepositorioMotorista();
        
        
        Endereco endereco = new Endereco("55293-000", "Rua 10", "Centro", "121-A", "Casa", "Garanhuns", "PE");
        Motorista m = new Motorista("João Silva", "123.456.789-58", "1209139", "(87)99454-5280", endereco, "12345678982");
        Motorista m2 = new Motorista("Marcelo Paes", "992.456.789-58", "9909101", "(82)99107-5280", endereco, "12345678982");
        repositorioMotorista.adicionarMotorista(m);
        repositorioMotorista.adicionarMotorista(m2);
        
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
        
        Onibus o = new Onibus(m, "ABC-4080", 45, poltronasObeso, poltronasTotalReclinavel, poltronasReclinavel);
        Onibus o2 = new Onibus(m2, "IJK-1020", 42, poltronasObeso, poltronasTotalReclinavel,poltronasReclinavel);
        repositorioOnibus.adicionarOnibus(o);
        repositorioOnibus.adicionarOnibus(o2);

        Passageiro p = new Passageiro("Rodrigo Santos", "30/12/1998","9829812", "117.982.029-10",  "(82)9454-4311", true);
        Passageiro p2 = new Passageiro("Maraia Silva", "19/12/1992","1099922" , "002.982.029-10", "(81)9123-4567", true);
        Passageiro p3 = new Passageiro("Jose Silva", "20/10/1997", "910291", "991.201.192.20", "(87)99291-1020", false);
        repositorioPassageiro.adicionarPassageiro(p);
        repositorioPassageiro.adicionarPassageiro(p2);
        repositorioPassageiro.adicionarPassageiro(p3);

        System.out.println("Disposição das poltronas do Onibus: " + o.getPlaca() + "\n" + o.getPoltronas());
        
        Passagem passagem = new Passagem(p, 50.00, true, 8, "Convencional", "IdJovem", true, false);
        Passagem passagem2 = new Passagem(p2, 50.00, true, 5, "Reclinavel", "Normal", true, false);
        Passagem passagem3 = new Passagem(p3, 50.0, false, 3, "TotalReclinavel", "ParcialIdJovem", true, true);
        repositorioPassagem.adicionarPassagem(passagem);
        repositorioPassagem.adicionarPassagem(passagem2);
        repositorioPassagem.adicionarPassagem(passagem3);
        
        Viagem v = new Viagem(o, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "30/09/2019", "30/09/2019");

        
        System.out.println("Adicionar Passagem 1: " + v.adicionarPassagem(passagem));
        System.out.println("Adicionar Passagem 2: " + v.adicionarPassagem(passagem2));
        System.out.println("Adicionar Passagem 3: " + v.adicionarPassagem(passagem3));
       
        
        double lucro = v.calculaLucro();
        System.out.println("Lucro da viagem: " + lucro);
        
        
        Viagem v2 = new Viagem(o2, "Garanhuns", "Cabrobo", "01:00", "19:20", 0.0, "30/09/2019", "30/09/2019");
        v2.adicionarPassagem(passagem);
        v2.adicionarPassagem(passagem2);
       
        
        repositorioViagem.adicionarViagem(v);
        repositorioViagem.adicionarViagem(v2);
        
        
        Viagem v3 = new Viagem(o, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "01/10/2019", "01/10/2019");
        v3.adicionarPassagem(passagem);
        v3.adicionarPassagem(passagem2);
       
        Viagem v4 = new Viagem(o2, "Garanhuns", "Recife", "10:00", "13:30", 0.0, "02/10/2019", "02/10/2019");
        v4.adicionarPassagem(passagem);
        v4.adicionarPassagem(passagem2);
       
        repositorioViagem.adicionarViagem(v3);
        repositorioViagem.adicionarViagem(v4);
        
        double porcentagem = repositorioViagem.calculaPorcentagemPassageirosPorDatas("15/09/2019", "03/10/2019");
        porcentagem*=100;
        DecimalFormat formato = new DecimalFormat("0.00");   //limita o número de casas decimais    
        String porcentagemFormatada = formato.format(porcentagem);

        System.out.println("\nPorcentagem de passageiros no intervalo de datas: " + porcentagemFormatada + "%");
        
        porcentagem = repositorioViagem.calculaPorcentagemLanchePorDatasEDestino("Garanhuns", "Recife", "15/09/2019", "03/10/2019");
        System.out.println("\nPorcentagem de Lanche no intervalo de datas e Destino: " + porcentagem*100 + "%");
                
        double lucroTotal = repositorioViagem.calcularLucroTotalPorDatasEViagens("10:00","Garanhuns", "Recife", "15/09/2019", "03/10/2019");
        System.out.println("\nLucro total no intervalo de datas por viagens: " + lucroTotal);
        
        Passageiro passageiro = repositorioPassageiro.procurarPassageiro("117.982.029-10");
        String ultimasViagens = repositorioViagem.procurarUltimasViagensDeUmPassagiro(passageiro);
        System.out.println("\nUltimas viagens do passageiro: \n" + ultimasViagens);
        
        Funcionario f = new Funcionario("1283", "joao@gmail.com", "Joao Filho Silva", "119.288.399-19", "0981983", "(98)99002-9218", endereco, true);
        

    }
    
}
