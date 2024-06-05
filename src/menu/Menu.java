package menu;

import entities.Funcionario;
import services.FuncionarioServices;

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
            default:
        }
    }

    public static void menuFuncionario() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("            RH REVOLUTION             ");
        System.out.println("=====================================");
        System.out.println("[1] - CADASTRO DE FUNCIONÁRIOS");
        System.out.println("[2] - LISTAR USUÁRIOS CADASTRADOS");
        System.out.println("[3] - MODIFICAR USUARIOS");
        System.out.println("[4] - REMOVER USUARIOS");
        System.out.println("[5] - BUSCAR USUARIOS");
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
        System.out.println("[3] - MODIFICAR USUARIOS");
        System.out.println("[4] - REMOVER USUARIOS");
        System.out.println("[5] - BUSCAR AVANÇADA");
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

}
