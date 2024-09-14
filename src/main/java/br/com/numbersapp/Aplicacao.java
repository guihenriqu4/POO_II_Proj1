package br.com.numbersapp;

import br.com.numbersapp.dao.ClienteDAO;
import br.com.numbersapp.dao.ColaboradorDAO;
import br.com.numbersapp.dao.ProdutoDAO;
import br.com.numbersapp.model.Cliente;
import br.com.numbersapp.model.Colaborador;
import br.com.numbersapp.model.Produto;

import java.util.List;
import java.util.Optional;

public class Aplicacao {
    public static void main(String[] args) {
//         Teste de save -- INSERT
//        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = new Cliente();
//        cliente.setNome("Genoveva");
//        cliente.setSobrenome("Lacerda");
//        cliente.setTel("62988772255");
//        cliente.setDataintegracao(java.time.LocalDate.now());
//        Cliente inserida =  clienteDAO.save(cliente);
//        inserida.printPessoa();

//          Teste de save -- INSERT
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setNome("Côco Bambu");
        produto.setMarca("Now United");
        produto.setDescricao("Esmate branco fosco");
        produto.setQuantidade(3);
        Produto inserida =  produtoDAO.save(produto);
        inserida.printProduto();

        // Teste de update -- UPDATE
//        ClienteDAO clienteDAO = new ClienteDAO();
//        long id0 = 1L;
//        Optional<Cliente> cliente = clienteDAO.findById(id0);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
//        cliente.ifPresent(p -> {c.setNome("João");});
//        cliente.ifPresent(p -> {c.setSobrenome("Silva Santos");});
//        cliente.ifPresent(p -> {c.setDataaniversario(java.time.LocalDate.of(1993, 12, 22));});
//        cliente.map(clienteDAO::update);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));

        // Teste de delete -- DELETE
//        ClienteDAO clienteDAO = new ClienteDAO();
//        long id0 = 1L;
//        Optional<Cliente> cliente = clienteDAO.findById(id0);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
//        cliente.ifPresent(clienteDAO::deleteCliente);
//        cliente = clienteDAO.findById(id0);
//        cliente.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));

        // Teste de findAll
//        ClienteDAO clienteDAO = new ClienteDAO();
//        List<Cliente> clientes = clienteDAO.findAll();
//
//        for (Cliente c : clientes) {
//            c.printCliente();
//        }

//        // Testes de findById, findByCpf e findByEmail
//        ClienteDAO clienteDAO = new ClienteDAO();
//        ColaboradorDAO colabDAO = new ColaboradorDAO();
//
//        long id0 = 1L;
//        Optional<Cliente> cliente0 = clienteDAO.findById(id0);
//        cliente0.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id0));
//
//        long id1 = 99L;
//        Optional<Cliente> cliente1 = clienteDAO.findById(id1);
//        cliente1.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo ID: "+ id1));
//
//        String tel2 = "62988772255";
//        Optional<Cliente> cliente2 = clienteDAO.findByTel(tel2);
//        cliente2.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo Telefone: "+ tel2));
//
//        String tel3 = "62966773344"; //Não existe no banco
//        Optional<Cliente> cliente3 = clienteDAO.findByTel(tel3);
//        cliente3.ifPresentOrElse(Cliente::printCliente, () -> System.out.println("Cliente não encontrado pelo Telefone: "+ tel3));
//
//        String email4 = "pedro@email.com";
//        Optional<Colaborador> colab4 = colabDAO.findByEmail(email4);
//        colab4.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo email: "+ email4));
//
//        String email5 = "pessoainexistente@email.com"; //Não existe no banco
//        Optional<Colaborador> colab5 = colabDAO.findByEmail(email5);
//        colab5.ifPresentOrElse(Colaborador::printColaborador, () -> System.out.println("Colaborador não encontrado pelo email: "+ email5));
    }
}
