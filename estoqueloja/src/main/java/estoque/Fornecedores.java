package estoque;

public class Fornecedores extends Entidade {
    
    private String razaoSocial;
    private String cnpj;

    public Fornecedores( int id, String nome, String telefone, String razaoSocial, String cnpj) {
        super(id, nome, telefone);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }
    
   
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


}
