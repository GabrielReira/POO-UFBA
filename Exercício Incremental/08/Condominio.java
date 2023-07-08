import java.util.ArrayList;

public class Condominio
{
    private Endereco endereco;
    private ArrayList<String> itensLazer;
    
    public Condominio(Endereco endereco)
    {
        this.endereco = endereco;
        this.itensLazer = new ArrayList<String>();
    }
    
    // Adicionar item de lazer
    public void adicionaItemLazer(String item){
        this.itensLazer.add(item);
    }
    
    // GETs
    public ArrayList<String> getItensLazer() {
        return this.itensLazer;
    }
    
    public String getRua(){
        return this.endereco.getRua();
    }
    
    public int getNumero() {
        return this.endereco.getNumero();
    }
    
    public String getCep() {
        return this.endereco.getCep();
    }
    
    public String getEstado() {
        return this.endereco.getEstado();
    }
    
    public String getCidade() {
        return this.endereco.getCidade();
    }
    
    // SETs
    public void setRua(String novaRua) {
        this.endereco.setRua(novaRua);
      }
    
    public void setNumero(int novoNumero) {
        this.endereco.setNumero(novoNumero);
    }
    
    public void setCep(String novoCep) {
        this.endereco.setCep(novoCep);
    }
    
    public void setEstado(String novoEstado) {
        this.setEstado(novoEstado);
    }
    
    public void setCidade(String novaCidade) {
        this.setCidade(novaCidade);
    }
}
