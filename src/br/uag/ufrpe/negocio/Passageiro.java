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
public class Passageiro extends Pessoa {
    
    private String dataNascimento;
    private boolean possuiIdJovem;
    
    public Passageiro(String nomeCompleto, String dataNascimento, boolean possuiIdJovem, String cpf, String rg, String email, Endereco endereco, String telefone) {
        super(nomeCompleto, cpf, rg, email, endereco, telefone);
        
        this.dataNascimento = dataNascimento;
        this.possuiIdJovem = possuiIdJovem;
        
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
    
    public int calcularIdade(String dataNascimento, String pattern){
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
