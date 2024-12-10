/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felipe Ferreira, Carlos Eduardo, Caua Alvarenga, Heitor Messias
 * @since 08/12/2024 at 20:55
 * @see Entidade
 */
public class Cidade extends Entidade {
    
    private String nome;
    private String uf;

    public Cidade(int id,String nome, String uf ) {
        super(id, nome, "");
        this.nome = nome;
        this.uf = uf;
    }

   

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }
    /**
     * Metodo para inserier dados na tabela cidade
     * @throws SQLException 
     */
    public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO cidade (cidade_uf, cidade_nome) Values (?, ?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, this.uf);
            stmt.setString(2,this.nome);
            stmt.setInt(3, Cidade.super.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela cidade! " + e.getMessage());
            
        }
        
    }
    /**
     * Metodo para remover os dados da tabela cidade 
     */
    
    public void remover(){

        String sql = "DELETE FROM cidade WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, Cidade.super.getId());
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela cidade" + e.getMessage());
            
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
     * Metodo para alterar os dados da tabela cidade 
     */
    public  void alterar(){
        
        String sql = "UPDATE cidade Set cidade_uf = ?, cidade_nome = ?" + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1,this.uf);
            pstm.setString(2, this.nome);
            pstm.setInt(3, Cidade.super.getId());
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela cidade " + e.getMessage());
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
     * Metodo para listar todos os dados que estao inserido na tabela cidade
     */
    
    public void listar(){
        
        String sql = "SELECT * FROM cidade";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println(rset.getInt("cidade_id"));
                System.out.println(rset.getString("cidade_uf"));
                System.out.println(rset.getString("cidade_nome"));
                System.out.println("======================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela cidade " + e.getMessage());
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
