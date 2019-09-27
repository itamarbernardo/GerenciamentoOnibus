/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
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
    private Map<Integer, String> poltronas;
    
    public Onibus(Motorista motorista, int totalPoltronas) {
        this.motorista = motorista;
        this.totalPoltronas = totalPoltronas;
        poltronas = new HashMap<Integer, String>();
        this.codigo = totalOnibus;
        totalOnibus++;

    }

    public Map<Integer, String> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(Map<Integer, String> poltronas) {
        this.poltronas = poltronas;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public static int getTotalOnibus() {
        return totalOnibus;
    }

    public static void setTotalOnibus(int totalOnibus) {
        Onibus.totalOnibus = totalOnibus;
    }

    public int getTotalPoltronas() {
        return totalPoltronas;
    }

    public void setTotalPoltronas(int totalPoltronas) {
        this.totalPoltronas = totalPoltronas;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;    
        
    }

    
    
    

}
