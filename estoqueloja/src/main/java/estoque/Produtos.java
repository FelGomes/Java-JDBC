package estoque;

public class Produtos extends Entidade {
    
    private float preco;
    private String marca;
    private int quantidade;

    public Produtos(int id, String nome, float preco, String marca, int quantidade) {
        super(id, nome, "");
        this.preco = preco;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString(){
        return "Dados: " + getId() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Preco: " + this.preco + "\n"
                + "Marca: " + this.marca + "\n"
                + "Quantidade: " + this.quantidade + "\n"
                + "====================================";
    }
    
    
}
