/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uag.ufrpe.dados.repositorios;

import br.uag.ufrpe.dados.interfaces.IRepositorioMotorista;
import br.uag.ufrpe.negocio.Motorista;
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
        if(procurarMotorista(motorista.getNumeroCarteiraMotorista()) == null){
            motoristas.add(motorista);
        }
    }
   
    @Override
   public boolean alterarMotorista(Motorista motorista){
        for (int i = 0; i < motoristas.size(); i++) {
            if (motorista.equals(motoristas.get(i))) {
                motoristas.set(i, motorista);
                return true; 
            }
        }
        return false;   
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
        Motorista encontrado = procurarMotorista(motorista.getNumeroCarteiraMotorista());
        
         if (encontrado != null) {
            motoristas.remove(encontrado);
        }
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
  
        
    
    

