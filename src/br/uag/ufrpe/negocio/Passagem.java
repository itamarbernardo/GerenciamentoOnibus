/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

/**
 *
 * @author Emily Santos
 */
public class Passagem {
    
    private Passageiro passageiro;
    private int codigo;
    private double preco;
    private double precoTotal;
    private boolean eDentroDoEstado;
    private int codigoPoltrona;
    private String tipoDeAssento;
    private String tipoDePassagem;
    private boolean lanche;
    private static final double precoLanche = 5.00;
    private boolean criancaColo;
    private static int totalPassagens;
    private static final double tarifaInterestadual = 3.00;
    private static final double tarifaIntermunicipal = 1.50;

    public Passagem(Passageiro passageiro, double preco, boolean eDentroDoEstado, int codigoPoltrona, String tipoDeAssento, String tipoDePassagem,  boolean lanche, boolean criancaColo) {
        this.passageiro = passageiro;
        this.preco = preco;
        this.eDentroDoEstado = eDentroDoEstado;
        this.codigoPoltrona = codigoPoltrona;
        this.tipoDeAssento = tipoDeAssento;
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
        this.lanche = lanche;
        this.criancaColo = criancaColo;
        this.codigo = totalPassagens;
        totalPassagens++;
        
    }
            
    // -------------------------- GETTERS AND SETTERS ----------------------------------

    public int getCodigo() {
        
        return codigo;
    }
    
    
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    // ------------------------------ PREÇO --------------------------------------------
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
     
    // ------------------------------ TARIFA -------------------------------

    public boolean iseDentroDoEstado() {
        return eDentroDoEstado;
    }

    // ------------------------------- POLTRONA -------------------------------
    public int getCodigoPoltrona() {
        return codigoPoltrona;
    }

    public void setCodigoPoltrona(int codigoPoltrona) {
        this.codigoPoltrona = codigoPoltrona;
    }

    // ------------------------------ ASSENTO -----------------------------------
    
    public String getTipoDeAssento(){
        return  tipoDeAssento;
    }
    

    public void setTipoDeAssento(String tipoDeAssento) {
        this.tipoDeAssento = tipoDeAssento;
    }
    
    // --------------------------------- TIPO DE PASSAGEM ----------------------------
    
    public String getTipoDePassagem() {
        return tipoDePassagem;
    }

    public void setTipoDePassagem(String tipoDePassagem){
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
    }
    

    // ------------------------------------ LANCHES ---------------------------------

    public boolean isLanche() {
        return lanche;
    }
    
    public void setLanche(boolean lanche) {
        this.lanche = lanche;
    }
    

    // ---------------------------- CRIANCA NO COLO ---------------------------------
    public boolean isCriancaColo() {
        return criancaColo;
    }

    public void setCriancaColo(boolean criancaColo) {
            this.criancaColo = criancaColo;
    }


    // ----------------------------- METODOS -----------------------------------
  
        
    private String adequarTipoPassagem(String tipoDePassagem){
        String novoTipoPassagem;

        if("Idoso".equals(tipoDePassagem) && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("IdJovem".equals(tipoDePassagem) && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("ParcialIdoso".equals(tipoDePassagem) && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("ParcialIdJovem".equals(tipoDePassagem) && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else{
            novoTipoPassagem = "Normal";
        }
        return novoTipoPassagem;
    }
    
    private double calcularPrecoLanche() {
        if(this.lanche == true){
            return precoLanche;
        }
        else if(this.lanche == false){
            return 0;
        }
        return 0;
    }
    
    private double calcularPrecoTipoDeTarifa() {
        
        if(eDentroDoEstado == false){
            return tarifaInterestadual;
        }
        else{
            return tarifaIntermunicipal;
        }
    }
    private double calcularPrecoTipoDeAssento() {
        if(null != tipoDeAssento)switch (tipoDeAssento) {
            case "Totalmente Reclinada":
                return 20.00;
                        
            case "Parcialmente Reclinada":
                return 10.00;
                
            case "Assento para Obeso":
                return 15.00;
                
            case "Convencional":
                return 0.00;
                
            default:
                break;
        }
        return 0;
    }
    public double calcularPrecoTotal(){
        
    if(this.tipoDePassagem != null){switch (this.tipoDePassagem) {
            case "Idoso":
            case "IdJovem":
                this.precoTotal = (calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
                
            case "ParcialIdoso":
            case "ParcialIdJovem":
                double precoMeia;                
                precoMeia = getPreco() / 2;
                this.precoTotal = (precoMeia + calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
                
            default:                
                this.precoTotal = (getPreco() + calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
        }
        return precoTotal;
    }
    return precoTotal;
    }

}
