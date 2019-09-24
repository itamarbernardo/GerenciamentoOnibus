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
public class Onibus {
    
    private int quantidadeAssentos;
    private int quantidadeAssentosReclinaveis;
    private int quantidadeAssentosTotalmenteReclinaveis;
    private int quantidadeAssentosObeso;
    private Motorista motorista;
    private int codigo;

    public Onibus(int quantidadeAssentos, int quantidadeAssentosReclinaveis, int quantidadeAssentosTotalmenteReclinaveis, int quantidadeAssentosObeso, Motorista motorista) {
        this.quantidadeAssentos = quantidadeAssentos;
        this.quantidadeAssentosReclinaveis = quantidadeAssentosReclinaveis;
        this.quantidadeAssentosTotalmenteReclinaveis = quantidadeAssentosTotalmenteReclinaveis;
        this.quantidadeAssentosObeso = quantidadeAssentosObeso;
        this.motorista = motorista;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    
    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public int getQuantidadeAssentosReclinaveis() {
        return quantidadeAssentosReclinaveis;
    }

    public void setQuantidadeAssentosReclinaveis(int quantidadeAssentosReclinaveis) {
        this.quantidadeAssentosReclinaveis = quantidadeAssentosReclinaveis;
    }

    public int getQuantidadeAssentosTotalmenteReclinaveis() {
        return quantidadeAssentosTotalmenteReclinaveis;
    }

    public void setQuantidadeAssentosTotalmenteReclinaveis(int quantidadeAssentosTotalmenteReclinaveis) {
        this.quantidadeAssentosTotalmenteReclinaveis = quantidadeAssentosTotalmenteReclinaveis;
    }

    public int getQuantidadeAssentosObeso() {
        return quantidadeAssentosObeso;
    }

    public void setQuantidadeAssentosObeso(int quantidadeAssentosObeso) {
        this.quantidadeAssentosObeso = quantidadeAssentosObeso;
    }
    
    
    
}
