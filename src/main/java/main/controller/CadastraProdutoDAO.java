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
        public List<Produto> listar(){
        List<Produto> lista = new ArrayList<>();

        String sql =  "SELECT * FROM CadastraProduto";
        
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setProduto(rs.getString("produto"));
                p.setDescricao(rs.getString("descricao"));
                p.setNomeCientifico(rs.getString("nomeCIentifico"));
                p.setArmazem(rs.getString("armazem"));
                p.setCustoUnitario(rs.getDouble("custoUnitario"));
                p.setTipo(rs.getString("tipo"));

                lista.add(p);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
        }
}
