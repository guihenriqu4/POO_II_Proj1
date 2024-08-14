package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Estacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstacaoDAO implements iEstacaoDAO{
    @Override
    public Estacao save(Estacao estacao) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO estacao (nome) values (?)";
            assert connection != null;
            PreparedStatement psEstacao = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psEstacao.setString(1, estacao.getNome());
            psEstacao.executeUpdate();

            ResultSet rsColab = psEstacao.getGeneratedKeys();
            if (rsColab.next()) {
                estacao.setId(rsColab.getInt("id"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return estacao;
    }
    @Override
    public Estacao update(Estacao estacao) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPTDATE estacao SET nome = ? WHERE id = ?";
            assert connection != null;
            PreparedStatement psEstacao = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psEstacao.setString(1, estacao.getNome());
            psEstacao.setInt(7, estacao.getId());
            psEstacao.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return estacao;
    }
    @Override
    public void deleteEstacao(int id) {
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM estacao WHERE id = ?";
            assert connection != null;
            PreparedStatement psEstacao = connection.prepareStatement(sql);
            psEstacao.setInt(1, id);
            psEstacao.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Estacao> findById(int id) {
        String sql = "SELECT * FROM estacao where id = ?";
        Estacao estacao = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsEstacao = preparedStatement.executeQuery();
            while (rsEstacao.next()) {
                estacao = new Estacao();
                estacao.setId(rsEstacao.getInt("id"));
                estacao.setNome(rsEstacao.getString("nome"));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(estacao);
    }

    @Override
    public List<Estacao> findAll() {
        List<Estacao> estacoes = new ArrayList<>();
        String sql = "SELECT * FROM estacao";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsEstacao = preparedStatement.executeQuery();
            while (rsEstacao.next()) {
                Estacao estacao = new Estacao();
                estacao.setId(rsEstacao.getInt("id"));
                estacao.setNome(rsEstacao.getString("nome"));
                estacoes.add(estacao);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return estacoes;
    }
}
