       
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.OnibusJaExisteException;
import br.uag.ufrpe.dados.IRepositorioOnibus;
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
    
    public void adicionarOnibus(Onibus onibus) throws OnibusJaExisteException{
        if(procurarOnibus(onibus.getPlaca()) == null){
            repositorio.adicionarOnibus(onibus);
        }
        
        throw new OnibusJaExisteException();
    }
    
    public Onibus procurarOnibus(String placa){
        if(repositorio.procurarOnibus(placa) != null){
            return repositorio.procurarOnibus(placa);
        }
        
        return null;

    }
    
    public void alterarOnibus(Onibus onibus) throws OnibusNaoExisteException{
        if(repositorio.procurarOnibus(onibus.getPlaca()) != null){
            repositorio.alterarOnibus(onibus);
        }
        throw new OnibusNaoExisteException();
    }
    
    public void removerOnibus(Onibus onibus) throws OnibusNaoExisteException{
        if(repositorio.procurarOnibus(onibus.getPlaca()) != null){
            repositorio.removerOnibus(onibus);
        }
        throw new OnibusNaoExisteException();
        
    }
    
    public void removerOnibus(String placa) throws OnibusNaoExisteException{
        if(repositorio.procurarOnibus(placa) != null){
            repositorio.removerOnibus(placa);
        }
        throw new OnibusNaoExisteException();
    }
    
}
