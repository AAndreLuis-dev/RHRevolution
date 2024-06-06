package services;

import collections.FuncionarioDB;
import entities.Funcionario;

import java.util.Scanner;

public class FuncionarioServices {

    // Método para cadastrar um funcionário diretamente fornecendo o objeto Funcionario
    public static void cadastroUsuario(Funcionario funcionario) {
        FuncionarioDB funcionarioDB =  FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários
        funcionarioDB.add(funcionario); // Adiciona o funcionário ao banco de dados

    }

    // Método para cadastrar um funcionário solicitando dados do usuário
    public static void cadastroUsuario() {

        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        FuncionarioDB funcionarioDB =  FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários

        // Exibe o cabeçalho do cadastro de funcionário
        System.out.println("===========================");
        System.out.println("  CADASTRO DE FUNCIONARIO  ");
        System.out.println("===========================");

        // Solicita os dados do funcionário
        System.out.println("Digite o nome do funcionario");
        String nome = input.nextLine();

        System.out.println("Digite o email do funcionario");
        String email = input.nextLine();

        System.out.println("Digite o salario do funcionario");
        double salario = Double.parseDouble(input.nextLine()); // Consome a linha pendente

        System.out.println("Digite o CPF do funcionario");
        String cpf = input.next();

        System.out.println("Digite o tempo de trabalho em meses");
        int mesesTrabalho = input.nextInt();

        // Adiciona o novo funcionário ao banco de dados
        funcionarioDB.add(new Funcionario(nome, email, salario, cpf, mesesTrabalho));
    }

    // Método para mostrar todos os funcionários cadastrados
    public static void mostrarUsuarios() {
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){ // Itera sobre todos os funcionários
            System.out.println("=====================================");
            System.out.println(funcionario.toString(1)); // Exibe os detalhes do funcionário
            System.out.println("=====================================");
        }
    }

    // Método para alterar os dados de um funcionário
    public static void alterarUsuario() {
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho da modificação de funcionários
        System.out.println("============================");
        System.out.println("     MODIFICAR USUÁRIOS     ");
        System.out.println("============================");

        // Solicita o CPF do funcionário a ser alterado
        System.out.println("Digite o cpf do usuário que deseja fazer alterações.");
        String cpfProcura = input.next();

        // Procura o funcionário pelo CPF
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){

            if (funcionario.getCPF().equals(cpfProcura)){
                System.out.println("FUNCIONARIO ENCONTRADO!");
                input.nextLine(); // Adicionado para consumir o delimitador(Estava pulando o primeiro input do
                // nome)

                // Solicita e atualiza os dados do funcionário
                System.out.printf("\nDigite o nome caso queira alterar (atual: %s) ", funcionario.getNome());
                String nome = input.nextLine();
                if (!nome.isEmpty())
                    funcionario.setNome(nome);

                System.out.printf("\nDigite o email caso queira alterar (atual: %s) ", funcionario.getEmail());
                String email = input.nextLine();
                if (!email.isEmpty())
                    funcionario.setEmail(email);

                System.out.printf("\nDigite o salario caso queira alterar (atual: %.2f) ", funcionario.getSalario());
                double salario = Double.parseDouble(input.nextLine());
                if (salario != 0.0 &&  salario > 0)
                    funcionario.setSalario(salario);

                System.out.printf("\nDigite o cpf caso queira alterar (atual: %s) ", funcionario.getCPF());
               String cpf = input.nextLine();
                if (!cpf.isEmpty())
                    funcionario.setCPF(cpf);

                System.out.printf("\nDigite o tempo de trabalho caso queira alterar (atual: %d) ", funcionario.getMesesTrabalho());
                int mesesTrabalho = Integer.parseInt(input.nextLine());
                if (mesesTrabalho > 0)
                    funcionario.setMesesTrabalho(mesesTrabalho);

            }
        }
    }

    // Método para remover um funcionário
    public static void removerUsuario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        Funcionario funcionarioRemover = null; // Inicializa a variável do funcionário a ser removido

        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho da remoção de funcionário
        System.out.println("============================");
        System.out.println("     REMOVER USUÁRIO     ");
        System.out.println("============================");

        // Solicita o CPF do funcionário a ser removido
        System.out.println("Digite o CPF do usuário que deseja remover.");
        String cpfProcura = input.next();

        // Procura o funcionário pelo CPF
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){
            if (funcionario.getCPF().equals(cpfProcura)){
                funcionarioRemover = funcionario;
                break;
            }
        }

        if (funcionarioRemover != null) { // Verifica se o funcionário foi encontrado

            System.out.println("Funcionário encontrado! Deseja realmente remover? (s/n)");
            String confirmacao = input.next();

            if (confirmacao.equalsIgnoreCase("s")) {
                FuncionarioDB.remove(funcionarioRemover); // Remove o funcionário do banco de dados
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }

        }
    }

    // Método para buscar um funcionário pelo CPF
    public static void buscarUsuario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários


        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Solicita o CPF do funcionário a ser buscado
        System.out.println("Digite o CPF do usuário que deseja procurar.");
        String cpfProcura = input.next();

        // Procura o funcionário pelo CPF
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){
            if (funcionario.getCPF().equals(cpfProcura)){
                System.out.println("============================");
                System.out.println(funcionario.toString()); // Exibe os detalhes do funcionário
                System.out.println("============================");
            }
        }

    }
}
