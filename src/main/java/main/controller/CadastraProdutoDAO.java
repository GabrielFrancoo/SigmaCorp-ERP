package main.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.model.Conexao;
import main.model.Produto;

public class CadastraProdutoDAO {

    public void salvar(String produto, String descricao, String nomeCientifico,
                       String armazem, double custoUnitario, String tipo) {
        String sql = "INSERT INTO CadastraProduto "
                   + "(produto, descricao, nomeCientifico, armazem, custoUnitario, tipo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto);
            stmt.setString(2, descricao);
            stmt.setString(3, nomeCientifico);
            stmt.setString(4, armazem);
            stmt.setDouble(5, custoUnitario);
            stmt.setString(6, tipo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar o produto: " + ex.getMessage(), ex);
        }
    }

    public List<Produto> listar() {
        String sql = "SELECT id, produto, descricao, nomeCientifico, armazem, "
                   + "custoUnitario, tipo FROM CadastraProduto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {
            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setProduto(resultado.getString("produto"));
                produto.setDescricao(resultado.getString("descricao"));
                produto.setNomeCientifico(resultado.getString("nomeCientifico"));
                produto.setArmazem(resultado.getString("armazem"));
                produto.setCustoUnitario(resultado.getDouble("custoUnitario"));
                produto.setTipo(resultado.getString("tipo"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os produtos: " + ex.getMessage(), ex);
        }

        return produtos;
    }

    public void atualizar(int id, String produto, String descricao, String nomeCientifico,
                          String armazem, double custoUnitario, String tipo) {
        String sql = "UPDATE CadastraProduto SET "
                   + "produto = ?, descricao = ?, nomeCientifico = ?, "
                   + "armazem = ?, custoUnitario = ?, tipo = ? "
                   + "WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto);
            stmt.setString(2, descricao);
            stmt.setString(3, nomeCientifico);
            stmt.setString(4, armazem);
            stmt.setDouble(5, custoUnitario);
            stmt.setString(6, tipo);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o produto: " + ex.getMessage(), ex);
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM CadastraProduto WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir o produto: " + ex.getMessage(), ex);
        }
    }
}