package menu;

import entities.Funcionario;
import services.DepartamentoServices;
import services.FolhaServices;
import services.FuncionarioServices;
import services.GerenteServices;

import java.util.Scanner;

public class Menu {

    // Método estático para exibir o menu geral
    public static void menuGeral() {

        int choice = 0; // Variável para armazenar a escolha do usuário
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho do menu
        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        // Exibe as opções do menu
        System.out.println("[1] - ARÉA DE FUNCIONÁRIOS");
        System.out.println("[2] - ARÉA DE GERENTE");
        System.out.println("[3] - ARÉA  DE DEPARTAMENTO");
        System.out.println("[4] - FOLHA DE PAGAMENTO");
        System.out.println("[5] - SAIR");
        System.out.print("Escolha uma opção: ");

        choice = input.nextInt(); // Lê a escolha do usuário

        // Executa a ação correspondente à escolha do usuário
        switch (choice) {
            case 1:
                menuFuncionario(); // Chama o menu de funcionários
                break;
            case 2:
                menuGerente(); // Chama o menu de gerentes
                break;
            case 3:
                menuDepartamento();
                break;
            case 4:
                menuFolha();
            case 5:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opção inválida");
                menuGeral(); // Retorna ao menu geral
        }

    }

    // Método estático para exibir o menu de funcionários
    public static void menuFuncionario() {
        int choice = 0; // Variável para armazenar a escolha do usuário
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho do menu
        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");

        // Exibe as opções do menu
        System.out.println("[1] - CADASTRO DE FUNCIONÁRIOS");
        System.out.println("[2] - LISTAR FUNCIONARIOS CADASTRADOS");
        System.out.println("[3] - MODIFICAR FUNCIONÁRIOS");
        System.out.println("[4] - REMOVER FUNCIONÁRIOS");
        System.out.println("[5] - BUSCAR FUNCIONÁRIOS");
        System.out.println("[6] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt(); // Lê a escolha do usuário

        // Executa a ação correspondente à escolha do usuário
        switch (choice) {
            case 1:
                FuncionarioServices.cadastroUsuario(); // Chama o serviço de cadastro de funcionários
                break;
            case 2:
                FuncionarioServices.mostrarUsuarios(); // Chama o serviço de listagem de funcionários
                break;
            case 3:
                FuncionarioServices.alterarUsuario(); // Chama o serviço de modificação de funcionários
                break;
            case 4:
                FuncionarioServices.removerUsuario(); // Chama o serviço de remoção de funcionários
                break;
            case 5:
                FuncionarioServices.buscarUsuario(); // Chama o serviço de busca de funcionários
                break;
            case 6:
                menuGeral();  // Volta ao menu geral
            default:
                System.out.println("Opcao invalida");
        }

        menuFuncionario(); // Retorna ao menu de funcionários
    }

    // Método estático para exibir o menu de gerentes
    public static void menuGerente() {
        int choice = 0; // Variável para armazenar a escolha do usuário
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho do menu
        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");

        // Exibe as opções do menu
        System.out.println("[1] - CADASTRO DE GERENTE");
        System.out.println("[2] - LISTAR TODOS OS USUÁRIOS CADASTRADOS");
        System.out.println("[3] - MODIFICAR GERENTES");
        System.out.println("[4] - REMOVER USUARIOS");
        System.out.println("[5] - BUSCAR GERENTE");
        System.out.println("[6] - VOLTAR");

        System.out.print("Escolha uma opção: ");
        choice = input.nextInt(); // Lê a escolha do usuário

        // Executa a ação correspondente à escolha do usuário
        switch (choice) {
            case 1:
                GerenteServices.cadastroGerente(); // Chama o serviço de cadastro de gerentes
                break;
            case 2:
                GerenteServices.mostrarGerentes(); // Chama o serviço de listagem de gerentes
                break;
            case 3:
                GerenteServices.alterarGerente(); // Chama o serviço de modificação de gerentes
                break;
            case 4:
                GerenteServices.removerGerente(); // Chama o serviço de remoção de gerentes
                break;
            case 5:
                GerenteServices.buscarGerente(); // Chama o serviço de busca de gerentes
                break;
            case 6:
                menuGeral(); // Volta ao menu geral
            default:
                System.out.println("Opcao invalida"); // Mensagem para escolha inválida
        }

        menuGerente(); // Retorna ao menu de gerentes
    }

    public static void menuDepartamento() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - CADASTRAR DEPARTAMENTO");
        System.out.println("[2] - LISTAR DEPARTAMENTO");
        System.out.println("[3] - ADICIONAR FUNCIONARIOS NO DEPARTAMENTO");
        System.out.println("[4] - REMOVER DEPARTAMENTO");
        System.out.println("[5] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                DepartamentoServices.cadastrarDepartamento();
                break;
            case 2:
                DepartamentoServices.listarDepartamentos();
                break;
            case 3:
                DepartamentoServices.cadastrarFuncionario();
                break;
            case 4:
                DepartamentoServices.apagarDepartamento();
                break;
            case 5:
                menuGeral();
                break;
            default:
                System.out.println("Opcao invalida");
        }

        menuDepartamento();

    }


    public static void menuFolha() {
        int choice = 0;  // Variável para armazenar a escolha do usuário
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho do menu
        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        // Exibe as opções do menu
        System.out.println("[1] - FOLHA DE FUNCIONARIOS");
        System.out.println("[2] - FOLHA DE GERENTE");
        System.out.println("[3] - FOLHA DE DEPARTAMENTO");
        System.out.println("[4] - DAR BONUS");
        System.out.println("[5] - ORDENAR FUNCIONARIOS POR SALARIO");
        System.out.println("[6] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt(); // Lê a escolha do usuário


        switch (choice) {
            case 1:
                FolhaServices.mostrarFolhaFuncionario();
                break;
            case 2:
                FolhaServices.mostrarFolhaGeremte();
                break;
            case 3:
                FolhaServices.mostrarFolhaDepartamento();
                break;
            case 4:
                FolhaServices.setBonusDepartamento();
                break;
            case 5:
                FolhaServices.ordenarFuncionarios();
                break;
            case 6:
                menuGeral();
            default:
                System.out.println("Opcao invalida");
        }

        menuFolha();

    }
}

