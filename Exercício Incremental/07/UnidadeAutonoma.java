public class UnidadeAutonoma extends Imovel
{
    private double areaUtil;
    private double areaConstruida;

    public UnidadeAutonoma(
        double iptu, String tipo, String utilizacao, 
        Endereco endereco, double areaUtil, double areaConstruida
    )
    {
        super(iptu, tipo, utilizacao, endereco);
        this.areaUtil= areaUtil;
        this.areaConstruida = areaConstruida;
    }
    
    @Override
    public double valorReferenciaAluguel(){
        return areaConstruida * 15;
    }

    // GETs
    public double getAreaUtil(){
        return this.areaUtil;
    }
    
    public double getAreaConstruida(){
        return this.areaConstruida;
    }
    
    // SETs
    public void setAreaUtil(double novaAreaUtil){
        this.areaUtil = novaAreaUtil;
    }
    
    public void setAreaConstruida(double novaAreaConstruida){
        this.areaConstruida = novaAreaConstruida;
    }
}
