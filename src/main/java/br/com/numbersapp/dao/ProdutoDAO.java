package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO implements iProdutoDAO{
    @Override
    public Produto save(Produto produto) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO produto (nome, marca, descricao, quantidade) values (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psProd = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psProd.setString(1, produto.getNome());
            psProd.setString(2, produto.getMarca());
            psProd.setString(3, produto.getDescricao());
            psProd.setDouble(4, produto.getQuantidade());
            psProd.executeUpdate();

            ResultSet rsProd = psProd.getGeneratedKeys();
            if (rsProd.next()) {
                produto.setId(rsProd.getLong("id"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produto;
    }

    @Override
    public Produto update(Produto produto) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPTDATE produto SET nome = ?, marca = ?, descricao = ?, quantidade = ? WHERE id = ?";
            assert connection != null;
            PreparedStatement psProd = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psProd.setString(1, produto.getNome());
            psProd.setString(2, produto.getMarca());
            psProd.setString(3, produto.getDescricao());
            psProd.setDouble(4, produto.getQuantidade());
            psProd.setLong(5, produto.getId());
            psProd.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produto;
    }

    @Override
    public void deleteProduto(Long id) {
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM produto WHERE id = ?";
            assert connection != null;
            PreparedStatement psProd = connection.prepareStatement(sql);
            psProd.setLong(1, id);
            psProd.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Produto> findById(Long id) {
        String sql = "SELECT * FROM produto where id = ?";
        Produto prod = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                prod = new Produto();
                prod.setId(rsColab.getLong("id"));
                prod.setNome(rsColab.getString("nome"));
                prod.setMarca(rsColab.getString("marca"));
                prod.setDescricao(rsColab.getString("descricao"));
                prod.setQuantidade(Double.parseDouble(rsColab.getString("quantidade")));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(prod);
    }

    @Override
    public Optional<Produto> findByNome(String nome) {
        String sql = "SELECT * FROM produto where nome = ?";
        Produto prod = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rsProd = preparedStatement.executeQuery();
            while (rsProd.next()) {
                prod = new Produto();
                prod.setId(rsProd.getLong("id"));
                prod.setNome(rsProd.getString("nome"));
                prod.setMarca(rsProd.getString("marca"));
                prod.setDescricao(rsProd.getString("descricao"));
                prod.setQuantidade(Double.parseDouble(rsProd.getString("quantidade")));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(prod);
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                Produto prod = new Produto();
                prod.setId(rsColab.getLong("id"));
                prod.setNome(rsColab.getString("nome"));
                prod.setMarca(rsColab.getString("marca"));
                prod.setDescricao(rsColab.getString("descricao"));
                prod.setQuantidade(Double.parseDouble(rsColab.getString("quantidade")));
                produtos.add(prod);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return produtos;
    }
}