package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ClienteDAO implements iClienteDAO{
    @Override
    public Cliente save(Cliente cliente) { //FUNCIONANDO
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO cliente (nome, sobrenome, senha, dataintegracao) values (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psCliente = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getSobrenome());
            psCliente.setString(3, cliente.getSenha());
            psCliente.setDate(4, java.sql.Date.valueOf(cliente.getDataintegracao()));
            psCliente.executeUpdate();

            ResultSet rsColab = psCliente.getGeneratedKeys();
            if (rsColab.next()) {
                cliente.setId(rsColab.getInt("id_cliente"));
            }

            sql = "INSERT INTO tel_cliente (id_cliente, nome_cliente, numero) values (?, ?, ?)";
            psCliente = connection.prepareStatement(sql);
            psCliente.setInt(1, cliente.getId());
            psCliente.setString(2, cliente.getNome());
            psCliente.setString(3, cliente.getTel());
            psCliente.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) { //FUNCIONADO
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, senha = ?, dataIntegracao = ? WHERE id_cliente = ?";
            assert connection != null;
            PreparedStatement psCliente = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getSobrenome());
            psCliente.setString(3, cliente.getSenha());
            psCliente.setDate(4, java.sql.Date.valueOf(cliente.getDataintegracao()));
            psCliente.setInt(5, cliente.getId());
            psCliente.executeUpdate();

            sql = "UPDATE tel_cliente SET  nome_cliente = ?, numero = ? WHERE id_cliente = ?";
            psCliente = connection.prepareStatement(sql);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getTel());
            psCliente.setInt(3, cliente.getId());
            psCliente.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void deleteCliente(int id) { //FUNCIONANDO
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM tel_cliente WHERE id_cliente = ?";
            PreparedStatement psCliente = connection.prepareStatement(sql);
            psCliente.setInt(1, id);
            psCliente.executeUpdate();

            sql = "DELETE FROM cliente WHERE id_cliente = ?";
            assert connection != null;
            psCliente = connection.prepareStatement(sql);
            psCliente.setInt(1, id);
            psCliente.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Cliente> findById(int id) { //FUNCIONANDO
        Cliente cliente = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            String sql = "SELECT * FROM cliente where id_cliente = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id_cliente"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setSenha(rsCliente.getString("senha"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
            }
            sql = "SELECT numero FROM tel_cliente where id_cliente = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsTel = preparedStatement.executeQuery();
            while (rsTel.next()) {
                cliente.setTel(rsTel.getString("numero"));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(cliente);
    }

    @Override
    public Optional<Cliente> findByTel(String tel) { //NÃO TÁ FUNCIONANDO (NÃO ACHEI SOLUÇÃO)
        Cliente cliente = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            String sql = "SELECT * FROM tel_cliente where numero = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tel);
            ResultSet rsTelCliente = preparedStatement.executeQuery();
            int id = rsTelCliente.getInt("id_cliente");

            sql = "SELECT c.*, t.id_cliente, t.numero FROM cliente c, tel_cliente t WHERE id_cliente = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setSenha(rsCliente.getString("senha"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(cliente);
    }

    public List<Cliente> findByName(String nome) { //FUNCIONANDO COM DEFEITOS (LISTANDO DUAS VEZES)
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT c.*, t.numero FROM cliente c, tel_cliente t WHERE nome = ?";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id_cliente"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setTel(rsCliente.getString("numero"));
                cliente.setSenha(rsCliente.getString("senha"));
                cliente.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
                clientes.add(cliente);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return clientes;
    }

    @Override
    public List<Cliente> findAll() { //FUNCIONANDO COM DEFEITO (LISTANDO DUAS VEZES)
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT c.*, t.numero FROM cliente c, tel_cliente t;";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsCliente = preparedStatement.executeQuery();
            while (rsCliente.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rsCliente.getInt("id_cliente"));
                cliente.setNome(rsCliente.getString("nome"));
                cliente.setSobrenome(rsCliente.getString("sobrenome"));
                cliente.setTel(rsCliente.getString("numero"));
                cliente.setSenha(rsCliente.getString("senha"));
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