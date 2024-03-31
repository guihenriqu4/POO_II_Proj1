package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Pessoa;
import br.com.numbersapp.model.Tabela;
import br.com.numbersapp.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO implements iPessoaDAO {

    @Override
    public Pessoa save(Pessoa pessoa) {
        try (Connection connection = BancoDeDados.getConnection()){
            int tabela = pessoa.getTabela().ordinal();
            switch (tabela){
                case 1:
                    String sqlCliente = "insert into cliente (nome, sobrenome, tel, dataintegracao, tabela) values (?, ?, ?, ?, ?)";
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
                    psCliente.setString(1, pessoa.getNome());
                    psCliente.setString(2, pessoa.getSobrenome());
                    psCliente.setString(3, pessoa.getTel());
                    psCliente.setDate(4, java.sql.Date.valueOf(pessoa.getDataIntegracao()));
                    psCliente.setString(5, pessoa.getTabela().toString());
                    int rowsAffectedCliente = psCliente.executeUpdate();
                    if (rowsAffectedCliente > 0) {
                        System.out.println("Cliente salvo com sucesso!");
                    }else{
                        System.out.println("Erro ao salvar cliente!");
                    }

                    ResultSet rsCliente = psCliente.getGeneratedKeys();
                    if (rsCliente.next()) {
                        pessoa.setId(rsCliente.getInt("id"));
                    }
                    break;
                case 2:
                    String sqlColab = "insert into colaborador (nome, sobrenome, tel, email, cargo, dataintegracao, tabela) values (?, ?, ?, ?, ?, ?, ?)";
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement(sqlColab, Statement.RETURN_GENERATED_KEYS);
                    psColab.setString(1, pessoa.getNome());
                    psColab.setString(2, pessoa.getSobrenome());
                    psColab.setString(3, pessoa.getTel());
                    psColab.setString(4, pessoa.getEmail());
                    psColab.setString(5, pessoa.getCargo());
                    psColab.setDate(6, java.sql.Date.valueOf(pessoa.getDataIntegracao()));
                    psColab.setString(7, pessoa.getTabela().toString());
                    int rowsAffectedColab = psColab.executeUpdate();
                    if (rowsAffectedColab > 0) {
                        System.out.println("Colaborador salvo com sucesso!");
                    }else{
                        System.out.println("Erro ao salvar colaborador!");
                    }

                    ResultSet rsColab = psColab.getGeneratedKeys();
                    if (rsColab.next()) {
                        pessoa.setId(rsColab.getInt("id"));
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a execução do salvamento.");
            throw new RuntimeException(e);
        }
        return pessoa;
    }

    public Produto save (Produto produto) {
        try (Connection connection = BancoDeDados.getConnection()) {
            String sqlProduto = "insert into produto (nome, marca, descricao, quantidade) values (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement psProduto = connection.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS);
            psProduto.setString(1, produto.getNome());
            psProduto.setString(2, produto.getMarca());
            psProduto.setString(3, produto.getDescricao());
            psProduto.setDouble(4, produto.getQuantidade());
            int rowsAffected = psProduto.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto salvo com sucesso!");
            }else{
                System.out.println("Erro ao salvar produto!");
            }

            ResultSet rsProduto = psProduto.getGeneratedKeys();
            if (rsProduto.next()) {
                produto.setId(rsProduto.getLong("id"));
            }
        }catch (SQLException e) {
            System.out.println("Erro durante a execução do salvamento.");
            throw new RuntimeException(e);
        }
        return produto;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        try (Connection connection = BancoDeDados.getConnection()){
            int tabela = pessoa.getTabela().ordinal();
            switch (tabela){
                case 1:
                    String sqlCliente = "update cliente set nome = ?, sobrenome = ?, tel = ?, dataintegracao = ?, tabela = ? where id = " + pessoa.getId();
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
                    psCliente.setString(1, pessoa.getNome());
                    psCliente.setString(2, pessoa.getSobrenome());
                    psCliente.setString(3, pessoa.getTel());
                    psCliente.setDate(4, java.sql.Date.valueOf(pessoa.getDataIntegracao()));
                    psCliente.setString(5, pessoa.getTabela().toString());
                    int rowsAffectedCliente = psCliente.executeUpdate();
                    if (rowsAffectedCliente > 0) {
                        System.out.println("Cliente atualizado com sucesso!");
                    }else{
                        System.out.println("Erro ao atualizar cliente!");
                    }
                    break;
                case 2:
                    String sqlColab = "update colaborador set nome = ?, sobrenome = ?, tel = ?, email = ?, cargo = ?, dataintegracao = ?, tabela = ? where id = " + pessoa.getId();
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement(sqlColab, Statement.RETURN_GENERATED_KEYS);
                    psColab.setString(1, pessoa.getNome());
                    psColab.setString(2, pessoa.getSobrenome());
                    psColab.setString(3, pessoa.getTel());
                    psColab.setString(4, pessoa.getEmail());
                    psColab.setString(5, pessoa.getCargo());
                    psColab.setDate(6, java.sql.Date.valueOf(pessoa.getDataIntegracao()));
                    psColab.setString(7, pessoa.getTabela().toString());
                    int rowsAffectedColab = psColab.executeUpdate();
                    if (rowsAffectedColab > 0) {
                        System.out.println("Colaborador atualizado com sucesso!");
                    }else{
                        System.out.println("Erro ao atualizar colaborador!");
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a execução da atualização.");
            throw new RuntimeException(e);
        }
        return pessoa;
    }

    public Produto update (Produto produto) {
        try (Connection connection = BancoDeDados.getConnection()) {
            String sqlProduto = "update produto set nome = ?, marca = ?, descricao = ?, quantidade = ?) where id = " + produto.getId();
            assert connection != null;
            PreparedStatement psProduto = connection.prepareStatement(sqlProduto);
            psProduto.setString(1, produto.getNome());
            psProduto.setString(2, produto.getMarca());
            psProduto.setString(3, produto.getDescricao());
            psProduto.setDouble(4, produto.getQuantidade());
            int rowsAffected = psProduto.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto salvo com sucesso!");
            }else{
                System.out.println("Erro ao salvar produto!");
            }
        }catch (SQLException e) {
            System.out.println("Erro durante a execução do salvamento.");
            throw new RuntimeException(e);
        }
        return produto;
    }

    @Override
    public void deletePessoa(int id, Tabela tabela) {
        try (Connection connection = BancoDeDados.getConnection()){
            switch (tabela.ordinal()){
                case 1:
                    String sqlCliente = "delete from cliente where id = ?";
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement((sqlCliente));
                    psCliente.setInt(1, id);
                    int rowsAffectedCLiente = psCliente.executeUpdate();
                    if (rowsAffectedCLiente > 0) {
                        System.out.println("Exclusão realizada com sucesso!");
                    }else {
                        System.out.println("Erro ao executar a exclusão!");
                    }
                    break;
                case 2:
                    String sqlColab = "delete from colaborador where id = ?";
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement((sqlColab));
                    psColab.setInt(1, id);
                    int rowsAffectedColab = psColab.executeUpdate();
                    if (rowsAffectedColab > 0) {
                        System.out.println("Exclusão realizada com sucesso!");
                    }else {
                        System.out.println("Erro ao executar a exclusão!");
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        }catch (SQLException e) {
            System.out.println("Erro durante a execução da exclusão!");
            throw new RuntimeException(e);
        }
    }

    public void deleteProduto(int id) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sqlProduto = "delete from produto where id = ?";
            assert connection != null;
            PreparedStatement psProd = connection.prepareStatement(sqlProduto);
            psProd.setInt(1, id);
            int rowsAffectedProd = psProd.executeUpdate();
            if (rowsAffectedProd > 0) {
                System.out.println("Exclusão realizada com sucesso!");
            }else {
                System.out.println("Erro ao executar a exclusão!");
            }
        }catch (SQLException e){
            System.out.println("Erro durante a execução da exclusão!");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Pessoa> findById(int id, Tabela tabela) {
        Pessoa pessoa = null;
        try (Connection connection = BancoDeDados.getConnection()){
            switch (tabela.ordinal()){
                case 1:
                    String sqlCliente = "select * from cliente where id = ?";
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement(sqlCliente);
                    psCliente.setInt(1, id);
                    ResultSet rsCliente = psCliente.executeQuery();
                    while (rsCliente.next()) {
                        pessoa = new Pessoa();
                        pessoa.setId(rsCliente.getInt("id"));
                        pessoa.setNome(rsCliente.getString("nome"));
                        pessoa.setSobrenome(rsCliente.getString("sobrenome"));
                        pessoa.setTel(rsCliente.getString("tel"));
                        pessoa.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsCliente.getString("tabela")));
                    }
                    break;
                case 2:
                    String sqlColab = "select * from colaborador where id = ?";
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement(sqlColab);
                    psColab.setInt(1, id);
                    ResultSet rsColab = psColab.executeQuery();
                    while (rsColab.next()) {
                        pessoa = new Pessoa();
                        pessoa.setId(rsColab.getInt("id"));
                        pessoa.setNome(rsColab.getString("nome"));
                        pessoa.setSobrenome(rsColab.getString("sobrenome"));
                        pessoa.setTel(rsColab.getString("tel"));
                        pessoa.setEmail(rsColab.getString("email"));
                        pessoa.setCargo(rsColab.getString("cargo"));
                        pessoa.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsColab.getString("tabela")));
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        }catch (SQLException e){
            System.out.println("Erro na execução da busca!");
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pessoa);
    }

    public Optional<Produto> findById(Long id) {
        String sqlProd = "select * from produto where id = ?";
        Produto produto = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            PreparedStatement psProduto = connection.prepareStatement(sqlProd);
            psProduto.setLong(1, id);
            ResultSet rsProduto = psProduto.executeQuery();
            while (rsProduto.next()) {
                produto = new Produto();
                produto.setId(rsProduto.getLong("id"));
                produto.setNome(rsProduto.getString("nome"));
                produto.setMarca(rsProduto.getString("marca"));
                produto.setDescricao(rsProduto.getString("descricao"));
                produto.setQuantidade(rsProduto.getDouble("quantidade"));

            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(produto);
    }

    @Override
    public Optional<Pessoa> findByTel(String tel, Tabela tabela) {
        Pessoa pessoa = null;
        try (Connection connection = BancoDeDados.getConnection()){
            switch (tabela.ordinal()){
                case 1:
                    String sqlCliente = "select * from cliente where tel = ?";
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement(sqlCliente);
                    psCliente.setString(1, tel);
                    ResultSet rsCliente = psCliente.executeQuery();
                    while (rsCliente.next()) {
                        pessoa = new Pessoa();
                        pessoa.setId(rsCliente.getInt("id"));
                        pessoa.setNome(rsCliente.getString("nome"));
                        pessoa.setSobrenome(rsCliente.getString("sobrenome"));
                        pessoa.setTel(rsCliente.getString("tel"));
                        pessoa.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsCliente.getString("tabela")));
                    }
                    break;
                case 2:
                    String sqlColab = "select * from colaborador where tel = ?";
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement(sqlColab);
                    psColab.setString(1, tel);
                    ResultSet rsColab = psColab.executeQuery();
                    while (rsColab.next()) {
                        pessoa = new Pessoa();
                        pessoa.setId(rsColab.getInt("id"));
                        pessoa.setNome(rsColab.getString("nome"));
                        pessoa.setSobrenome(rsColab.getString("sobrenome"));
                        pessoa.setTel(rsColab.getString("tel"));
                        pessoa.setEmail(rsColab.getString("email"));
                        pessoa.setCargo(rsColab.getString("cargo"));
                        pessoa.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsColab.getString("tabela")));
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        }catch (SQLException e){
            System.out.println("Erro na execução da busca!");
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pessoa);
    }

    @Override
    public Optional<Pessoa> findByEmail(String email) {
        Pessoa pessoa = null;
        try (Connection connection = BancoDeDados.getConnection()) {
            String sqlColab = "select * from colaborador where email = ?";
            assert connection != null;
            PreparedStatement psColab = connection.prepareStatement(sqlColab);
            psColab.setString(1, email);
            ResultSet rsColab = psColab.executeQuery();
            while (rsColab.next()) {
                pessoa = new Pessoa();
                pessoa.setId(rsColab.getInt("id"));
                pessoa.setNome(rsColab.getString("nome"));
                pessoa.setSobrenome(rsColab.getString("sobrenome"));
                pessoa.setTel(rsColab.getString("tel"));
                pessoa.setEmail(rsColab.getString("email"));
                pessoa.setCargo(rsColab.getString("cargo"));
                pessoa.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                pessoa.setTabela(Tabela.valueOf(rsColab.getString("tabela")));
            }
        }catch (SQLException e){
            System.out.println("Erro na execução da busca!");
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pessoa);
    }

    @Override
    public List<Pessoa> findAll(Tabela tabela) {
        List<Pessoa> listpessoas = new ArrayList<>();
        try (Connection connection = BancoDeDados.getConnection()){
            switch (tabela.ordinal()){
                case 1:
                    String sqlCliente = "select * from cliente";
                    assert connection != null;
                    PreparedStatement psCliente = connection.prepareStatement(sqlCliente);
                    ResultSet rsCliente = psCliente.executeQuery();
                    while (rsCliente.next()) {
                        Pessoa pessoa = new Pessoa();
                        pessoa.setId(rsCliente.getInt("id"));
                        pessoa.setNome(rsCliente.getString("nome"));
                        pessoa.setSobrenome(rsCliente.getString("sobrenome"));
                        pessoa.setTel(rsCliente.getString("tel"));
                        pessoa.setDataintegracao(rsCliente.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsCliente.getString("tabela")));
                        listpessoas.add(pessoa);
                    }
                    break;
                case 2:
                    String sqlColab = "select * from colaboradores";
                    assert connection != null;
                    PreparedStatement psColab = connection.prepareStatement(sqlColab);
                    ResultSet rsColab = psColab.executeQuery();
                    while (rsColab.next()) {
                        Pessoa pessoa = new Pessoa();
                        pessoa.setId(rsColab.getInt("id"));
                        pessoa.setNome(rsColab.getString("nome"));
                        pessoa.setSobrenome(rsColab.getString("sobrenome"));
                        pessoa.setTel(rsColab.getString("tel"));
                        pessoa.setDataintegracao(rsColab.getDate("dataintegracao").toLocalDate());
                        pessoa.setTabela(Tabela.valueOf(rsColab.getString("tabela")));
                        listpessoas.add(pessoa);
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        }catch (SQLException e){
            System.out.println("Erro na execução da busca!");
            throw new RuntimeException(e);
        }
        return listpessoas;
    }

    public List<Produto> findAll() {
        List<Produto> listprodutos = new ArrayList<>();
        String sqlProd = "select * from produto";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlProd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getLong("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setQuantidade(resultSet.getDouble("quantidade"));
                listprodutos.add(produto);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return listprodutos;
    }
}


