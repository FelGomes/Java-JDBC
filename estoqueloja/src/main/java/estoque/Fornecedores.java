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
    
    private String nomeFantasia;
    private String cnpj;
    
    public Fornecedores(String nome) {
        super(nome, "","","");
        
    }

    public Fornecedores(String nome, String telefone, String nomeFantasia, String cnpj, String cidade_nome, String cidade_uf) {
        super(nome, telefone, cidade_nome, cidade_uf);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
    
   
    public String getRazaoSocial() {
        return nomeFantasia;
    }

    public void setnomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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
        String sql = "INSERT INTO fornecedores (fornecedores_nome, fornecedores_telefone, fornecedores_nomeFantasia, fornecedores_cnpj, fornecedores_cidade, fornecedores_uf) Values (?, ?, ?, ?,?,?)";
        
        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,Fornecedores.super.getNome());
            stmt.setString(2, Fornecedores.super.getTelefone());
            stmt.setString(3, this.nomeFantasia);
            stmt.setString(4, this.getCnpj());
            stmt.setString(5, Fornecedores.super.getCidade_nome());
            stmt.setString(6, Fornecedores.super.getCidade_uf());
            //stmt.setInt(5, Fornecedores.super.getId());
            
            stmt.execute();
            stmt.close();
            
            conexao.close();
            
        } catch (SQLException e){
            System.out.println("Erro ao inserir dados a tabela fornecedores! " + e.getMessage());
            
        }
        
    }
    
    /**
     * Metodo para remover os dados da tabela fornecedores ao escolher o ID
     * @param idSelecionado
     */

    public void remover(int idSelecionado){

        String sql = "DELETE FROM fornecedores WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
             Connection conexao = new Conexao().getConexao();
             
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, idSelecionado);
             
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
     * 
     * Metodo para alterar os dados da tabela fornecedores, atributos: nome, telefone, razaoSocial e cnpj, nome da cidade e sigla do estado
     * @param idSelecionado
     */
    
    public  void alterar(int idSelecionado){
        
        String sql = "UPDATE fornecedores Set fornecedores_nome = ?, fornecedores_telefone = ?, fornecedores_nomeFantasia = ?, fornecedores_cnpj = ?, fornecedores_cidade = ?, fornecedores_uf = ?" + " WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            Connection conexao = new Conexao().getConexao();
            
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, Fornecedores.super.getNome());
            pstm.setString(2, Fornecedores.super.getTelefone());
            pstm.setString(3, this.nomeFantasia);
            pstm.setString(4, this.cnpj);
            pstm.setString(5, Fornecedores.super.getCidade_nome());
            pstm.setString(6, Fornecedores.super.getCidade_uf());
            pstm.setInt(7, idSelecionado);
            
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
                System.out.println("ID: " +rset.getInt("fornecedores_id"));
                System.out.println("Nome: " +rset.getString("fornecedores_nome"));
                System.out.println("Telefone: " +rset.getString("fornecedores_telefone"));
                System.out.println("Nome Fantasia: " +rset.getString("fornecedores_nomeFantasia"));
                System.out.println("CNPJ: " +rset.getString("fornecedores_cnpj"));
                System.out.println("Cidade: "+ rset.getString("fornecedores_cidade"));
                System.out.println("Uf: " + rset.getString("fornecedores_uf"));
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


