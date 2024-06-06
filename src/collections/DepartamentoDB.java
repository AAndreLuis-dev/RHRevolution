package collections;

import entities.Departamento;

import java.util.ArrayList;

public class DepartamentoDB {

    // Cria uma instância estática da classe DepartamentoDB, inicialmente nula
    private static DepartamentoDB instance = null;

    // Cria uma lista estática de objetos departamento, inicializada como um ArrayList vazio
    private static final ArrayList<Departamento> DepartamentoDBS = new ArrayList<>();

    // Construtor privado para impedir a criação de novas instâncias fora da classe
    private DepartamentoDB() {}

    // Método estático que retorna a instância única da classe (Singleton)
    public static DepartamentoDB getInstance() {
        // Verifica se a instância é nula e, se for, cria uma nova instância
        if (instance == null) {
            instance = new DepartamentoDB();
        }
        return instance;
    }

    // Método para adicionar um objeto departamento à lista
    public void add(Departamento departamento) {
        DepartamentoDBS.add(departamento);
    }

    // Método para retornar a lista de funcionários
    public ArrayList<Departamento> getDepartamento() {
        return DepartamentoDBS;
    }

    // Método estático para remover um objeto Funcionario da lista
    public static void remove(Departamento departamento) {
        DepartamentoDBS.remove(departamento);
    }
}
