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
    private String cidade_nome;
    private String cidade_uf;
    
    public Entidade(String nome, String telefone, String cidade_nome, String cidade_uf){
        this.nome = nome;
        this.telefone = telefone;
        this.cidade_nome = cidade_nome;
        this.cidade_uf = cidade_uf;
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

    public String getCidade_nome() {
        return cidade_nome;
    }

    public void setCidade_nome(String cidade_nome) {
        this.cidade_nome = cidade_nome;
    }

    public String getCidade_uf() {
        return cidade_uf;
    }

    public void setCidade_uf(String cidade_uf) {
        this.cidade_uf = cidade_uf;
    }
    
    
    
    
}
