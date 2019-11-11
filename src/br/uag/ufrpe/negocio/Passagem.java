package br.uag.ufrpe.negocio;

/**
 * Essa clase tem como objetivo criar uma passagem para uma determinada viagem.
 *
 * @author Emily Santos
 */
public class Passagem {
    
    private Passageiro passageiro;
    private final int codigo;
    private double preco;
    private double precoTotal;
    private boolean eDentroDoEstado;
    private int codigoPoltrona;
    private String tipoDeAssento;
    private String tipoDePassagem;
    private boolean lanche;
    private static final double precoLanche = 5.00;
    private boolean criancaColo;
    private static int totalPassagens;
    private static final double tarifaInterestadual = 3.00;
    private static final double tarifaIntermunicipal = 1.50;
    
    /**
     * Construtor da Classe Passagem
     *
     * @param passageiro mostra os dados do passageiro que irá na viagem;
     * @param preco informa o preco da passagem sem incluir taxas;
     * @param eDentroDoEstado informa se a viagem será dentro do Estado ou fora, gerando assim
     * uma tarifa disefenciada para cada caso;
     * @param codigoPoltrona informa o numero da poltrona em que o passageiro irá na viagem;
     * @param tipoDeAssento mostra qual o assento o passageiro deseja ir;
     * @param tipoDePassagem informa em qual categoria o passageiro se adequa;
     * @param lanche informa se o passageiro deseja ou não os lanches ofertados pela empresa;
     * @param criancaColo mostra se o passageiro possui crianca no colo;
     */

    public Passagem(Passageiro passageiro, double preco, boolean eDentroDoEstado, int codigoPoltrona, String tipoDeAssento, String tipoDePassagem,  boolean lanche, boolean criancaColo) {
        this.passageiro = passageiro;
        this.preco = preco;
        this.eDentroDoEstado = eDentroDoEstado;
        this.codigoPoltrona = codigoPoltrona;
        this.tipoDeAssento = tipoDeAssento;
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
        this.lanche = lanche;
        this.criancaColo = criancaColo;
        this.codigo = totalPassagens;
        totalPassagens++;
        this.precoTotal = calcularPrecoTotal();
    }
            
   
    public int getCodigo() {
        
        return codigo;
    }
    
    
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
        calcularPrecoTotal(); //Se mudar o preco, muda o preco total.
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
 

    public boolean iseDentroDoEstado() {
        return eDentroDoEstado;
    }


    public int getCodigoPoltrona() {
        return codigoPoltrona;
    }

    public void setCodigoPoltrona(int codigoPoltrona) {
        this.codigoPoltrona = codigoPoltrona;
    }

    
    public String getTipoDeAssento(){
        return  tipoDeAssento;
    }
    

    public void setTipoDeAssento(String tipoDeAssento) {
        this.tipoDeAssento = tipoDeAssento;
    }

    
    public String getTipoDePassagem() {
        return tipoDePassagem;
    }

    public void setTipoDePassagem(String tipoDePassagem){
        this.tipoDePassagem = adequarTipoPassagem(tipoDePassagem);
    }


    public boolean isLanche() {
        return lanche;
    }
    
    public void setLanche(boolean lanche) {
        this.lanche = lanche;
    }

    public boolean isCriancaColo() {
        return criancaColo;
    }

    public void setCriancaColo(boolean criancaColo) {
            this.criancaColo = criancaColo;
    }

    public static double getPrecoLanche() {
        return precoLanche;
    }

    public static int getTotalPassagens() {
        return totalPassagens;
    }

    public static double getTarifaInterestadual() {
        return tarifaInterestadual;
    }

    public static double getTarifaIntermunicipal() {
        return tarifaIntermunicipal;
    }

    public void seteDentroDoEstado(boolean eDentroDoEstado) {
        this.eDentroDoEstado = eDentroDoEstado;
    }


    
    
    // ----------------------------- METODOS -----------------------------------
  
    /**
     * Esse método serve para adequar a passagem de acordo com o que a escolha de poltrona do
     * passageiro, de acordo com a idade certa e os meios para se conseguir a poltrona certa;
     *
     * @param tipoDePassagem informa em qual categoria o passageiro informou querer se adequar;
     * @return Retorna o nome do tipo de categoria;
     */  
    
    private String adequarTipoPassagem(String tipoDePassagem){
        String novoTipoPassagem;

        if("Idoso".equals(tipoDePassagem) && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("IdJovem".equals(tipoDePassagem) && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("ParcialIdoso".equals(tipoDePassagem) && passageiro.calcularIdade() >= 60){
            novoTipoPassagem = tipoDePassagem;
        }
        else if("ParcialIdJovem".equals(tipoDePassagem) && passageiro.calcularIdade() >= 15 && passageiro.calcularIdade() <= 29 && passageiro.isPossuiIdJovem() == true){
            novoTipoPassagem = tipoDePassagem;
        }
        else{
            novoTipoPassagem = "Normal";
        }
        return novoTipoPassagem;
    }
    
    private double calcularPrecoLanche() {
        if(this.lanche == true){
            return precoLanche;
        }
        
        return 0;
    }
    
    private double calcularPrecoTipoDeTarifa() {
        
        if(eDentroDoEstado == false){
            return tarifaInterestadual;
        }
        else{
            return tarifaIntermunicipal;
        }
    }
    private double calcularPrecoTipoDeAssento() {
        if(null != tipoDeAssento)switch (tipoDeAssento) {
            case "TotalReclinavel":
                return 20.00;
                        
            case "Reclinavel":
                return 10.00;
                
            case "Obeso":
                return 15.00;
                
            case "Convencional":
                return 0.00;
                
            default:
                break;
        }
        return 0;
    }
  
    public double calcularPrecoTotal(){
        
    switch (this.tipoDePassagem) {
            case "Idoso":
            case "IdJovem":
                this.precoTotal = (calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
                
            case "ParcialIdoso":
            case "ParcialIdJovem":
                double precoMeia;                
                precoMeia = preco / 2;
                this.precoTotal = (precoMeia + calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
                
            default:                
                this.precoTotal = (preco + calcularPrecoTipoDeTarifa() + calcularPrecoTipoDeAssento() + calcularPrecoLanche());
                break;
        }
        return precoTotal;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Passagem){
            Passagem passagem = (Passagem)obj;
            if(codigo == passagem.getCodigo()){
                return true;
            }
        }
        return false;
    }
    
@Override
    public String toString(){
        return "PASSAGEM { Passageiro: " + passageiro + " | Preço total da passagem: " + precoTotal + " | Preco da passagem: "+ preco + " | Possui lanche: " + lanche + " | Dentro do estado: " + eDentroDoEstado + " | Possui criança no colo: " + criancaColo + " | Tipo de passagem: " + tipoDePassagem + " | Tipo de assento: " + tipoDeAssento + " }";
    }

}
