/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author felipe Ferreira, Carlos Eduardo, Caua Alvarenga, Heitor Messias
 * @since 08/12/2024 at 20:55
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
            stmt.setInt(3, Cidade.this.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela cidade! " + e.getMessage());
            
        }
        
    }
    
    
}
