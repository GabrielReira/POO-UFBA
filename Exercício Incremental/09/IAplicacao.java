public interface IAplicacao
{
   public boolean disponibilidadeImovel(Imovel imovel, String dataInicio, String dataFim);
   public double consultarPrecoAluguel(Imovel imovel, String data);
   public double consultarPrecoAluguel(Imovel imovel, String dataInicio, String dataFim);
}
