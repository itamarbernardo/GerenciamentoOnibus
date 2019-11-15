/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.repositorios;

import br.uag.ufrpe.negocio.Passagem;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Passagens
 *
 * @author Emily Santos
 */
public class RepositorioPassagem {

    private final List<Passagem> passagens;

    public RepositorioPassagem() {
        passagens = new ArrayList<>();
    }

    // ----------------------------- METODOS ---------------------------------------
    public boolean adicionarPassagem(Passagem passagem) {
        if (procurarPassagem(passagem.getCodigo()) != null) {
            this.passagens.add(passagem);
            return true;
        }
        return false;
    }

    public boolean alterarPassagem(Passagem passagem) {
        for (int i = 0; i < passagens.size(); i++) {
            if (passagem.equals(passagens.get(i))) {
                passagens.set(i, passagem);
                return true;
            }

        }
        return false;

    }

    public Passagem procurarPassagem(int codigo) {
        for (Passagem passagem : passagens) {
            if (passagem.getCodigo() == codigo) {
                return passagem;
            }
        }
        return null;
    }

    public boolean removerPassagem(int codigo) {
        Passagem p = procurarPassagem(codigo);

        if (p != null) {
            passagens.remove(p);
            return true;
        }
        return false;
    }

    public boolean removerPassagem(Passagem passagem) {
        Passagem p = procurarPassagem(passagem.getCodigo());
        if (p != null) {
            passagens.remove(passagem);
            return true;
        }
        return false;
    }
       
   public List<Passagem> listagemPassagem() {
        List<Passagem> PassagemCopia = new ArrayList<>();
            for(Passagem p : passagens){
             PassagemCopia.add(p);
         }
        return PassagemCopia;
   }                 
      
   }
    
    

