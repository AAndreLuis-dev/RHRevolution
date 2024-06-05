package collections;

import entities.Gerente;

import java.util.ArrayList;

public class GerenteDB {

    private static GerenteDB instance = null;
    private static final ArrayList<Gerente> gerentesDBS = new ArrayList<>();

    private GerenteDB() {}

    public static GerenteDB getInstance() {
        if (instance == null) {
            instance = new GerenteDB();
        }
        return instance;
    }

    public void add(Gerente gerente) {
        gerentesDBS.add(gerente);
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentesDBS;
    }

    public static void remove(Gerente gerente) {
        gerentesDBS.remove(gerente);
    }

}
