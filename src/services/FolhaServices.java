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


    public static void mostrarFolhaFuncionario(){
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        double salarioTotal = 0;

        for (Funcionario funcionario : funcionarioDB.getFuncionarios()) {
            System.out.println("============================");
            System.out.println(funcionario.toString());
            salarioTotal += funcionario.getSalario();
            System.out.println("============================");
        }

        System.out.printf("Salario Total dos funcionarios: %.2f \n" , salarioTotal);
    }

    public static void mostrarFolhaGeremte(){
        GerenteDB gerenteDB = GerenteDB.getInstance();
        double salarioTotal = 0;


        for (Gerente gerente : gerenteDB.getGerentes()) {
            System.out.println("============================");
            System.out.println(gerente.toString());
            salarioTotal += gerente.getSalario();
            System.out.println("============================");
        }

        System.out.printf("Salario Total dos gerentes: %.2f \n" , salarioTotal);
    }

    public static void mostrarFolhaDepartamento(){
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        FuncionarioDB funcionarioDB = FuncionarioDB.getInstance();
        GerenteDB gerenteDB = GerenteDB.getInstance();

        for (Departamento departamento: departamentoDB.getDepartamento()){
            double salarioTotal = 0;
            System.out.println("============================");
            System.out.println("Nome do setor: " + departamento.getNomeDepartamento());
            System.out.println("Gerente do setor: " + departamento.getGerenteDepartamento());
            // Adiciona o salário do gerente ao total
            for (Gerente gerente : gerenteDB.getGerentes()) {
                if (gerente.getNome().equals(departamento.getGerenteDepartamento())) {
                    salarioTotal += gerente.getSalario();
                }
            }
            System.out.println("Funcionarios do setor: ");
            for (Funcionario funcionario : departamento.getFuncionarios()) {
                System.out.println(funcionario.getNome());
                salarioTotal += funcionario.getSalario();
            }
            System.out.println("Total gasto no setor: " + salarioTotal);
            System.out.println("============================");
        }
    }

    public static void setBonusDepartamento() {
        DepartamentoDB departamentoDB = DepartamentoDB.getInstance();
        GerenteDB gerenteDB = GerenteDB.getInstance();
        double salarioTotal = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("    BONUS PARA DEPARTAMENTO    ");
        System.out.println("===============================");

        System.out.println("Digite o nome do departamento: ");
        String nomeDepartamento = input.nextLine();

        System.out.println("Digite o bonus percentual do aumento: ");
        double bonusPercentual = input.nextDouble();

        for (Departamento departamento : departamentoDB.getDepartamento()) {
            if (departamento.getNomeDepartamento().equalsIgnoreCase(nomeDepartamento)) {
                System.out.println("============================");
                System.out.println("Nome do setor: " + departamento.getNomeDepartamento());
                System.out.println("Gerente do setor: " + departamento.getGerenteDepartamento());
                // Adiciona o salário do gerente ao total
                for (Gerente gerente : gerenteDB.getGerentes()) {
                    if (gerente.getNome().equals(departamento.getGerenteDepartamento())) {
                        salarioTotal += gerente.getSalario();
                    }
                }
                System.out.println("Funcionarios do setor: ");
                for (Funcionario funcionario : departamento.getFuncionarios()) {
                    double salarioAntes = funcionario.getSalario();
                    double salarioComBonus = salarioAntes * (1 + bonusPercentual / 100);
                    System.out.println(funcionario.getNome() + " - Salario antes: " + salarioAntes + ", Salario pos bonus: " + salarioComBonus);
                    salarioTotal += salarioComBonus;
                }
                System.out.println("Total gasto no setor pos bonus: " + salarioTotal);
                System.out.println("============================");
            }
        }
    }


}
