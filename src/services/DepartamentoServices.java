package services;


import collections.DepartamentoDB;
import collections.FuncionarioDB;
import entities.Departamento;
import entities.Funcionario;

import java.util.Scanner;

public class DepartamentoServices {


    // Método para cadastrar um departamento fornecendo diretamente o nome e CPF do gerente
    public static void  cadastrarDepartamento(String nome, String cpf) {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();// Obtém a instância do banco de dados de departamentos

        departamentoDB.add(new Departamento(nome, cpf));// Adiciona o novo departamento ao banco de dados

    }

    // Método para cadastrar um departamento solicitando dados do usuário
    public static void cadastrarDepartamento() {

        Scanner input = new Scanner(System.in);// Cria um scanner para ler a entrada do usuário

        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();// Obtém a instância do banco de dados de departamentos

        // Exibe o cabeçalho do cadastro de departamento
        System.out.println("===========================");
        System.out.println("  CADASTRO DE DEPARTAMENTO  ");
        System.out.println("===========================");

        // Solicita os dados do departamento
        System.out.println("digite o nome do departamento: ");
        String nome = input.nextLine();

        System.out.println("digite o cpf do gerente do departamento: ");
        String cpf = input.nextLine();

        // Adiciona o novo departamento ao banco de dados
        departamentoDB.add(new Departamento(nome, cpf));
    }

    // Método para listar todos os departamentos cadastrados
    public static void listarDepartamentos(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        for (Departamento departamento: departamentoDB.getDepartamento()){
            System.out.println("===========================");
            System.out.println(departamento.toString());
            System.out.println("===========================");
        }
    }

    // Método para cadastrar um funcionário em um departamento solicitando dados do usuário
    public static void cadastrarFuncionario() {
        Scanner input = new Scanner(System.in);// Cria um scanner para ler a entrada do usuário
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();// Obtém a instância do banco de dados de departamentos
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();// Obtém a instância do banco de dados de funcionários

        // Exibe o cabeçalho do cadastro de funcionário no departamento
        System.out.println("==========================================");
        System.out.println("  CADASTRO DE FUNCIONARIO NO DEPARTAMENTO");
        System.out.println("==========================================");

        // Solicita os dados do departamento e do funcionário
        System.out.println("Digite o nome do departamento: ");
        String nome = input.nextLine();

        System.out.println("Digite o CPF do funcionario a ser adicionado: ");
        String cpf = input.nextLine();

        // Procura o departamento pelo nome e adiciona o funcionário encontrado pelo CPF
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

    // Método para cadastrar um funcionário em um departamento fornecendo diretamente o nome do departamento e o CPF do funcionário
    public static void cadastrarFuncionario(String nome, String cpf) {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();// Obtém a instância do banco de dados de departamentos
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários

        // Procura o departamento pelo nome e adiciona o funcionário encontrado pelo CPF
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

    // Método para apagar um departamento
    public static void apagarDepartamento(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        Scanner input = new Scanner(System.in);
        Departamento departamentoRemover = null;

        // Exibe o cabeçalho da remoção de departamento
        System.out.println("===========================");
        System.out.println("    APAGAR DEPARTAMENTO    ");
        System.out.println("===========================");
        System.out.println("Digite o nome do departamento que deseja deletar: ");
        String nome = input.nextLine();

        // Confirma a operação de remoção
        System.out.println("Tem certeza?(S/N)");
        String resposta = input.nextLine();

        if (resposta.equalsIgnoreCase("S")){
            // Procura o departamento pelo nome e marca-o para remoção
            for (Departamento departamento: departamentoDB.getDepartamento()){
                if (departamento.getNomeDepartamento().equalsIgnoreCase(nome)){
                    departamentoRemover = departamento;
                }
            }
        }else {
            System.out.println("Operação cancelada");
            return;
        }

        // Remove o departamento se encontrado
        if (departamentoRemover != null){
            System.out.println("Departamento removido com sucesso!");
            DepartamentoDB.remove(departamentoRemover);
        }
    }

}
