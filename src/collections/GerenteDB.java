package collections;

import entities.Gerente;

import java.util.ArrayList;

public class GerenteDB {

    // Cria uma instância estática da classe GerenteDB, inicialmente nula
    private static GerenteDB instance = null;

    // Cria uma lista estática de objetos Gerente, inicializada como um ArrayList vazio
    private static final ArrayList<Gerente> gerentesDBS = new ArrayList<>();

    // Construtor privado para impedir a criação de novas instâncias fora da classe
    private GerenteDB() {}

    // Método estático que retorna a instância única da classe (Singleton)
    public static GerenteDB getInstance() {
        // Verifica se a instância é nula e, se for, cria uma nova instância
        if (instance == null) {
            instance = new GerenteDB();
        }
        return instance; // Retorna a instância única
    }

    // Método para adicionar um objeto Gerente à lista
    public void add(Gerente gerente) {
        gerentesDBS.add(gerente);
    }

    // Método para retornar a lista de gerentes
    public ArrayList<Gerente> getGerentes() {
        return gerentesDBS;
    }

    // Método estático para remover um objeto Gerente da lista
    public static void remove(Gerente gerente) {gerentesDBS.remove(gerente);
    }

}
