public class UnidadeCompartilhada extends Imovel
{
    private String identificacao;
    private Condominio condominio;
    
    public UnidadeCompartilhada(
        double iptu, String tipo, String utilizacao, 
        Endereco endereco, String identificacao, Condominio condominio
    )
    {
        super(iptu, tipo, utilizacao, endereco);
        this.identificacao = identificacao;
        this.condominio = condominio;
    }
    
    @Override
    public double valorReferenciaAluguel(){
        double iptu = super.getIptu();
        int qtdItensLazer = this.getQtdItensLazer();
        if (qtdItensLazer == 0)
            return iptu * 0.1;
        return iptu * qtdItensLazer;
    }
        
    // GETs
    public String getIdentificacao(){
        return this.identificacao;
    }
    
    public Condominio getCondominio(){
        return this.condominio;
    }
    
    public int getQtdItensLazer(){
        return condominio.getItensLazer().size();
    }
    
    // SETs
    public void setIdentificacao(String novaIdentificacao){
        this.identificacao = novaIdentificacao;
    }
}
