package services;

import collections.GerenteDB;
import entities.Gerente;

import java.util.Scanner;

public class GerenteServices {

    public static void cadastroGerente(Gerente gerente) {
        GerenteDB gerenteDB = GerenteDB.getInstance();
        gerenteDB.add(gerente);
    }

    public static void cadastroGerente() {

        Scanner input = new Scanner(System.in);

        GerenteDB gerenteDB = GerenteDB.getInstance();
        System.out.println("===========================");
        System.out.println("  CADASTRO DE GERENTE  ");
        System.out.println("===========================");

        System.out.println("Digite o nome do gerente");
        String nome = input.nextLine();

        System.out.println("Digite o email do gerente");
        String email = input.nextLine();

        System.out.println("Digite o salario do gerente");
        double salario = input.nextDouble();

        System.out.println("Digite o CPF do gerente");
        String cpf = input.nextLine();

        System.out.println("Digite o bonus do gerente");
        double bonus = input.nextDouble();

        System.out.println("Digite o departamento do gerente");
        String departamento = input.nextLine();

        System.out.println("Digite os meses de experiência gerencial do gerente");
        int mesesExperienciaGerencial = input.nextInt();

        gerenteDB.add(new Gerente(nome, email, salario, cpf, bonus, departamento, mesesExperienciaGerencial));
    }

    public static void mostrarGerentes() {
        GerenteDB gerenteDB = GerenteDB.getInstance();
        for (Gerente gerente : gerenteDB.getGerentes()){
            System.out.println("=====================================");
            System.out.println(gerente.toString(1));
            System.out.println("=====================================");
        }
    }

    public static void alterarGerente() {
        GerenteDB gerenteDB = GerenteDB.getInstance();
        Scanner input = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     MODIFICAR GERENTES     ");
        System.out.println("============================");

        System.out.println("Digite o cpf do gerente que deseja fazer alterações.");
        String cpfProcura = input.next();

        for (Gerente gerente : gerenteDB.getGerentes()){

            if (gerente.getCPF().equals(cpfProcura)){
                System.out.println("GERENTE ENCONTRADO!");
                input.nextLine();

                System.out.printf("\nDigite o nome caso queira alterar (atual: %s) ", gerente.getNome());
                String nome = input.nextLine();
                if (!nome.isEmpty())
                    gerente.setNome(nome);

                System.out.printf("\nDigite o email caso queira alterar (atual: %s) ", gerente.getEmail());
                String email = input.nextLine();
                if (!email.isEmpty())
                    gerente.setEmail(email);

                System.out.printf("\nDigite o salario caso queira alterar (atual: %.2f) ", gerente.getSalario());
                double salario = Double.parseDouble(input.nextLine());
                if (salario != 0.0 &&  salario > 0)
                    gerente.setSalario(salario);

                System.out.printf("\nDigite o cpf caso queira alterar (atual: %s) ", gerente.getCPF());
                String cpf = input.nextLine();
                if (!cpf.isEmpty())
                    gerente.setCPF(cpf);

                System.out.printf("\nDigite o bonus caso queira alterar (atual: %.2f) ", gerente.getBonus());
                double bonus = Double.parseDouble(input.nextLine());
                if (bonus != 0.0 &&  bonus > 0)
                    gerente.setBonus(bonus);

                System.out.printf("\nDigite o departamento caso queira alterar (atual: %s) ", gerente.getDepartamento());
                String departamento = input.nextLine();
                if (!departamento.isEmpty())
                    gerente.setDepartamento(departamento);

                System.out.printf("\nDigite os meses de experiência gerencial caso queira alterar (atual: %d) ", gerente.getMesesExperienciaGerencial());
                int mesesExperienciaGerencial = Integer.parseInt(input.nextLine());
                if (mesesExperienciaGerencial != 0 &&  mesesExperienciaGerencial > 0)
                    gerente.setMesesExperienciaGerencial(mesesExperienciaGerencial);

            }
        }
    }

    public static void removerGerente(){
        GerenteDB gerenteDB = GerenteDB.getInstance();
        Gerente gerenteRemover = null;

        Scanner input = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     REMOVER GERENTE     ");
        System.out.println("============================");


        System.out.println("Digite o CPF do gerente que deseja remover.");
        String cpfProcura = input.next();

        for (Gerente gerente : gerenteDB.getGerentes()){
            if (gerente.getCPF().equals(cpfProcura)){
                gerenteRemover = gerente;
                break;
            }
        }

        if (gerenteRemover != null) {

            System.out.println("Gerente encontrado! Deseja realmente remover? (s/n)");
            String confirmacao = input.next();

            if (confirmacao.equalsIgnoreCase("s")) {
                GerenteDB.remove(gerenteRemover);
                System.out.println("Gerente removido com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }

        }
    }

    public static void buscarGerente(){
        GerenteDB gerenteDB = GerenteDB.getInstance();

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do gerente que deseja buscar.");
        String cpfProcura = input.next();

        for (Gerente gerente : gerenteDB.getGerentes()){
            if (gerente.getCPF().equals(cpfProcura)){
                System.out.println("============================");
                System.out.println(gerente.toString());
                System.out.println("============================");
            }
        }

    }
}
