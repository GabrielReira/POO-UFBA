import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda
{
    // Se não tiver alugado nem bloqueado é porque está disponível
    private ArrayList<LocalDate> datasAlugado;
    private ArrayList<LocalDate> datasBloqueado;

    public Agenda()
    {
        this.datasAlugado = new ArrayList<LocalDate>();
        this.datasBloqueado = new ArrayList<LocalDate>();
    }

    // GETs    
    public ArrayList<LocalDate> getDatasAlugado() {
        return this.datasAlugado;
    }
    
    public ArrayList<LocalDate> getDatasBloqueado() {
        return this.datasBloqueado;
    }
    
    // SETs   
    public void adicionaDataAlugado (LocalDate data) {
        this.datasAlugado.add(data);
    }
    public void removeDataAlugado (LocalDate data) {
        if (this.datasAlugado.contains(data)) {
            this.datasAlugado.remove(data);
        }
    }
    
    public void adicionaDataBloqueado(LocalDate data) {
        this.datasBloqueado.add(data);
    }
    public void removeDataBloqueado(LocalDate data) {
        if (this.datasBloqueado.contains(data)) {
            this.datasBloqueado.remove(data);
        }            
    }
}
