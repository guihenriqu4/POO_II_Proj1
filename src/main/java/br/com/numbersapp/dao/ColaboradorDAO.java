package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Colaborador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ColaboradorDAO implements iColaboradorDAO {
    @Override
    public Colaborador save(Colaborador colaborador) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO colaborador (nome, sobrenome, tel, email, funcao, dataintegracao) values (?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psColab.setString(1, colaborador.getNome());
            psColab.setString(2, colaborador.getSobrenome());
            psColab.setString(3, colaborador.getTel());
            psColab.setString(4, colaborador.getEmail());
            psColab.setString(5, colaborador.getFuncao());
            psColab.setDate(6, java.sql.Date.valueOf(colaborador.getDataintegracao()));
            psColab.executeUpdate();

            ResultSet rsColab = psColab.getGeneratedKeys();
            if (rsColab.next()) {
                colaborador.setId(rsColab.getInt("id"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return colaborador;
    }
    @Override
    public Colaborador update(Colaborador colaborador) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPTDATE colaborador SET nome = ?, sobrenome = ?, tel = ?, email = ?, funcao = ?, dataintegracao = ? WHERE id = ?";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psColab.setString(1, colaborador.getNome());
            psColab.setString(2, colaborador.getSobrenome());
            psColab.setString(3, colaborador.getTel());
            psColab.setString(4, colaborador.getEmail());
            psColab.setString(5, colaborador.getFuncao());
            psColab.setDate(6, java.sql.Date.valueOf(colaborador.getDataintegracao()));
            psColab.setInt(7, colaborador.getId());
            psColab.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return colaborador;
    }
    @Override
    public void deleteColaborador(int id) {
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM colaborador WHERE id = ?";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql);
            psColab.setInt(1, id);
            psColab.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Colaborador> findById(int id) {
        String sql = "SELECT * FROM colaborador where id = ?";
        Colaborador colab = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                colab = new Colaborador();
                colab.setId(rsColab.getInt("id"));
                colab.setNome(rsColab.getString("nome"));
                colab.setSobrenome(rsColab.getString("sobrenome"));
                colab.setTel(rsColab.getString("tel"));
                colab.setEmail(rsColab.getString("email"));
                colab.setFuncao(rsColab.getString("funcao"));
                colab.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(colab);
    }
    @Override
    public Optional<Colaborador> findByTel(String tel) {
        String sql = "SELECT * FROM colaborador where tel = ?";
        Colaborador colab = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tel);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                colab = new Colaborador();
                colab.setId(rsColab.getInt("id"));
                colab.setNome(rsColab.getString("nome"));
                colab.setSobrenome(rsColab.getString("sobrenome"));
                colab.setTel(rsColab.getString("tel"));
                colab.setEmail(rsColab.getString("email"));
                colab.setFuncao(rsColab.getString("funcao"));
                colab.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(colab);
    }
    @Override
    public Optional<Colaborador> findByEmail(String email) {
        String sql = "SELECT * FROM colaborador where email = ?";
        Colaborador colab = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                colab = new Colaborador();
                colab.setId(rsColab.getInt("id"));
                colab.setNome(rsColab.getString("nome"));
                colab.setSobrenome(rsColab.getString("sobrenome"));
                colab.setTel(rsColab.getString("tel"));
                colab.setEmail(rsColab.getString("email"));
                colab.setFuncao(rsColab.getString("funcao"));
                colab.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(colab);
    }
    @Override
    public List<Colaborador> findAll() {
        List<Colaborador> colaboradores = new ArrayList<>();
        String sql = "SELECT * FROM colaborador";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rsColab.getInt("id"));
                colaborador.setNome(rsColab.getString("nome"));
                colaborador.setSobrenome(rsColab.getString("sobrenome"));
                colaborador.setTel(rsColab.getString("tel"));
                colaborador.setEmail(rsColab.getString("email"));
                colaborador.setFuncao(rsColab.getString("funcao"));
                colaborador.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                colaboradores.add(colaborador);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return colaboradores;
    }
}