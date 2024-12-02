package estoque;
public class Cidade extends Entidade{
    
    private char[] uf = new char[2];
    
    public Cidade(int id, String nome, char[] uf){
        super(id, nome, "");
        this.uf = uf;
    }

    public char[] getUf() {
        return uf;
    }

    public void setUf(char[] uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString(){
        return "Dados: " + getId() + "\n"
                + "Nome: " + getNome() + "\n"
                + "UF: " + this.uf + "\n"
                + "======================";
    }
}
