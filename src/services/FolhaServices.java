package services;

import collections.FuncionarioDB;
import collections.GerenteDB;
import entities.Funcionario;
import entities.Gerente;

import java.util.ArrayList;

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

}
