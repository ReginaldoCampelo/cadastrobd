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
public class PessoaJuridicaDAO {

    public PessoaJuridica getPessoa(int id) throws SQLException {
        String sql = "SELECT * FROM PessoaJuridica WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        PessoaJuridica pessoaJuridica = null;
        if (rs.next()) {
            pessoaJuridica = new PessoaJuridica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cnpj")
            );
        }

        ConectorBD.close(rs);
        ConectorBD.close(stmt);
        ConectorBD.close(conn);

        return pessoaJuridica;
    }

    public List<PessoaJuridica> getPessoas() throws SQLException {
        String sql = "SELECT * FROM PessoaJuridica";
        Connection conn = ConectorBD.getConnection();
        ResultSet rs = ConectorBD.getSelect(sql, conn);
        List<PessoaJuridica> pessoas = new ArrayList<>();

        while (rs.next()) {
            PessoaJuridica pessoaJuridica = new PessoaJuridica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cnpj")
            );
            pessoas.add(pessoaJuridica);
        }

        ConectorBD.close(rs);
        ConectorBD.close(conn);

        return pessoas;
    }

    public void incluir(PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "INSERT INTO PessoaJuridica (id, nome, logradouro, cidade, estado, telefone, email, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);

        stmt.setInt(1, pessoaJuridica.getId());
        stmt.setString(2, pessoaJuridica.getNome());
        stmt.setString(3, pessoaJuridica.getLogradouro());
        stmt.setString(4, pessoaJuridica.getCidade());
        stmt.setString(5, pessoaJuridica.getEstado());
        stmt.setString(6, pessoaJuridica.getTelefone());
        stmt.setString(7, pessoaJuridica.getEmail());
        stmt.setString(8, pessoaJuridica.getCnpj());

        stmt.executeUpdate();
        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }

    public void alterar(PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "UPDATE PessoaJuridica SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cnpj = ? WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);

        stmt.setString(1, pessoaJuridica.getNome());
        stmt.setString(2, pessoaJuridica.getLogradouro());
        stmt.setString(3, pessoaJuridica.getCidade());
        stmt.setString(4, pessoaJuridica.getEstado());
        stmt.setString(5, pessoaJuridica.getTelefone());
        stmt.setString(6, pessoaJuridica.getEmail());
        stmt.setString(7, pessoaJuridica.getCnpj());
        stmt.setInt(8, pessoaJuridica.getId());

        stmt.executeUpdate();
        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM PessoaJuridica WHERE id = ?";
        Connection conn = ConectorBD.getConnection();
        PreparedStatement stmt = ConectorBD.getPreparedStatement(sql, conn);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        ConectorBD.close(stmt);
        ConectorBD.close(conn);
    }
}
