package services;

import collections.DepartamentoDB;
import collections.FuncionarioDB;
import collections.GerenteDB;
import entities.Departamento;
import entities.Funcionario;
import entities.Gerente;

import java.util.ArrayList;
import java.util.Scanner;

public class FolhaServices {

    // Método para mostrar a folha de pagamento de todos os funcionários
    public static void mostrarFolhaFuncionario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance(); // Obtém a instância do banco de dados de funcionários
        double salarioTotal = 0;

        // Itera sobre todos os funcionários, exibe suas informações e soma seus salários
        for (Funcionario funcionario : funcionarioDB.getFuncionarios()) {
            System.out.println("============================");
            System.out.println(funcionario.toString());
            salarioTotal += funcionario.getSalario();
            System.out.println("============================");
        }

        // Exibe o salário total dos funcionários
        System.out.printf("Salario Total dos funcionarios: %.2f \n" , salarioTotal);
    }

    // Método para mostrar a folha de pagamento de todos os gerentes
    public static void mostrarFolhaGeremte(){
        GerenteDB gerenteDB = GerenteDB.getInstance();
        double salarioTotal = 0;

        // Itera sobre todos os gerentes, exibe suas informações e soma seus salários
        for (Gerente gerente : gerenteDB.getGerentes()) {
            System.out.println("============================");
            System.out.println(gerente.toString());
            salarioTotal += gerente.getSalario();
            System.out.println("============================");
        }

        // Exibe o salário total dos gerentes
        System.out.printf("Salario Total dos gerentes: %.2f \n" , salarioTotal);
    }

    // Método para mostrar a folha de pagamento de todos os departamentos
    public static void mostrarFolhaDepartamento(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        GerenteDB gerenteDB = GerenteDB.getInstance();

        // Itera sobre todos os departamentos
        for (Departamento departamento: departamentoDB.getDepartamento()){
            double salarioTotal = 0;
            System.out.println("============================");
            System.out.println("Nome do setor: " + departamento.getNomeDepartamento());
            System.out.println("Gerente do setor: " + departamento.getGerenteDepartamento());

            // Adiciona o salário do gerente ao total, se o gerente estiver associado ao departamento
            for (Gerente gerente : gerenteDB.getGerentes()) {
                if (gerente.getNome().equals(departamento.getGerenteDepartamento())) {
                    salarioTotal += gerente.getSalario();
                }
            }

            // Exibe os funcionários do departamento e soma seus salários ao total
            System.out.println("Funcionarios do setor: ");
            for (Funcionario funcionario : departamento.getFuncionarios()) {
                System.out.println(funcionario.getNome());
                salarioTotal += funcionario.getSalario();
            }

            // Exibe o total gasto no departamento
            System.out.println("Total gasto no setor: " + salarioTotal);
            System.out.println("============================");
        }
    }

    // Método para definir um bônus percentual para todos os funcionários de um departamento
    public static void setBonusDepartamento() {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance(); // Obtém a instância do banco de dados de departamentos
        GerenteDB gerenteDB = GerenteDB.getInstance();// Obtém a instância do banco de dados de gerentes
        double salarioTotal = 0;

        Scanner input = new Scanner(System.in);// Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho para a aplicação do bônus
        System.out.println("===============================");
        System.out.println("    BONUS PARA DEPARTAMENTO    ");
        System.out.println("===============================");

        // Solicita o nome do departamento e o percentual de bônus ao usuário
        System.out.println("Digite o nome do departamento: ");
        String nomeDepartamento = input.nextLine();

        System.out.println("Digite o bonus percentual do aumento: ");
        double bonusPercentual = input.nextDouble();

        // Itera sobre os departamentos e aplica o bônus se o departamento corresponder ao nome fornecido
        for (Departamento departamento : departamentoDB.getDepartamento()) {
            if (departamento.getNomeDepartamento().equalsIgnoreCase(nomeDepartamento)) {
                System.out.println("============================");
                System.out.println("Nome do setor: " + departamento.getNomeDepartamento());
                System.out.println("Gerente do setor: " + departamento.getGerenteDepartamento());
                // Adiciona o salário do gerente ao total, se o gerente estiver associado ao departamento
                for (Gerente gerente : gerenteDB.getGerentes()) {
                    if (gerente.getNome().equals(departamento.getGerenteDepartamento())) {
                        salarioTotal += gerente.getSalario();
                    }
                }

                // Exibe os funcionários do departamento, aplica o bônus e soma os salários com bônus ao total
                System.out.println("Funcionarios do setor: ");
                for (Funcionario funcionario : departamento.getFuncionarios()) {
                    double salarioAntes = funcionario.getSalario();
                    double salarioComBonus = salarioAntes * (1 + bonusPercentual / 100);
                    System.out.println(funcionario.getNome() + " - Salario antes: " + salarioAntes + ", Salario pos bonus: " + salarioComBonus);
                    salarioTotal += salarioComBonus;
                }

                // Exibe o total gasto no departamento após a aplicação do bônus
                System.out.println("Total gasto no setor pos bonus: " + salarioTotal);
                System.out.println("============================");
            }
        }
    }

    public static void ordenarFuncionarios(){
        // Obtém a instância do banco de dados de funcionários
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        // Obtém a instância do banco de dados de gerentes
        GerenteDB gerenteDB = GerenteDB.getInstance();

        // Cria uma nova lista de funcionários e ordena com base no salário em ordem decrescente
        ArrayList<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarioDB.getFuncionarios());
        funcionariosOrdenados.sort((f1, f2) -> Double.compare(f2.getSalario(), f1.getSalario()));

        System.out.println("============================");
        System.out.println("Funcionarios ordenados por salario:");
        // Itera sobre a lista de funcionários ordenados e imprime o nome e o salário de cada funcionário
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario.getNome() + " - Salario: " + funcionario.getSalario());
        }
        System.out.println("============================");

        // Cria uma nova lista de gerentes e ordena com base no salário em ordem decrescente
        ArrayList<Gerente> gerentesOrdenados = new ArrayList<>(gerenteDB.getGerentes());
        gerentesOrdenados.sort((g1, g2) -> Double.compare(g2.getSalario(), g1.getSalario()));

        System.out.println("============================");
        System.out.println("Gerentes ordenados por salario:");
        // Itera sobre a lista de gerentes ordenados e imprime o nome e o salário de cada gerente
        for (Gerente gerente : gerentesOrdenados) {
            System.out.println(gerente.getNome() + " - Salario: " + gerente.getSalario());
        }
        System.out.println("============================");
    }

}
