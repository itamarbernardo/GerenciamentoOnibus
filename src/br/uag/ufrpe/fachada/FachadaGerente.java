/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.fachada;

import br.uag.ufrpe.negocio.NegocioViagem;
import br.uag.ufrpe.negocio.Onibus;
import br.uag.ufrpe.negocio.Viagem;
import br.uag.ufrpe.negocio.excecoes.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.ViagemJaExisteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itamar Jr
 */
public class FachadaGerente {
    
    private NegocioViagem negocioViagem;
    
    public FachadaGerente(NegocioViagem negocioViagem){
        this.negocioViagem = negocioViagem;
    }
    
    public void adicionarViagem(String placa, String origem, String destino, String horarioSaida, String horarioChegada, String dataSaida, String dataChegada){
        //Onibus onibus = negocioOnibus.procurar(String placa);
        Onibus onibus = null;
        Viagem viagem = new Viagem(onibus, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);
        
        try {
            negocioViagem.adicionar(viagem);
        } catch (ViagemJaExisteException ex) {
            ex.printStackTrace();
        } catch (MotoristaNaoDisponivelException ex) {
            ex.printStackTrace();
        } catch (OnibusNaoDisponivelException ex) {
            ex.printStackTrace();
        }
    }
    
}
