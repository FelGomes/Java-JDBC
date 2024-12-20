package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author felipe Ferreira
 * @since 10/12/2024 at 15:32
 * @see Entidade
 */

public class Estabelecimento extends Entidade{
    
    private String email;
    private String cnpj;
    
    public Estabelecimento(String nome){
       super(nome,""); 
    }
    
    public Estabelecimento(String nome, String telefone, String email, String cnpj){
       super(nome,telefone); 
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
    
    /**
     * Metodo para inserir valores na tabela estabelecimento, possuindo o atributo: nome, telefone, email e cnpj
     * @throws SQLException 
     */
    
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO estabelecimento (estabelecimento_nome, estabelecimento_telefone, estabelecimento_email, estabelecimento_cnpj) Values (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Estabelecimento.super.getNome());
            stmt.setString(2, Estabelecimento.super.getTelefone());
            stmt.setString(3, this.email);
            stmt.setString (4, this.cnpj);
            //stmt.setInt(4, Estabelecimento.super.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            System.out.println("Estabelecimento inserido no banco de dados com sucesso");
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela estabelecimento! " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela estabelecimento ao escolher o ID
     */

    public void remover(){

        String sql = "DELETE FROM estabelecimento WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, Estabelecimento.super.getId());
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela estabelecimento" + e.getMessage());
            
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
     * Metodo para alterar os dados da tabela estabelecimento, atributos: nome, telefone, email e cnpj
     */
    
    public  void alterar(){
        
        String sql = "UPDATE estabelecimento Set estabelecimento_nome = ?, estabelecimento_telefone = ?, estabelecimento_email = ?, estabelecimento_cnpj = ?" + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, Estabelecimento.super.getNome());
            pstm.setString(2, Estabelecimento.super.getTelefone());
            pstm.setString(3, this.email);
            pstm.setString(4, this.cnpj);
            //pstm.setInt(5, Estabelecimento.super.getId());
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela estabelecimento " + e.getMessage());
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
     * Metodo para listar todos os atributos da tabela estabelecimento, nome, telefone, email e cnpj
     */
   
     public void listar(){
        
        String sql = "SELECT * FROM estabelecimento";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println("ID: "+ rset.getInt("estabelecimento_id"));
                System.out.println("Nome: "+ rset.getString("estabelecimento_nome"));
                System.out.println("Telefone: "+ rset.getString("estabelecimento_telefone"));
                System.out.println("Email: " +rset.getString("estabelecimento_email"));
                System.out.println("CNPJ: " +rset.getString("estabelecimento_cnpj"));
                System.out.println("=============================================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela estabelecimento " + e.getMessage());
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
