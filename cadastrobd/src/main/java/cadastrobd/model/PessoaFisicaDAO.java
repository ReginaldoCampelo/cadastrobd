/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastrobd.model.util.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author regin
 */
public class PessoaFisicaDAO {

    public PessoaFisica getPessoa(int id) throws SQLException {
        String sql = "SELECT * FROM PessoaFisica WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        PessoaFisica pessoaFisica = null;
        if (rs.next()) {
            pessoaFisica = new PessoaFisica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf")
            );
        }

        ConectorBD.close(rs);
        ConectorBD.close(stmt);
        ConectorBD.close(conn);

        return pessoaFisica;
    }

    public List<PessoaFisica> getPessoas() throws SQLException {
        String sql = "SELECT * FROM PessoaFisica";
        Connection conn = ConectorBD.getConnection();
        ResultSet rs = ConectorBD.getSelect(sql, conn);
        List<PessoaFisica> pessoas = new ArrayList<>();

        while (rs.next()) {
            PessoaFisica pessoaFisica = new PessoaFisica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cpf")
            );
            pessoas.add(pessoaFisica);
        }

        ConectorBD.close(rs);
        ConectorBD.close(conn);

        return pessoas;
    }

    public void incluir(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "INSERT INTO PessoaFisica (id, nome, logradouro, cidade, estado, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);

        stmt.setInt(1, pessoaFisica.getId());
        stmt.setString(2, pessoaFisica.getNome());
        stmt.setString(3, pessoaFisica.getLogradouro());
        stmt.setString(4, pessoaFisica.getCidade());
        stmt.setString(5, pessoaFisica.getEstado());
        stmt.setString(6, pessoaFisica.getTelefone());
        stmt.setString(7, pessoaFisica.getEmail());
        stmt.setString(8, pessoaFisica.getCpf());

        stmt.executeUpdate();
        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }

    public void alterar(PessoaFisica pessoaFisica) throws SQLException {
        String sql = "UPDATE PessoaFisica SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cpf = ? WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);

        stmt.setString(1, pessoaFisica.getNome());
        stmt.setString(2, pessoaFisica.getLogradouro());
        stmt.setString(3, pessoaFisica.getCidade());
        stmt.setString(4, pessoaFisica.getEstado());
        stmt.setString(5, pessoaFisica.getTelefone());
        stmt.setString(6, pessoaFisica.getEmail());
        stmt.setString(7, pessoaFisica.getCpf());
        stmt.setInt(8, pessoaFisica.getId());

        stmt.executeUpdate();
        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM PessoaFisica WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }
}
