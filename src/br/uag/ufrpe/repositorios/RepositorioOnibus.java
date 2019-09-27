/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Onibus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emily Santos;
 */
public class RepositorioOnibus {
        private List<Onibus> onibus;
    
    
    public RepositorioOnibus(){
        onibus = new ArrayList<>();
    }        
    
    // ----------------------------- METODOS ---------------------------------------
    
    public boolean adicionarOnibus(Onibus oni){
        if(procurarOnibus(oni.getPlaca()) != null){
            onibus.add(oni);
            return true;
        }
        return false;
    }
    
    public boolean alterarOnibus(Onibus oni, String placa){
        Onibus o = procurarOnibus(placa);
        if(o != null){
            onibus.remove(o);
            adicionarOnibus(oni);
            return true;
        }
        return false;
    }
    
    public Onibus procurarOnibus(String placa){
        for(Onibus o: onibus){
            if(o.getPlaca() == placa) {
                return o;
            }
        }
        return null;
    }
    
    public boolean removerOnibus(String placa){
        Onibus o = procurarOnibus(placa);
        
        if(o != null){
            onibus.remove(o);
            return true;
        }
        return false;
    }
   
    public boolean removerOnibus(Onibus o){
        onibus.remove(o);
        return true;
    }
    
}
