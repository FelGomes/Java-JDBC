package estoque;

import java.time.LocalDateTime;

public class Vendas extends Entidade {
    
    private LocalDateTime hora;
    private int quantidade;
    
    public Vendas (int id, LocalDateTime hora, int quantidade){
        super(id, "","");
        this.hora = hora;
        this.quantidade = quantidade;
       
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
