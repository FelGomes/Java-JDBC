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

public class Vendas extends Entidade {
    
    private String data;
    private int quantidade;
    
    public Vendas (String data, int quantidade){
        super("","");
        this.data = data;
        this.quantidade = quantidade;
       
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
        String sql = "INSERT INTO vendas (vendas_quantidade, data_venda) VALUES (?,?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, this.quantidade);
            stmt.setString(2, this.data);
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
     */

    public void remover(){

        String sql = "DELETE FROM vendas WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, Vendas.super.getId());
             
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
                System.out.println(rset.getInt("vendas_id"));
                System.out.println(rset.getInt("vendas_quantidade"));
                System.out.println(rset.getString("data_venda"));
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
