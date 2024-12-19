package estoque;
/**
 * 
 * @author felipe Ferreira
 * @since 10/12/2025 at 15:32
 */
public class Entidade {
    
    
    private int id;
    private String nome;
    private String telefone;
    
    public Entidade(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
