/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.Onibus;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Onibus
 *
 * @author Emily Santos;
 */
public class RepositorioOnibus implements IRepositorioOnibus {

    private final List<Onibus> onibus;

    public RepositorioOnibus() {
        onibus = new ArrayList<>();
    }

    // ----------------------------- METODOS ---------------------------------------
    @Override
    public boolean adicionarOnibus(Onibus oni) {
        if (procurarOnibus(oni.getPlaca()) != null) {
            onibus.add(oni);
            return true;
        }
        return false;
    }

    @Override
    public boolean alterarOnibus(Onibus oni) {
        for (int i = 0; i < onibus.size(); i++) {
            if (oni.equals(onibus.get(i))) {
                onibus.set(i, oni);
                return true;
            }

        }
        return false;
    }

    @Override
    public Onibus procurarOnibus(String placa) {
        for (Onibus o : onibus) {
            if (o.getPlaca().equals(placa)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public boolean removerOnibus(String placa) {
        Onibus o = procurarOnibus(placa);

        if (o != null) {
            onibus.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean removerOnibus(Onibus o) {
        Onibus oni = procurarOnibus(o.getPlaca());

        if (oni != null) {
            onibus.remove(o);
            return true;
        }
        return false;
    }
    
    @Override
      public List<Onibus> listagemOnibus() {
        List<Onibus> onibusCopia = new ArrayList<>();
            for(Onibus o : onibus){
             onibusCopia.add(o);
         }
        return onibusCopia;
   }                 
      

}
