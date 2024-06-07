package entities;

import java.util.ArrayList;

public class Departamento {

    private int idDepartamento;
    private static int proximoId;
    private String nomeDepartamento;

    private static final ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nomeDepartamento) {}

    public String getNomeDepartamento() { return this.nomeDepartamento;}

}
