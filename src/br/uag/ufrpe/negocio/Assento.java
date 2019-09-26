/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author miyyu
 */
public class Assento {
    private String tipo;
    private int numero;
    
    public Assento(String nome, int numero){
        tipo = nome;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
