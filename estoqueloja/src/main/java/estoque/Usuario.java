package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe Usuario
 * @author felipe ferreira gomes
 * @since 15/12/24 at 15:37
 */

public class Usuario extends Entidade{
    private String sexo;
    private String cpf;
    private int idade;
    
    public Usuario(int id, String nome, String sexo, String telefone, String cpf, int idade){
        super(id, nome, telefone);
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Metodo para inserir dados para Usuario - NOME, SEXO, TELEFONE, CPF e IDADE
     * @throws SQLException 
     */
    
     public void inserir() throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO usuarios (usuarios_nome, usuarios_sexo, usuarios_telefone, usuarios_cpf, usuarios_idade) Values (?, ?, ?, ?,?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Usuario.super.getNome());
            stmt.setString(2, this.sexo);
            stmt.setString(3, Usuario.super.getTelefone());
            stmt.setString(4, this.cpf);
            stmt.setInt(5, this.idade);
            stmt.setInt(6, Usuario.super.getId());
          
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela usuarios " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela usuarios ao escolher o ID
     */

    public void remover(){

        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, Usuario.super.getId());
             
             pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao deletar os dados da tabela usuarios" + e.getMessage());
            
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
     * Metodo para alterar os dados da tabela usuarios - NOME, SEXO, TELEFONE, CPF e IDADE
     */
    
    public  void alterar(){
        
        String sql = "UPDATE usuarios Set usuarios_nome = ?, usuarios_sexo = ?, usuarios_telefone = ?, usuarios_cpf = ?, usuarios_idade" + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, Usuario.super.getNome());
            pstm.setString(2, this.sexo);
            pstm.setString(3, Usuario.super.getTelefone());
            pstm.setString(4, this.cpf);
            pstm.setInt(5, this.idade);
            pstm.setInt(6, Usuario.super.getId());
            
            
            pstm.execute();
            
        } catch (SQLException e){
            System.out.println("Erro ao alterar os dados da tabela usuarios " + e.getMessage());
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
     * Metodo para listar todos os atributos da tabela Usuarios
     */
   
     public void listar(){
        
        String sql = "SELECT * FROM usuarios";
        
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                System.out.println(rset.getInt("usuarios_id"));
                System.out.println(rset.getString("usuarios_nome"));
                System.out.println(rset.getString("usuarios_sexo"));
                System.out.println(rset.getString("usuarios_telefone"));
                System.out.println(rset.getInt("usuarios_cpf"));
                System.out.println(rset.getInt("usuarios_idade"));
                System.out.println("=============================================");
            }
        } catch(SQLException e){
            System.out.println("Erro ao listar os dados da tabela usuarios " + e.getMessage());
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
