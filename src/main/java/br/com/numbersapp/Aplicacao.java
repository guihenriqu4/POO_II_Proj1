package br.com.numbersapp;

import br.com.numbersapp.dao.ClienteDAO;
import br.com.numbersapp.dao.ColaboradorDAO;
import br.com.numbersapp.dao.EstacaoDAO;
import br.com.numbersapp.dao.ProdutoDAO;
import br.com.numbersapp.model.Cliente;
import br.com.numbersapp.model.Colaborador;
import br.com.numbersapp.model.Estacao;
import br.com.numbersapp.model.Produto;

import java.util.List;
import java.util.Optional;

public class Aplicacao {
    public static void main(String[] args) {
//         Teste de save -- INSERT (CLIENTE)
//       ClienteDAO clienteDAO = new ClienteDAO();
//       Cliente cliente = new Cliente();
//       cliente.setNome("Guilherme");
//       cliente.setSobrenome("Souza");
//       cliente.setTel("62984687959");
//       cliente.setSenha("guilherme123");
//       cliente.setDataintegracao(java.time.LocalDate.now());
//       Cliente inserido =  clienteDAO.save(cliente);
//       inserido.printCliente();

//          Teste de save -- INSERT (PRODUTO)
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        Produto produto = new Produto();
//        produto.setNome("Noite cinzenta");
//        produto.setMarca("Chanel");
//        produto.setDescricao("Esmalte azul escuro com brilho");
//        produto.setQuantidade(8);
//        Produto inserido =  produtoDAO.save(produto);
//        inserido.printProduto();

//          Teste de save -- INSERT (COLABORADOR)
//        ColaboradorDAO colaboradorDAODAO = new ColaboradorDAO();
//        Colaborador colaborador = new Colaborador();
//        colaborador.setNome("Bernardete");
//        colaborador.setSobrenome("Oliveira");
//        colaborador.setTel("62988993322");
//        colaborador.setEmail("bernardete@gmail.com");
//        colaborador.setSenha("123456789");
//        colaborador.setCargo("Secretária");
//        colaborador.setDataintegracao(java.time.LocalDate.now());
//        Colaborador inserido =  colaboradorDAODAO.save(colaborador);
//        inserido.printColaborador();

//          Teste de save -- INSERT (ESTACAO)
//        EstacaoDAO estacaoDAO = new EstacaoDAO();
//        Estacao estacao = new Estacao();
//        estacao.setNome("Cadeira de corte");
//        Estacao inserido =  estacaoDAO.save(estacao);
//        inserido.printEstacao();

        // Teste de update -- UPDATE (CLIENTE)
//        ClienteDAO clienteDAO = new ClienteDAO();
//        int id0 = 2;
//        Optional<Cliente> cliente = clienteDAO.findById(id0);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
//        cliente.ifPresent(c -> {c.setNome("Chuva de verão");});
//        cliente.ifPresent(c -> {c.setSobrenome("Silva");});
//        cliente.ifPresent(c -> {c.setTel("62984687959");});
//        cliente.ifPresent(c -> {c.setSenha("guilherme123");});
//        cliente.map(clienteDAO::update);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));

        // Teste de update -- UPDATE (PRODUTO)
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        int id0 = 2;
//        Optional<Produto> produto = produtoDAO.findById(id0);
//        produto.ifPresentOrElse(Produto::printProduto, () -> System.out.println("Produto não encontrado pelo ID: "+ id0));
////        produto.ifPresent(p -> {p.setNome("Chuva de verão");});
////        produto.ifPresent(p -> {p.setDescricao("Esmalte azul amarelado");});
//        produto.ifPresent(p -> {p.setQuantidade(2);});
//        produto.map(produtoDAO::update);
//        produto.ifPresentOrElse(Produto::printProduto, () -> System.out.println("Produto não encontrado pelo ID: "+ id0));

            // Teste de update -- UPDATE (COLABORADOR)
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        int id0 = 2;
//        Optional<Colaborador> colaborador = colaboradorDAO.findById(id0);
//        colaborador.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo ID: "+ id0));
//        colaborador.ifPresent(c -> {c.setNome("Alexandra");});
//        colaborador.ifPresent(c -> {c.setSobrenome("Monte");});
//        colaborador.ifPresent(c -> {c.setTel("62948295032");});
//        colaborador.ifPresent(c -> {c.setEmail("alexandra@gmail.com");});
//        colaborador.ifPresent(c -> {c.setSenha("alex@ndr4");});
//        colaborador.ifPresent(c -> {c.setCargo("Manicure");});
//        colaborador.map(colaboradorDAO::update);
//        colaborador.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo ID: "+ id0));

        // Teste de update -- UPDATE (ESTACAO)
//        EstacaoDAO estacaoDAO = new EstacaoDAO();
//        int id0 = 2;
//        Optional<Estacao> estacao = estacaoDAO.findById(id0);
//        estacao.ifPresentOrElse(Estacao::printEstacao, () -> System.out.println("Estação não encontrada pelo ID: "+ id0));
//        estacao.ifPresent(e -> {e.setNome("Sala de Depilação");});
//        estacao.map(estacaoDAO::update);
//        estacao.ifPresentOrElse(Estacao::printEstacao, () -> System.out.println("Estação não encontrada pelo ID: "+ id0));

        // Teste de delete -- DELETE (CLIENTE)
//        ClienteDAO clienteDAO = new ClienteDAO();
//        int id0 = 2;
//        Optional<Cliente> cliente = clienteDAO.findById(id0);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
////        produto.ifPresent(produtoDAO::deleteProduto);
//        clienteDAO.deleteCliente(id0);
//        System.out.println("Deleção executada com sucesso!");

        // Teste de delete -- DELETE (PRODUTO)
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        int id0 = 3;
//        Optional<Produto> produto = produtoDAO.findById(id0);
//        produto.ifPresentOrElse(Produto::printProduto, () -> System.out.println("Produto não encontrado pelo ID: "+ id0));
////        produto.ifPresent(produtoDAO::deleteProduto);
//        produtoDAO.deleteProduto(id0);
//        System.out.println("Deleção executada com sucesso!");

        // Teste de delete -- DELETE (COLABORADOR)
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        int id0 = 3;
//        Optional<Colaborador> colaborador = colaboradorDAO.findById(id0);
//        colaborador.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo ID: "+ id0));
////        produto.ifPresent(produtoDAO::deleteProduto);
//        colaboradorDAO.deleteColaborador(id0);
//        System.out.println("Deleção executada com sucesso!");

        // Teste de delete -- DELETE (PRODUTO)
//        EstacaoDAO estacaoDAO = new EstacaoDAO();
//        int id0 = 3;
//        Optional<Estacao> estacao = estacaoDAO.findById(id0);
//        estacao.ifPresentOrElse(Estacao::printEstacao, () -> System.out.println("Estação não encontrada pelo ID: "+ id0));
////        produto.ifPresent(produtoDAO::deleteProduto);
//        estacaoDAO.deleteEstacao(id0);
//        System.out.println("Deleção executada com sucesso!");

        // Teste de findByName (CLIENTE)
//        ClienteDAO clienteDAO = new ClienteDAO();
//        String nome = "Guilherme";
//        List<Cliente> clientes = clienteDAO.findByName(nome);
//
//        for (Cliente c : clientes) {
//            c.printCliente();
//        }

        // Teste de findByName (PRODUTO)
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        String nome = "Noite estrelada";
//        List<Produto> produtos = produtoDAO.findByName(nome);
//
//        for (Produto p : produtos) {
//            p.printProduto();
//        }

        // Teste de findByName (COLABORADOR)
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        String nome = "Alexandra";
//        List<Colaborador> colaboradores = colaboradorDAO.findByName(nome);
//
//        for (Colaborador c : colaboradores) {
//            c.printColaborador();
//        }

        // Teste de findByName (ESTACAO)
//        EstacaoDAO estacaoDAO = new EstacaoDAO();
//        String nome = "Cadeira lavadora";
//        List<Estacao> estacoes = estacaoDAO.findByName(nome);
//
//        for (Estacao e : estacoes) {
//            e.printEstacao();
//        }

        // Teste de findAll (CLIENTE)
//        ClienteDAO clienteDAO = new ClienteDAO();
//        List<Cliente> clientes = clienteDAO.findAll();
//
//        for (Cliente c : clientes) {
//            c.printCliente();
//        }

        // Teste de findAll (PRODUTO)
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        List<Produto> produtos = produtoDAO.findAll();
//
//        for (Produto p : produtos) {
//            p.printProduto();
//        }

        // Teste de findAll (COLABORADOR)
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        List<Colaborador> colaboradores = colaboradorDAO.findAll();
//
//        for (Colaborador c : colaboradores) {
//            c.printColaborador();
//        }

        // Teste de findAll (ESTACAO)
//        EstacaoDAO estacaoDAO = new EstacaoDAO();
//        List<Estacao> estacoes = estacaoDAO.findAll();
//
//        for (Estacao e : estacoes) {
//            e.printEstacao();
//        }

//        // Testes de findById, findByName, findByTel e findByEmail
//        ClienteDAO clienteDAO = new ClienteDAO();
//        ColaboradorDAO colabDAO = new ColaboradorDAO();

//        int id0 = 4;
//        Optional<Cliente> cliente0 = clienteDAO.findById(id0);
//        cliente0.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
//
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        int id1 = 2;
//        Optional<Colaborador> colaborador = colaboradorDAO.findById(id1);
//        colaborador.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo ID: "+ id1));

//        ClienteDAO clienteDAO = new ClienteDAO();
//        String tel1 = "62966773344"; //Não existe no banco
//        Optional<Cliente> cliente1 = clienteDAO.findByTel(tel1);
//        cliente1.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo Telefone: "+ tel1));
//
//        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
//        String tel2 = "62948295032"; //Existe no banco
//        Optional<Colaborador> colaborador2 = colaboradorDAO.findByTel(tel2);
//        colaborador2.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Cliente não encontrado pelo Telefone: "+ tel2));
//
//        String email4 = "pedro@email.com"; //Email não existe no banco
//        Optional<Colaborador> colab4 = colaboradorDAO.findByEmail(email4);
//        colab4.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo email: "+ email4));

//        String email4 = "alexandra@gmail.com"; //Email existe no banco
//        Optional<Colaborador> colab4 = colaboradorDAO.findByEmail(email4);
//        colab4.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo email: "+ email4));
//
//        String email5 = "pessoainexistente@email.com"; //Não existe no banco
//        Optional<Colaborador> colab5 = colabDAO.findByEmail(email5);
//        colab5.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo email: "+ email5));
    }
}
