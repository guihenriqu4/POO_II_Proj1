package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ClienteDAO implements iClienteDAO{
    @Override
    public Cliente save(Cliente cliente) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO cliente (nome, sobrenome, tel, dataintegracao) values (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psCliente = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getSobrenome());
            psCliente.setString(3, cliente.getTel());
            psCliente.setDate(4, java.sql.Date.valueOf(cliente.getDataintegracao()));
            psCliente.executeUpdate();

            ResultSet rsColab = psCliente.getGeneratedKeys();
            if (rsColab.next()) {
                cliente.setId(rsColab.getInt("id"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPTDATE cliente SET nome = ?, sobrenome = ?, tel = ?, dataintegracao = ? WHERE id = ?";
            assert connection != null;
            PreparedStatement psCliente = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getSobrenome());
            psCliente.setString(3, cliente.getTel());
            psCliente.setDate(4, java.sql.Date.valueOf(cliente.getDataintegracao()));
            psCliente.setInt(5, cliente.getId());
            psCliente.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void deleteCliente(int id) {
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM cliente WHERE id = ?";
            assert connection != null;
            PreparedStatement psCliente = connection.prepareStatement(sql);
            psCliente.setInt(1, id);
            psCliente.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Cliente> findById(int id) {
        String sql = "SELECT * FROM cliente where id = ?";
        Cliente cliente = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setTel(rsCliente.getString("tel"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(cliente);
    }

    @Override
    public Optional<Cliente> findByTel(String tel) {
        String sql = "SELECT * FROM cliente where tel = ?";
        Cliente cliente = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tel);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setTel(rsCliente.getString("tel"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setTel(rsCliente.getString("tel"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
                clientes.add(cliente);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return clientes;
    }
}