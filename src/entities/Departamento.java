package entities;

import collections.GerenteDB;

import java.util.ArrayList;

public class Departamento {

    private int id = 0;
    private static int proximoId;

    private final String nomeDepartamento;
    private String gerenteDepartamento;

    private final ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nomeDepartamento, String cpfGerente) {
        this.id = proximoId; // Atribui o valor de proximoId ao id do funcionário
        proximoId++; // Incrementa proximoId para o próximo funcionário
        this.nomeDepartamento = nomeDepartamento;

        GerenteDB gerenteDB = GerenteDB.getInstance();
        for (Gerente gerente : gerenteDB.getGerentes()) {
            if (gerente.getCPF().equals(cpfGerente)) {
                this.gerenteDepartamento = gerente.getNome();
                gerente.setDepartamento(nomeDepartamento);
            }
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public String getNomeDepartamento() { return this.nomeDepartamento;}

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public String getGerenteDepartamento() { return this.gerenteDepartamento;}

//    public int getNumeroPessoasDepartamento() {
//        int numeroPessoasDepartamento = 0;
//        for (Funcionario funcionario : funcionarios) {
//            numeroPessoasDepartamento++;
//        }
//        return numeroPessoasDepartamento;
//    }

    public String toString(){
       return String.format("Departamento: %s\n" +
                "Gerente do departamento: %s\n" +
                "Total de funcionarios no departamento: %d", this.nomeDepartamento, this.gerenteDepartamento, funcionarios.size());
    }

}
