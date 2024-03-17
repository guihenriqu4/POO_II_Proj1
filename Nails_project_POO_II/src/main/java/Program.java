import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {



    public static void main(String[] args) {
        DataBase bd = new DataBase();
        Connection conexao = bd.getConnection();

        Scanner sc = new Scanner(System.in);

        while (true) {
            imprimeMenu1();

            int resposta = sc.nextInt();
            sc.nextLine();

            switch (resposta) { //Esse primeiro switch/case serve para alterar/navegar entre 1 - Cliente; 2 - Colaborador; 3 - Serviços
                case 1:
                    imprimeMenu2();
                    int resp = sc.nextInt();
                    sc.nextLine();
                    switch (resp) { //Esse segundo switch/case serve para utilizar as funções do CRUD (1 - Cadastrar; 2 - Atualizar; 3 - Listar; 4 - Deletar
                        case 1:
                            cadastrarCliente(conexao, sc);
                            break;
                        case 2:
                            atualizarCliente(conexao, sc);
                            break;
                        case 3:
                            listarCliente(conexao, sc);
                            break;
                        case 4:
                            deletarCliente(conexao, sc);
                            break;
                        case 5:
                            System.out.println("Voltando para menu principal");
                            sc.close();
                            System.exit(0);
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                    }
                    break;
                case 2:
                    imprimeMenu2();
                    int resp = sc.nextInt();
                    sc.nextLine();
                    switch (resp) {
                        case 1:
                            cadastrarColaborador(conexao, sc);
                            break;
                        case 2:
                            atualizarColaborador(conexao, sc);
                            break;
                        case 3:
                            listarColaborador(conexao, sc);
                            break;
                        case 4:
                            deletarColaborador(conexao, sc);
                            break;
                        case 5:
                            System.out.println("Voltando para menu principal");
                            sc.close();
                            System.exit(0);
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                    }
                    break;
                case 3:
                    imprimeMenu2();
                    int resp = sc.nextInt();
                    sc.nextLine();
                    switch (resp) {
                        case 1:
                            cadastrarServicos(conexao, sc);
                            break;
                        case 2:
                            atualizarServicos(conexao, sc);
                            break;
                        case 3:
                            listarServicos(conexao, sc);
                            break;
                        case 4:
                            deletarServicos(conexao, sc);
                            break;
                        case 5:
                            System.out.println("Voltando para menu principal");
                            sc.close();
                            System.exit(0);
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void imprimeMenu1() {
        System.out.println("-------------------------------------------------");
        System.out.println("Insira o número da opção desejada:");
        System.out.println("1. Cliente");
        System.out.println("2. Colaborador");
        System.out.println("3. Serviços");
        System.out.println("4. Sair");
        System.out.println("-------------------------------------------------");
    }

    private static void imprimeMenu2() {
        System.out.println("-------------------------------------------------");
        System.out.println("Insira o número da opção desejada:");
        System.out.println("1. Cadastrar");
        System.out.println("2. Atualizar");
        System.out.println("3. Listar");
        System.out.println("4. Deletar");
        System.out.println("5. Voltar");
        System.out.println("-------------------------------------------------");
    }

    private static void cadastrarCliente(Connection conexao, Scanner sc) {
        try {
            int id = 0;
            System.out.println("Digite o nome do/a cliente: ");
            String nome = sc.nextLine();

            System.out.println("Digite o telefone/celular: ");
            String telefone = sc.nextLine();

            System.out.println("Digite a senha: ");
            String senha = sc.nextLine();

            if (verificaTelefone(conexao, telefone, id)) {
                System.out.println("O telefone/celular utilizado já está em uso");
                return;
            }

            if (nome.trim().isEmpty() || senha.trim().isEmpty()) {
                System.out.println("Todos os campos precisam ser preenchidos!");
                return;
            }


            PreparedStatement psW = conexao.prepareStatement("INSERT INTO cliente (nome, telefone, senha) VALUES (?, ?, ?)"); //Definição do cadastro

            psW.setString(1, nome);
            psW.setString(2, telefone);
            psW.setString(3, senha);

            int rowsAffected = psW.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar o cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a execução do cadastro.");
            e.printStackTrace();
        }
    }

    private static void cadastrarColaborador(Connection conexao, Scanner sc) {
        try {
            int id = 0;
            System.out.println("Digite o nome do/a colaborador/a: ");
            String nome = sc.nextLine();

            System.out.println("Digite o telefone/celular: ");
            String telefone = sc.nextLine();

            System.out.println("Digite o e-mail: ");
            String email = sc.nextLine();

            System.out.println("Digite o cargo do/a colaborador/a: ");
            String cargo = sc.nextLine();

            System.out.println("Digite a senha: ");
            String senha = sc.nextLine();

            if (verificaTelefone(conexao, telefone, id)) {
                System.out.println("O telefone/celular utilizado já está em uso");
                return;
            }

            if (nome.trim().isEmpty() || email.trim().isEmpty() || cargo.trim().isEmpty() || senha.trim().isEmpty()) {
                System.out.println("Todos os campos precisam ser preenchidos!");
                return;
            }


            PreparedStatement psW = conexao.prepareStatement("INSERT INTO colaborador (nome, telefone, email, cargo, senha) VALUES (?, ?, ?, ?, ?)"); //Definição do cadastro

            psW.setString(1, nome);
            psW.setString(2, telefone);
            psW.setString(3, email);
            psW.setString(4, cargo);
            psW.setString(5, senha);

            int rowsAffected = psW.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Colaborador cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar o colaborador.");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a execução do cadastro.");
            e.printStackTrace();
        }
    }

    private static void cadastrarServicos(Connection conexao, Scanner sc) {
        try {
            int id = 0;
            System.out.println("Digite o nome do serviço: ");
            String nome = sc.nextLine();

            System.out.println("Digite o descrição: ");
            String descricao = sc.nextLine();

            System.out.println("Digite o valor: ");
            String valor = sc.nextLine();

            System.out.println("Digite a disponibilidade do serviço: ");
            String disponibilidade = sc.nextLine();

            if (nome.trim().isEmpty() || descricao.trim().isEmpty() || valor.trim().isEmpty() || disponibilidade.trim().isEmpty()) {
                System.out.println("Todos os campos precisam ser preenchidos!");
                return;
            }


            PreparedStatement psW = conexao.prepareStatement("INSERT INTO servicos (nome, descricao, valor, disponibilidade) VALUES (?, ?, ?, ?)"); //Definição do cadastro

            psW.setString(1, nome);
            psW.setString(2, descricao);
            psW.setString(3, valor);
            psW.setString(4, disponibilidade);

            int rowsAffected = psW.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Serviço cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar o serviço.");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a execução do cadastro.");
            e.printStackTrace();
        }
    }
}
