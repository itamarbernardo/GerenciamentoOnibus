       
package br.uag.ufrpe.negocio;

import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusJaExisteException;
import br.uag.ufrpe.dados.IRepositorioOnibus;
import br.uag.ufrpe.dados.RepositorioOnibus;
import br.uag.ufrpe.negocio.entidades.Onibus;

/**
 *
 * @author Emily Santos
 */
public class NegocioOnibus {
    
    private IRepositorioOnibus repositorio;

    public NegocioOnibus() {
        this.repositorio = new RepositorioOnibus();
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
