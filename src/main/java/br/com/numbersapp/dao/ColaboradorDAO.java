package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Colaborador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ColaboradorDAO implements iColaboradorDAO {
    @Override
    public Colaborador save(Colaborador colaborador) { //FUNCIONANDO
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO colaborador (nome, sobrenome, email, senha, cargo, dataintegracao) values (?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psColab.setString(1, colaborador.getNome());
            psColab.setString(2, colaborador.getSobrenome());
            psColab.setString(3, colaborador.getEmail());
            psColab.setString(4, colaborador.getSenha());
            psColab.setString(5, colaborador.getCargo());
            psColab.setDate(6, java.sql.Date.valueOf(colaborador.getDataintegracao()));
            psColab.executeUpdate();

            ResultSet rsColab = psColab.getGeneratedKeys();
            if (rsColab.next()) {
                colaborador.setId(rsColab.getInt("id_colaborador"));
            }

            sql = "INSERT INTO tel_colaborador (id_colaborador, nome_colaborador, numero) values (?, ?, ?)";
            psColab = connection.prepareStatement(sql);
            psColab.setInt(1, colaborador.getId());
            psColab.setString(2, colaborador.getNome());
            psColab.setString(3, colaborador.getTel());
            psColab.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return colaborador;
    }
    @Override
    public Colaborador update(Colaborador colaborador) { //FUNCIONANDO
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPDATE colaborador SET nome = ?, sobrenome = ?, email = ?, senha = ?, cargo = ?, dataintegracao = ? WHERE id_colaborador = ?";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psColab.setString(1, colaborador.getNome());
            psColab.setString(2, colaborador.getSobrenome());
            psColab.setString(3, colaborador.getEmail());
            psColab.setString(4, colaborador.getSenha());
            psColab.setString(5, colaborador.getCargo());
            psColab.setDate(6, java.sql.Date.valueOf(colaborador.getDataintegracao()));
            psColab.setInt(7, colaborador.getId());
            psColab.executeUpdate();

            sql = "UPDATE tel_colaborador SET  nome_colaborador = ?, numero = ? WHERE id_colaborador = ?";
            psColab = connection.prepareStatement(sql);
            psColab.setString(1, colaborador.getNome());
            psColab.setString(2, colaborador.getTel());
            psColab.setInt(3, colaborador.getId());
            psColab.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return colaborador;
    }
    @Override
    public void deleteColaborador(int id) { //FUNCIONANDO
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM tel_colaborador WHERE id_colaborador = ?";
            PreparedStatement psCliente = connection.prepareStatement(sql);
            psCliente.setInt(1, id);
            psCliente.executeUpdate();

            sql = "DELETE FROM colaborador WHERE id_colaborador = ?";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sql);
            psColab.setInt(1, id);
            psColab.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Colaborador> findById(int id) { //FUNCIONANDO
        Colaborador colab = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            String sql = "SELECT * FROM colaborador WHERE id_colaborador = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                colab = new Colaborador();
                colab.setId(rsColab.getInt("id_colaborador"));
                colab.setNome(rsColab.getString("nome"));
                colab.setSobrenome(rsColab.getString("sobrenome"));
                colab.setEmail(rsColab.getString("email"));
                colab.setCargo(rsColab.getString("cargo"));
                colab.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
            }
            sql = "SELECT numero FROM tel_colaborador where id_colaborador = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsTel = preparedStatement.executeQuery();
            while (rsTel.next()) {
                colab.setTel(rsTel.getString("numero"));
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
                colab.setCargo(rsColab.getString("cargo"));
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
        Colaborador colab = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            String sql = "SELECT * FROM colaborador WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                colab = new Colaborador();
                colab.setId(rsColab.getInt("id"));
                colab.setNome(rsColab.getString("nome"));
                colab.setSobrenome(rsColab.getString("sobrenome"));
                colab.setEmail(rsColab.getString("email"));
                colab.setCargo(rsColab.getString("cargo"));
                colab.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(colab);
    }

    public List<Colaborador> findByName(String nome) { //FUNCIONANDO
        List<Colaborador> colaboradores = new ArrayList<>();
        String sql = "SELECT c.*, t.numero FROM colaborador c, tel_colaborador t WHERE nome = ?";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rsColab.getInt("id_colaborador"));
                colaborador.setNome(rsColab.getString("nome"));
                colaborador.setSobrenome(rsColab.getString("sobrenome"));
                colaborador.setTel(rsColab.getString("numero"));
                colaborador.setEmail(rsColab.getString("email"));
                colaborador.setSenha(rsColab.getString("senha"));
                colaborador.setCargo(rsColab.getString("cargo"));
                colaborador.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                colaboradores.add(colaborador);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return colaboradores;
    }

    @Override
    public List<Colaborador> findAll() { //FUNCIONANDO
        List<Colaborador> colaboradores = new ArrayList<>();
        String sql = "SELECT c.*, t.numero FROM colaborador c, tel_colaborador t";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsColab = preparedStatement.executeQuery();
            while (rsColab.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rsColab.getInt("id_colaborador"));
                colaborador.setNome(rsColab.getString("nome"));
                colaborador.setSobrenome(rsColab.getString("sobrenome"));
                colaborador.setTel(rsColab.getString("numero"));
                colaborador.setEmail(rsColab.getString("email"));
                colaborador.setSenha(rsColab.getString("senha"));
                colaborador.setCargo(rsColab.getString("cargo"));
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