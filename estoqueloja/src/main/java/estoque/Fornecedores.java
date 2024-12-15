package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CLasse Produtos
 * @author Felipe Ferreira Gomes
 * 15/12/2024 at 15:09
 */

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
    
    /**
     * Metodo de inserir dados na tabela fornecedores - possuindo atributos como (Nome, telefone, razaoSocial e CNPJ)
     * @throws SQLException 
     */
     public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO fornecedores (fornecedores_nome, fornecedores_telefone, fornecedores_razaoSocial, fornecedores_cnpj) Values (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,Fornecedores.super.getNome());
            stmt.setString(2, Fornecedores.super.getTelefone());
            stmt.setString(3, this.getRazaoSocial());
            stmt.setString(4, this.getCnpj());
            stmt.setInt(5, Fornecedores.super.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela fornecedores! " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela fornecedores ao escolher o ID
     */

    public void remover(){

        String sql = "DELETE FROM fornecedores WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, Fornecedores.super.getId());
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela fornecedores" + e.getMessage());
            
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
     * Metodo para alterar os dados da tabela fornecedores, atributos: nome, telefone, razaoSocial e cnpj
     */
    
    public  void alterar(){
        
        String sql = "UPDATE fornecedores Set fornecedores_nome = ?, fornecedores_telefone = ?, fornecedores_razaoSocial = ?, fornecedores_cnpj = ?" + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, Fornecedores.super.getNome());
            pstm.setString(2, Fornecedores.super.getTelefone());
            pstm.setString(3, this.razaoSocial);
            pstm.setString(4, this.cnpj);
            pstm.setInt(5, Fornecedores.super.getId());
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela fornecedores " + e.getMessage());
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
     * Metodo para listar todos os atributos da tabela fornecedores 
     */
   
     public void listar(){
        
        String sql = "SELECT * FROM fornecedores";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println(rset.getInt("fornecedores_id"));
                System.out.println(rset.getString("fornecedores_nome"));
                System.out.println(rset.getString("fornecedores_telefone"));
                System.out.println(rset.getString("fornecedores_razaoSocial"));
                System.out.println(rset.getString("fornecedores_cnpj"));
                System.out.println("=============================================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela fornecedores " + e.getMessage());
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


