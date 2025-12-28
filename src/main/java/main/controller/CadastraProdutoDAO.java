package main.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.model.Conexao;

public class CadastraProdutoDAO {

    public void salvar(String produto,
                       String descricao,
                       String nomeCientifico,
                       String armazem,
                       double custoUnitario,
                       String tipo) {

        String sql = "INSERT INTO CadastraProduto " +
                     "(produto, descricao, nomeCientifico, armazem, custoUnitario, tipo) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto);
            stmt.setString(2, descricao);
            stmt.setString(3, nomeCientifico);
            stmt.setString(4, armazem);
            stmt.setDouble(5, custoUnitario);
            stmt.setString(6, tipo);

            stmt.executeUpdate();
            System.out.println("Produto salvo com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
