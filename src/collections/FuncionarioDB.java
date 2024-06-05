package collections;

import entities.Funcionario;

import java.util.ArrayList;

public class FuncionarioDB {

    private static FuncionarioDB instance = null;
    private static final ArrayList<Funcionario> funcionarioDBS = new ArrayList<>();

    private FuncionarioDB() {}

    public static FuncionarioDB getInstance() {
        if (instance == null) {
            instance = new FuncionarioDB();
        }
        return instance;
    }

    public void add(Funcionario funcionario) {
        funcionarioDBS.add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarioDBS;
    }

    public static void remove(Funcionario funcionario) {
        funcionarioDBS.remove(funcionario);
    }

}
