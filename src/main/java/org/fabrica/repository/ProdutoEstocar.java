package org.fabrica.repository;

import org.fabrica.config.DatabaseConnection;
import org.fabrica.entity.CorProduto;
import org.fabrica.entity.Produto;
import org.fabrica.entity.TipoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoEstocar {

    public void salvar(Produto produto) {

        String sql = "INSERT INTO produto(nome, tipo, cor) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo().name());
            stmt.setString(3, produto.getCor().name());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Produto> listarTodos() {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        TipoProduto.valueOf(rs.getString("tipo")),
                        CorProduto.valueOf(rs.getString("cor"))
                );

                produtos.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

}
