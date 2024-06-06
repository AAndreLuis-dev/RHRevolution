package collections;

import entities.Funcionario;

import java.util.ArrayList;

public class FuncionarioDB {

    // Cria uma instância estática da classe FuncionarioDB, inicialmente nula
    private static FuncionarioDB instance = null;

    // Cria uma lista estática de objetos Funcionario, inicializada como um ArrayList vazio
    private static final ArrayList<Funcionario> funcionarioDBS = new ArrayList<>();

    // Construtor privado para impedir a criação de novas instâncias fora da classe
    private FuncionarioDB() {}

    // Método estático que retorna a instância única da classe (Singleton)
    public static FuncionarioDB getInstance() {
        // Verifica se a instância é nula e, se for, cria uma nova instância
        if (instance == null) {
            instance = new FuncionarioDB();
        }
        return instance;
    }

    // Método para adicionar um objeto Funcionario à lista
    public void add(Funcionario funcionario) {
        funcionarioDBS.add(funcionario);
    }

    // Método para retornar a lista de funcionários
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarioDBS;
    }

    // Método estático para remover um objeto Funcionario da lista
    public static void remove(Funcionario funcionario) {
        funcionarioDBS.remove(funcionario);
    }

}
