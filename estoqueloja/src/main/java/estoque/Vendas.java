package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe Vendas
 * @author felipe ferreira gomes
 * @since 15/12/2024 at 15:54
 */

public class Vendas  {
    
    private String data;
    private int quantidade;
    private int id_vendas;
    private int id_usuario;
    private int id_produtos;
    public Vendas (){
    }
    public Vendas (int quantidade, String data, int id_usuario, int id_produtos){
        this.data = data;
        this.quantidade = quantidade; 
        this.id_produtos = id_produtos;
        this.id_usuario = id_usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * METODO PARA INSERIR A QUANTIDADE DE VENDAS E A DATA DA VENDA
     * @throws SQLException 
     */
     public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO vendas (vendas_quantidade, data_venda, usuarios_id, produtos_id) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, this.quantidade);
            stmt.setString(2, this.data);
            stmt.setInt(3, this.id_usuario);
            stmt.setInt(4, this.id_produtos);
            //stmt.setInt(3, Vendas.super.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela vendas " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela vendas ao escolher o ID
     * @param id_selecionado
     */

    public void remover(int id_selecionado){

        String sql = "DELETE FROM vendas WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, this.id_vendas);
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela vendas" + e.getMessage());
            
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
     * Metodo para alterar os dados da tabela vendas - QUANTIDADE E DATA DA VENDA
     */
    
    public  void alterar(){
        
        String sql = "UPDATE venda Set venda_quantidade = ?, data_venda = ? " + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, this.quantidade);
            pstm.setString(2, this.data);
            //pstm.setInt(3, Vendas.super.getId());
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela vendas! " + e.getMessage());
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
     * Metodo para listar todos os atributos da tabela venda
     */
   
     public void listar(){
        
        String sql = "SELECT * FROM vendas";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println("ID: "+rset.getInt("vendas_id"));
                System.out.println("Quantidade vendida: "+ rset.getInt("vendas_quantidade"));
                System.out.println("Horario de venda: " +rset.getString("data_venda"));
                System.out.println("ID do usuario: " + rset.getString("usuarios_id"));
                System.out.println("ID do produto: "+rset.getString("produtos_id"));
                System.out.println("=============================================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela vendas " + e.getMessage());
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
    
    
}
