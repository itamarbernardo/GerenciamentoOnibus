/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.negocio;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jackson / Itamar Jr
 */
public class Passageiro {
    private String nomeCompleto;
    private String dataNascimento;
    private boolean possuiIdJovem;
    private String cpf;
    private String rg;
    
    public Passageiro(String nomeCompleto, String dataNascimento, boolean possuiIdJovem, String cpf, String rg) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.possuiIdJovem = possuiIdJovem;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int calcularIdade(){
        return 20;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isPossuiIdJovem() {
        return possuiIdJovem;
    }

    public void setPossuiIdJovem(boolean possuiIdJovem) {
        this.possuiIdJovem = possuiIdJovem;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public static int calculaIdade(String dataNascimento, String pattern){
        //Calcula a Idade baseado em String. Exemplo: calculaIdade("20/08/1977","dd/MM/yyyy");
        DateFormat sdf = new SimpleDateFormat(pattern);
        Date dataNascInput = null;

        try {
            dataNascInput= sdf.parse(dataNascimento);

        } catch (Exception e) {}
            Calendar dateOfBirth = new GregorianCalendar();
            dateOfBirth.setTime(dataNascInput);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, idade);

        if (today.before(dateOfBirth)) {
            idade--;
        }

        return idade;
        }
        
    @Override
    public String toString() {
        return "Passageiro{" + "dataNascimento=" + dataNascimento + ", possuiIdJovem=" + possuiIdJovem + '}';
    }
    
    
    
}
