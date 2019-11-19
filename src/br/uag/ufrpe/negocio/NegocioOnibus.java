       
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excessoes.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excessoes.OnibusJaExisteException;
import br.uag.ufrpe.dados.interfaces.IRepositorioOnibus;
import br.uag.ufrpe.negocio.Onibus;

/**
 *
 * @author Emily Santos
 */
public class NegocioOnibus {
    
    private IRepositorioOnibus repositorio;

    public NegocioOnibus(IRepositorioOnibus repositorio) {
        this.repositorio = repositorio;
    }
    
    // --------------------------------- METODOS ----------------------------------------
    
    public void adicionar(Onibus onibus) throws OnibusJaExisteException{
        
    }
    
    public Onibus procurar(Onibus onibus){
        return onibus;
    }
    
    public void alterar(Onibus onibus) throws OnibusNaoExisteException{
        
    }
    
    public void remover(Onibus onibus) throws OnibusNaoExisteException{
        
    }
    
    public void remover(String placa) throws OnibusNaoExisteException{
        
    }
    
}
