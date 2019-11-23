/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Onibus;
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

    /**
     *
     * @param oni representa o onibus que está sendo adicionado;
     */
    
    @Override
    public void adicionarOnibus(Onibus oni){
       onibus.add(oni);
       
    }

    @Override
    public void alterarOnibus(Onibus oni) {
        for (int i = 0; i < onibus.size(); i++) {
            if (oni.equals(onibus.get(i))) {
                onibus.set(i, oni);
            }

        }
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
    public void removerOnibus(String placa) {
        
        onibus.remove(placa);
    }

    @Override
    public void removerOnibus(Onibus o) {
        onibus.remove(o);
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
