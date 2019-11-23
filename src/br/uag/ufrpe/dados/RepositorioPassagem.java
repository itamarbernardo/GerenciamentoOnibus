/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.dados;

import br.uag.ufrpe.negocio.entidades.Passagem;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um repositório de Passagens
 *
 * @author Emily Santos
 */
public class RepositorioPassagem implements IRepositorioPassagem {

    private final List<Passagem> passagens;

    public RepositorioPassagem() {
        passagens = new ArrayList<>();
    }

    // ----------------------------- METODOS ---------------------------------------
    @Override
    public void adicionarPassagem(Passagem passagem) {
        this.passagens.add(passagem);
    }

    @Override
    public void alterarPassagem(Passagem passagem) {
        for (int i = 0; i < passagens.size(); i++) {
            if (passagem.equals(passagens.get(i))) {
                passagens.set(i, passagem);
            }

        }
    }

    @Override
    public Passagem procurarPassagem(int codigo) {
        for (Passagem passagem : passagens) {
            if (passagem.getCodigo() == codigo) {
                return passagem;
            }
        }
        return null;
    }
    
    public Passagem procurarPassagem(Passagem p){
       for (Passagem passagem : passagens) {
            if (passagem == p) {
                return passagem;
            }
        }
        return null;
    }

    @Override
    public void removerPassagem(int codigo) {
        passagens.remove(codigo);
    }

    @Override
    public void removerPassagem(Passagem passagem) {
        passagens.remove(passagem);
    }
       
    @Override
    public List<Passagem> listagemPassagem() {
        List<Passagem> passagemCopia = new ArrayList<>();
            for(Passagem p : passagens){
             passagemCopia.add(p);
         }
        return passagemCopia;
   }                   
      
}
    
    

