package estoque;

public class Endereco extends Entidade{
    
    private String rua;
    private String bairro;
    private String cep;
    private String numero;
    
    public Endereco (int id, String rua, String bairro, String cep, String numero){
        super(id, "", "");
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
       
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
