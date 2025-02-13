package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe Produtos
 * @author felipe Ferreira Gomes
 * @since 15/12/2024 at 15:!2
 */

public class Produtos extends Entidade {
    
    private float preco;
    private String marca;
    private int quantidade;
    
    public Produtos(String nome){
        super(nome, "","","");
    }

    public Produtos(String nome, float preco, String marca, int quantidade) {
        super(nome, "","","");
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
    
    public void getId(int id){
        Produtos.super.getId();
    }
    
    
    /**
     * Metodos para inserir valores na tabela produtos - Atributos: Nome, preco, marcas e quantidade
     * @throws SQLException 
     */
    
    
    
     public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO produtos (produtos_nome, produtos_preco, produtos_marcas, produtos_qtd) Values (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Produtos.super.getNome());
            stmt.setFloat(2, this.preco);
            stmt.setString(3, this.marca);
            stmt.setInt(4, this.quantidade);
            //stmt.setInt(5, Produtos.super.getId());
          
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
            System.out.println("Produto inserido com sucesso no banco de dados!");
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela produtos " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela produtos ao escolher o ID
     * @param idSelecionado
     */

    public void remover(int idSelecionado){

        String sql = "DELETE FROM produtos WHERE produtos_id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, idSelecionado);
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela produtos" + e.getMessage());
            
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Metodo para alterar os dados da tabela produtos - nome, preco, marcas e quantidade de produtos
     * @param idSelecionado
     */
    
    public  void alterar(int idSelecionado){
        
        String sql = "UPDATE produtos Set produtos_nome = ?, produtos_preco = ?, produtos_marcas = ?, produtos_qtd =  ?" + " WHERE produtos_id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, Produtos.super.getNome());
            pstm.setFloat(2, this.preco);
            pstm.setString(3, this.marca);
            pstm.setInt(4, this.quantidade);
            pstm.setInt(5, idSelecionado);
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela Produtos! " + e.getMessage());
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
    }
    
    /**
     * Metodo para listar todos os atributos da tabela Produtos
     */
   
     public void listar(){
        
        String sql = "SELECT * FROM produtos";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println("=============================================");
                System.out.println("ID: " +rset.getInt("produtos_id"));
                System.out.println("Nome: " +rset.getString("produtos_nome"));
                System.out.println("Valor: " +rset.getFloat("produtos_preco"));
                System.out.println("Marca: " +rset.getString("produtos_marcas"));
                System.out.println("Qunatidade: " +rset.getInt("produtos_qtd"));
                System.out.println("=============================================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela produtos " + e.getMessage());
        } finally {
            
            try {
                if (rset != null){
                    rset.close();
                    
                }
                if (pstm != null){
                    pstm.close();
                }
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Metodo para verificar se o id do produto existe
     * @param idProduto
     * @return 
     */
    public static boolean verificarProduto(int idProduto) {
        boolean existe = false;
        try (Connection conexao = new Conexao().getConexao();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM produtos WHERE produtos_id = ?")) {
            comando.setInt(1, idProduto);
        try (ResultSet resultado = comando.executeQuery()) {
            existe = resultado.next();
        }
        } catch (SQLException e) {
            System.out.println("Erro na tabela de produtos: " + e.getMessage());
        }
        return existe;
    }
    
    public  void alterarQtd(int idSelecionado, int vendaQtd){
        
        String sql = "UPDATE produtos Set produtos_qtd =  produtos_qtd - ?" + " WHERE produtos_id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, vendaQtd);
            pstm.setInt(2, idSelecionado);
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela Produtos! " + e.getMessage());
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
    }
      
      

     
    
} 
    
    

