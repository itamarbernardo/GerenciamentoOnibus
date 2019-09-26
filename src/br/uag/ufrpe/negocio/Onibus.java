/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import java.util.HashMap;
import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Emily Santos;
 */
public class Onibus {
   
    private int codigo;
    private static int totalOnibus = 0;
    private int totalPoltronas;
    private Motorista motorista;
    private final ArrayList<Assento> poltronas;
    /*
    private final List<Integer> totalPoltronas;
    private final List<Integer> assentosObeso;
    private final List<Integer> assentosTotalmenteReclinaveis;
    private final List<Integer> assentosParcialmenteReclinaveis;*/

    //HashMap<String, Integer> Assentos = new HashMap<>();

    public Onibus(Motorista motorista, int totalPoltronas) {
        this.motorista = motorista;
        this.totalPoltronas = totalPoltronas;
        poltronas = new ArrayList<Assento>();
        this.codigo = totalOnibus;
        totalOnibus++;
        
        /*this.totalPoltronas = new int[totalPoltronas];
        this.motorista = motorista;
        this.assentosObeso = new ArrayList<>();
        this.assentosTotalmenteReclinaveis = new ArrayList<>();
        this.assentosParcialmenteReclinaveis = new ArrayList<>();*/
    }

    public int getCodigo() {
        return codigo;
    }
    
    
    
    private void inicializarListas(){
        Assento obeso1 = new Assento("Obeso", 3);
        Assento obeso2 = new Assento("Obeso", 7);
        Assento obeso3 = new Assento("Obeso", 11);
        poltronas.add(obeso1);
        poltronas.add(obeso2);
        poltronas.add(obeso3);
        Assento parcialmenteReclinavel = new Assento("Parcialmente Reclinável", 19);
        Assento parcialmenteReclinave2 = new Assento("Parcialmente Reclinável", 23);
        Assento parcialmenteReclinave3 = new Assento("Parcialmente Reclinável", 37);
        Assento parcialmenteReclinave4 = new Assento("Parcialmente Reclinável", 31);
        poltronas.add(parcialmenteReclinavel);
        poltronas.add(parcialmenteReclinave2);
        poltronas.add(parcialmenteReclinave3);
        poltronas.add(parcialmenteReclinave4);
        Assento totalmenteReclinave1 = new Assento("Totalmente Reclinável", 35);
        Assento totalmenteReclinave2 = new Assento("Totalmente Reclinável", 39);
        Assento totalmenteReclinave3 = new Assento("Totalmente Reclinável", 43);
        poltronas.add(totalmenteReclinave1);
        poltronas.add(totalmenteReclinave2);
        poltronas.add(totalmenteReclinave3);
        
        /*assentosObeso.add(3);
        assentosObeso.add(7);
        assentosObeso.add(11);
        assentosParcialmenteReclinaveis.add(19);
        assentosParcialmenteReclinaveis.add(23);
        assentosParcialmenteReclinaveis.add(37);
        assentosParcialmenteReclinaveis.add(31);
        assentosTotalmenteReclinaveis.add(35);
        assentosTotalmenteReclinaveis.add(39);
        assentosTotalmenteReclinaveis.add(43);*/
    }
    
    //testar antes de fazer qualquer outra coisa
    public void tirarPoltronasUsadas(){
        for(int i = 0; i < totalPoltronas; i++){
            if(!poltronas.get(i).getTipo().equals("Obeso") && !poltronas.get(i).getTipo().equals("Parcialmente Reclinável") && !poltronas.get(i).getTipo().equals("Totalmente Reclinável")){
                Assento normal = new Assento("Normal",(i+1));
                poltronas.add(normal);
            }
        }
       
        /*
        for(int i = 0; i < totalPoltronas.length; i++){
            for(int j = 0; j < assentosObeso.size();j++){
                if(i == assentosObeso.get(j)){
                    totalPoltronas[i] = 0;
                }
            }
            for(int j = 0; j < assentosParcialmenteReclinaveis.size();j++){
                if(i == assentosParcialmenteReclinaveis.get(j)){
                    totalPoltronas[i] = 0;
                }
            }
            for(int j = 0; j < assentosParcialmenteReclinaveis.size();j++){
                if(i == assentosTotalmenteReclinaveis.get(j)){
                    totalPoltronas[i] = 0;
                }
            }
        }*/
    }
    
    /*public void quantidadeAssentos(){
        
       int cont = 0;
       for(int i = 0; i < assentosObeso.size(); i++){
           Assentos.put("Assentos para Obeso.", assentosObeso.get(i));
           cont++;
       }
       
       for(int i = 0; i < assentosParcialmenteReclinaveis.size(); i++){
           Assentos.put("Assentos Parcialmente Reclináveis.", assentosObeso.get(i));
           cont++;
       }
       
       for(int i = 0; i < assentosTotalmenteReclinaveis.size(); i++){
           Assentos.put("Assentos Totalmente reclináveis.", assentosObeso.get(i));
           cont++;
       }
       
       //int valorTotalPolt = this.totalPoltronas - cont;
       for(int i = 0; i < valorTotalPolt; i++){
           Assentos.put("Assentos Convencionais.", i);
       }
    }*/

}
