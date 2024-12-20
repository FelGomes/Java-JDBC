package estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author felipe Ferreira
 * @since 10/12/2024 at 15:33
 * @see Entidade
 */

public class Endereco extends Entidade {

    private String rua;
    private String bairro;
    private String cep;
    private String numero;

    public Endereco(String rua, String bairro, String cep, String numero) {
        super("", "");
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;

    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Metodo de inserir dados na classe Endereço
     *
     *
     * @throws java.sql.SQLException
     */
    public void inserir() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "INSERT INTO endereco (endereco_rua, endereco_bairro, endereco_cep, endereco_numero) Values (?, ?, ?, ?)";

        try {
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, this.rua);
            stmt.setString(2, this.bairro);
            stmt.setString(3, this.cep);
            stmt.setString(4, this.numero);
            //stmt.setInt(5, Endereco.super.getId());

            stmt.execute();
            stmt.close();

            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados a tabela Endereco! " + e.getMessage());

        }

    }

    /**
     * Metodo para remover todos os daods da tabela endereco quando especificar
     * o ID
     */
    public void remover(int idSelecionado) {

        String sql = "DELETE FROM cidade WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            Connection conexao = new Conexao().getConexao();

            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idSelecionado);

            pstm.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar os dados da tabela Endereco" + e.getMessage());

        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Metodo para alterar os dados da tabela endereco Pode ser alterado a rua,
     * o bairro, o cep e a numeração ao escolher o ID
     */
    public void alterar() {

        String sql = "UPDATE endereco Set endereco_rua  = ?, endereco_bairro = ?, endereco_cep = ?, endereco_numero = ?" + " WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            Connection conexao = new Conexao().getConexao();

            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, this.rua);
            pstm.setString(2, this.bairro);
            pstm.setString(3, this.cep);
            pstm.setString(4, this.numero);
            //pstm.setInt(5, Endereco.super.getId());

            pstm.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao alterar os dados da tabela Endereco " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Metodo par listar todos os dados da tabela endereco ao utilizar o SELECT * FROM endereco;
     */
    public void listar() {

        String sql = "SELECT * FROM endereco";

        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            Connection conexao = new Conexao().getConexao();

            pstm = conexao.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                System.out.println("Id: "+ rset.getInt("endereco_id"));
                System.out.println("Rua: "+ rset.getString("endereco_rua"));
                System.out.println("Bairro: "+ rset.getString("endereco_bairro"));
                System.out.println("CEP: "+ rset.getString("endereco_cep"));
                System.out.println("Numero: " +rset.getString("endereco_numero"));
                System.out.println("====================================");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os dados da tabela endereco " + e.getMessage());
        } finally {

            try {
                if (rset != null) {
                    rset.close();

                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
