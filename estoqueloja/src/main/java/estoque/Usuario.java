package estoque;

public class Usuario extends Entidade{
    private char[] sexo = new char[1];
    private String cpf;
    
    public Usuario(int id, String nome, char[] sexo, String telefone, String cpf){
        super(id, nome, telefone);
        this.sexo = sexo;
        this.cpf = cpf;
        
    }

    public char[] getSexo() {
        return sexo;
    }

    public void setSexo(char[] sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return "Dados: " + getId() + "\n"
                + "Nome: " + getNome() +"\n"
                + "Telefone: " +getTelefone() +"\n"
                + "==============================";
    }
}
