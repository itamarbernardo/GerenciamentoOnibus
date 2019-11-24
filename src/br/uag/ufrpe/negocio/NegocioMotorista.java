/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.entidades.Motorista;
import  br.uag.ufrpe.dados.IRepositorioMotorista ;
import br.uag.ufrpe.dados.RepositorioMotorista;
import br.uag.ufrpe.negocio.excecoes.motorista.MotoristaJaExisteException;
import br.uag.ufrpe.negocio.excecoes.motorista.MotoristaNaoExisteException;



/**
 *
 * @author Gabriel
 */
public class NegocioMotorista {
    
   private IRepositorioMotorista repositorio;
   
   public NegocioMotorista(){
            this.repositorio = new RepositorioMotorista();
    }
   
   public void adicionarMotorista(Motorista m) throws MotoristaJaExisteException{
        Motorista motorista = repositorio.procurarMotorista(m.getNumeroCarteiraMotorista());
        if(motorista == null){
           repositorio.adicionarMotorista(m);
        }  else {
            throw new MotoristaJaExisteException();
        }     
   }
   
  public void removerMotorista(Motorista m) throws MotoristaNaoExisteException{
      Motorista motorista = repositorio.procurarMotorista(m.getNumeroCarteiraMotorista());
      if(motorista != null){
          repositorio.removerMotorista(motorista);
      }  else {
           throw new MotoristaNaoExisteException(); 
      }
  }     
    
  public void alterarMotorista(Motorista m) throws MotoristaNaoExisteException{
      int motorista = repositorio.listagemMotorista().indexOf(m);
     
      if(motorista == -1){
          throw new MotoristaNaoExisteException(); 
      } else{ 
            repositorio.alterarMotorista(m);
      }    
  }
 
  public Motorista procurarMotorista(Motorista m){ 
      return repositorio.procurarMotorista(m.getNumeroCarteiraMotorista()); 
  }
  
}

