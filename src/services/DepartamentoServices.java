package services;


import collections.DepartamentoDB;
import collections.FuncionarioDB;
import entities.Departamento;
import entities.Funcionario;

import java.util.Scanner;

public class DepartamentoServices {

    public static void  cadastrarDepartamento(String nome, String cpf) {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();

        departamentoDB.add(new Departamento(nome, cpf));
    }

    public static void cadastrarDepartamento() {

        Scanner input = new Scanner(System.in);

        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();

        System.out.println("===========================");
        System.out.println("  CADASTRO DE DEPARTAMENTO  ");
        System.out.println("===========================");

        System.out.println("digite o nome do departamento: ");
        String nome = input.nextLine();

        System.out.println("digite o cpf do gerente do departamento: ");
        String cpf = input.nextLine();

        departamentoDB.add(new Departamento(nome, cpf));
    }

    public static void listarDepartamentos(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        for (Departamento departamento: departamentoDB.getDepartamento()){
            System.out.println("===========================");
            System.out.println(departamento.toString());
            System.out.println("===========================");
        }
    }

    public static void cadastrarFuncionario() {
        Scanner input = new Scanner(System.in);
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();

        System.out.println("==========================================");
        System.out.println("  CADASTRO DE FUNCIONARIO NO DEPARTAMENTO");
        System.out.println("==========================================");

        System.out.println("Digite o nome do departamento: ");
        String nome = input.nextLine();

        System.out.println("Digite o CPF do funcionario a ser adicionado: ");
        String cpf = input.nextLine();

        for (Departamento departamento: departamentoDB.getDepartamento()){
            if (departamento.getNomeDepartamento().equalsIgnoreCase(nome)) {
                for (Funcionario funcionario: funcionarioDB.getFuncionarios()){
                    if (funcionario.getCPF().equals(cpf)) {
                        departamento.addFuncionario(funcionario);
                    }
                }
            }
        }
    }

    public static void cadastrarFuncionario(String nome, String cpf) {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();

        for (Departamento departamento: departamentoDB.getDepartamento()){
            if (departamento.getNomeDepartamento().equalsIgnoreCase(nome)) {
                for (Funcionario funcionario: funcionarioDB.getFuncionarios()){
                    if (funcionario.getCPF().equals(cpf)) {
                        departamento.addFuncionario(funcionario);
                    }
                }
            }
        }
    }


    public static void apagarDepartamento(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        Scanner input = new Scanner(System.in);
        Departamento departamentoRemover = null;

        System.out.println("===========================");
        System.out.println("    APAGAR DEPARTAMENTO    ");
        System.out.println("===========================");
        System.out.println("Digite o nome do departamento que deseja deletar: ");
        String nome = input.nextLine();

        System.out.println("Tem certeza?(S/N)");
        String resposta = input.nextLine();

        if (resposta.equalsIgnoreCase("S")){
            for (Departamento departamento: departamentoDB.getDepartamento()){
                if (departamento.getNomeDepartamento().equalsIgnoreCase(nome)){
                    departamentoRemover = departamento;
                }
            }
        }else {
            System.out.println("Operação cancelada");
            return;
        }

        if (departamentoRemover != null){
            System.out.println("Departamento removido com sucesso!");
            DepartamentoDB.remove(departamentoRemover);
        }
    }

}
