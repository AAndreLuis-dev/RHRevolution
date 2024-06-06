package menu;

import entities.Funcionario;
import services.FolhaServices;
import services.FuncionarioServices;
import services.GerenteServices;

import java.util.Scanner;

public class Menu {

    public static void menuGeral() {

        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - ARÉA DE FUNCIONÁRIOS");
        System.out.println("[2] - ARÉA DE GERENTE");
        System.out.println("[3] - FOLHA DE PAGAMENTO");
        System.out.println("[4] - SAIR");
        System.out.print("Escolha uma opção: ");

        choice = input.nextInt();

        switch (choice) {
            case 1:
                menuFuncionario();
                break;
            case 2:
                menuGerente();
                break;
            case 3:
                menuFolha();
                break;

            default:
                System.out.println("Opção inválida");
                menuGeral();
        }
    }

    public static void menuFuncionario() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - CADASTRO DE FUNCIONÁRIOS");
        System.out.println("[2] - LISTAR FUNCIONARIOS CADASTRADOS");
        System.out.println("[3] - MODIFICAR FUNCIONÁRIOS");
        System.out.println("[4] - REMOVER FUNCIONÁRIOS");
        System.out.println("[5] - BUSCAR FUNCIONÁRIOS");
        System.out.println("[6] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                FuncionarioServices.cadastroUsuario();
                break;
            case 2:
                FuncionarioServices.mostrarUsuarios();
                break;
            case 3:
                FuncionarioServices.alterarUsuario();
                break;
            case 4:
                FuncionarioServices.removerUsuario();
                break;
            case 5:
                FuncionarioServices.buscarUsuario();
                break;
            case 6:
                menuGeral();
            default:
                System.out.println("Opcao invalida");
        }

        menuFuncionario();
    }

    public static void menuGerente() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - CADASTRO DE GERENTE");
        System.out.println("[2] - LISTAR TODOS OS USUÁRIOS CADASTRADOS");
        System.out.println("[3] - MODIFICAR GERENTES");
        System.out.println("[4] - REMOVER USUARIOS");
        System.out.println("[5] - BUSCAR GERENTE");
        System.out.println("[6] - VOLTAR");

        System.out.print("Escolha uma opção: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                GerenteServices.cadastroGerente();
                break;
            case 2:
                GerenteServices.mostrarGerentes();
                break;
            case 3:
                GerenteServices.alterarGerente();
                break;
            case 4:
                GerenteServices.removerGerente();
                break;
            case 5:
                GerenteServices.buscarGerente();
                break;
            case 6:
                menuGeral();
            default:
                System.out.println("Opcao invalida");
        }

        menuGerente();
    }

    public static void menuSetor() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - LISTAR SETORES");
        System.out.println("[2] - ADICIONAR FUNCIONARIOS NO SETOR");
        System.out.println("[2] - REMOVER SETORES");
        System.out.println("[4] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt();


    }


    public static void menuFolha() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - FOLHA DE FUNCIONARIOS");
        System.out.println("[2] - FOLHA DE GERENTE");
        System.out.println("[3] - FOLHA DE SETOR");
        System.out.println("[6] - SAIR");
        System.out.print("Escolha uma opção: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                FolhaServices.mostrarFolhaFuncionario();
                break;
            case 2:
                FolhaServices.mostrarFolhaGeremte();
                break;
            case 3:
                System.out.println("Teste");
                break;
            case 6:
                menuGeral();
                break;
            default:
                System.out.println("Opcao invalida");
        }

        menuFolha();

    }
}

