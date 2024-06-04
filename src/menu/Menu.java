package menu;

import java.util.Scanner;

public class Menu {

    public static void menuGeral(){

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
                System.out.println("BETA");
                break;
            default:
                return;
        }
    }

}
