import collections.FuncionarioDB;
import entities.Funcionario;
import entities.Gerente;
import menu.Menu;
import services.FuncionarioServices;
import services.GerenteServices;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Programa {
    public static void main(String[] args) {

        //Cadastro previo funcionario

        LocalDate dataBase = LocalDate.of(1992, 1, 1);
        FuncionarioServices.cadastroUsuario(new Funcionario("Rodson", "Rodzinho@gmail.com", 800, "123123-23", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Lou", "clarinha@gmail.com", 750, "90312344-21", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Gabriel", "gaybrielhackerzin@gmail.com", 1300, "7233573-67", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Catarina", "catcatgoth@gmail.com", 750, "85123051-13", dataBase));
        FuncionarioServices.cadastroUsuario(new Funcionario("Alice", "miawmiawUwU@gmail.com", 600, "75772343-65", dataBase));

        //Cadastro gerente
        GerenteServices.cadastroGerente(new Gerente("Andre", "aandreluis.a.a@gmail.com", 16000, "4000289-22", 20, 42, dataBase));
        GerenteServices.cadastroGerente(new Gerente("ARTUR HENRIQUE KRONBAUER", "arturKronbauer@gmail.com", 10000, "85422024-06", 10, 82, dataBase));


        System.out.println("\n" +
                " /$$$$$$$  /$$   /$$       /$$$$$$$  /$$$$$$$$/$$    /$$  /$$$$$$  /$$       /$$   /$$ /$$$$$$$$/$$$$$$  /$$$$$$  /$$   /$$\n" +
                "| $$__  $$| $$  | $$      | $$__  $$| $$_____/ $$   | $$ /$$__  $$| $$      | $$  | $$|__  $$__/_  $$_/ /$$__  $$| $$$ | $$\n" +
                "| $$  \\ $$| $$  | $$      | $$  \\ $$| $$     | $$   | $$| $$  \\ $$| $$      | $$  | $$   | $$    | $$  | $$  \\ $$| $$$$| $$\n" +
                "| $$$$$$$/| $$$$$$$$      | $$$$$$$/| $$$$$  |  $$ / $$/| $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$ $$ $$\n" +
                "| $$__  $$| $$__  $$      | $$__  $$| $$__/   \\  $$ $$/ | $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$  $$$$\n" +
                "| $$  \\ $$| $$  | $$      | $$  \\ $$| $$       \\  $$$/  | $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$\\  $$$\n" +
                "| $$  | $$| $$  | $$      | $$  | $$| $$$$$$$$  \\  $/   |  $$$$$$/| $$$$$$$$|  $$$$$$/   | $$   /$$$$$$|  $$$$$$/| $$ \\  $$\n" +
                "|__/  |__/|__/  |__/      |__/  |__/|________/   \\_/     \\______/ |________/ \\______/    |__/  |______/ \\______/ |__/  \\__/\n");

        Menu.menuGeral();

    }

}