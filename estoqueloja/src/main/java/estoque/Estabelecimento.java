package estoque;
public class Estabelecimento extends Entidade{
    
    private String email;
    private String cnpj;
    
    public Estabelecimento(int id, String nome, String telefone, String email, String cpnj){
       super(id,nome,telefone); 
       this.cnpj = cnpj;
       this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    
    @Override
    public String toString(){
        return "Dados: " + getId() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Telefone: " +getTelefone() + "\n"
                + "CNPJ: " + this.cnpj + "\n"
                + "===============================";
    }
    
}
