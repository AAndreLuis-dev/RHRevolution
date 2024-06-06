package services;

import collections.FuncionarioDB;
import entities.Funcionario;

import java.util.Scanner;

public class FuncionarioServices {

    public static void cadastroUsuario(Funcionario funcionario) {
        FuncionarioDB funcionarioDB =  FuncionarioDB.getInstance();
        funcionarioDB.add(funcionario);
    }

    public static void cadastroUsuario() {

        Scanner input = new Scanner(System.in);

        FuncionarioDB funcionarioDB =  FuncionarioDB.getInstance();
        System.out.println("===========================");
        System.out.println("  CADASTRO DE FUNCIONARIO  ");
        System.out.println("===========================");

        System.out.println("Digite o nome do funcionario");
        String nome = input.nextLine();

        System.out.println("Digite o email do funcionario");
        String email = input.nextLine();

        System.out.println("Digite o salario do funcionario");
        double salario = input.nextDouble();

        System.out.println("Digite o CPF do funcionario");
        String cpf = input.nextLine();

        System.out.println("Digite o tempo de trabalho em meses");
        int mesesTrabalho = input.nextInt();


        funcionarioDB.add(new Funcionario(nome, email, salario, cpf, mesesTrabalho));
    }

    public static void mostrarUsuarios() {
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){
            System.out.println("=====================================");
            System.out.println(funcionario.toString(1));
            System.out.println("=====================================");
        }
    }

    public static void alterarUsuario() {
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        Scanner input = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     MODIFICAR USUÁRIOS     ");
        System.out.println("============================");

        System.out.println("Digite o cpf do usuário que deseja fazer alterações.");
        String cpfProcura = input.next();

        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){

            if (funcionario.getCPF().equals(cpfProcura)){
                System.out.println("FUNCIONARIO ENCONTRADO!");
                input.nextLine(); // Adicionado para consumir o delimitador(Estava pulando o primeiro input do
                // nome)

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

    public static void removerUsuario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        Funcionario funcionarioRemover = null;

        Scanner input = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     REMOVER USUÁRIO     ");
        System.out.println("============================");


        System.out.println("Digite o CPF do usuário que deseja remover.");
        String cpfProcura = input.next();

        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){
            if (funcionario.getCPF().equals(cpfProcura)){
                funcionarioRemover = funcionario;
                break;
            }
        }

        if (funcionarioRemover != null) {

            System.out.println("Funcionário encontrado! Deseja realmente remover? (s/n)");
            String confirmacao = input.next();

            if (confirmacao.equalsIgnoreCase("s")) {
                FuncionarioDB.remove(funcionarioRemover);
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }

        }
    }

    public static void buscarUsuario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF do usuário que deseja procurar.");
        String cpfProcura = input.next();

        for (Funcionario funcionario : funcionarioDB.getFuncionarios()){
            if (funcionario.getCPF().equals(cpfProcura)){
                System.out.println("============================");
                System.out.println(funcionario.toString());
                System.out.println("============================");
            }
        }

    }
}
