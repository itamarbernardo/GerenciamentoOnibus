/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Motorista;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Motorista
 * 
 * @author GABRIEL
 */
public class RepositorioMotorista implements IRepositorioMotorista {
    
    private final List<Motorista> motoristas;

    public RepositorioMotorista() {
        motoristas = new ArrayList<>();
    }
    
    @Override
    public void adicionarMotorista(Motorista motorista){            
            motoristas.add(motorista);
    }
   
    @Override
   public void alterarMotorista(Motorista motorista){
        int i = motoristas.indexOf(motorista);
        motoristas.set(i, motorista);
                 
            }
    
     public Motorista procurarMotorista(String numeroCarteiraMotorista) {
        for (Motorista motorista : motoristas) {
            if (motorista.getNumeroCarteiraMotorista().equals(numeroCarteiraMotorista)) {
                return motorista;
            }
        }
        return null;
    }
     
    @Override
     public void removerMotorista(Motorista motorista){
            motoristas.remove(motorista);
        }
       
    @Override
      public List<Motorista> listagemMotorista() {
        List<Motorista> motoristaCopia = new ArrayList<>();
            for(Motorista m : motoristas){
             motoristaCopia.add(m);
         }

        return motoristaCopia;
      }               
    }
  
        
    
    

