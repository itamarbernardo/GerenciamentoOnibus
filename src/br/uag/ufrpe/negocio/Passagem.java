/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

/**
 *
 * @author Itamar Jr
 */
public class Passagem {
    
    private String tipoDeAssento;
    private Passageiro passageiro;
    private int codigoPoltrona;
    private String tipoDePassagem;
    private double preco;
    private boolean lanche;
    
    public Passagem(String tipoDeAssento, Passageiro passageiro, String tipoDePassagem, int codigoPoltrona, boolean lanche){
        this.tipoDeAssento = tipoDeAssento;
        this.passageiro = passageiro;
        this.codigoPoltrona = codigoPoltrona;
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
        this.preco = calcularPreco();
        this.lanche = lanche;
    }

    public boolean isLanche() {
        return lanche;
    }

    public void setLanche(boolean lanche) {
        this.lanche = lanche;
    }
    
    
    
    public double calcularPreco(){
        double precoCalculado = 10;
        return precoCalculado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
    public String adequarTipoPassagem(String tipoDePassagem){
        String novoTipoPassagem;
        
        if(tipoDePassagem.equals("Idoso") && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if(tipoDePassagem.equals("IdJovem") && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else if(tipoDePassagem.equals("ParcialIdoso") && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if(tipoDePassagem.equals("ParcialIdJovem") && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else{
            novoTipoPassagem = "Normal";
        }
        return novoTipoPassagem;
    }
    
    public String getTipoDePassagem() {
        return tipoDePassagem;
    }

    public void setTipoDePassagem(String tipoDePassagem){
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
    }
    
    public int getCodigoPoltrona() {
        return codigoPoltrona;
    }

    public void setCodigoPoltrona(int codigoPoltrona) {
        this.codigoPoltrona = codigoPoltrona;
    }   

    public String getTipoDeAssento() {
        return tipoDeAssento;
    }

    public void setTipoDeAssento(String tipoDeAssento) {
        this.tipoDeAssento = tipoDeAssento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
    
        
}
