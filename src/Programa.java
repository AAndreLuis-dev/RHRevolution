import collections.FuncionarioDB;
import entities.Funcionario;
import menu.Menu;
import services.FuncionarioServices;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Programa {
    public static void main(String[] args) {

        // Cadastro previo
        FuncionarioServices.cadastroUsuario(new Funcionario("Rodson", "Rodzinho@gmail.com", 800, "123123-23"));


        System.out.println("\n" +
                " /$$$$$$$  /$$   /$$       /$$$$$$$  /$$$$$$$$/$$    /$$  /$$$$$$  /$$       /$$   /$$ /$$$$$$$$/$$$$$$  /$$$$$$  /$$   /$$\n" +
                "| $$__  $$| $$  | $$      | $$__  $$| $$_____/ $$   | $$ /$$__  $$| $$      | $$  | $$|__  $$__/_  $$_/ /$$__  $$| $$$ | $$\n" +
                "| $$  \\ $$| $$  | $$      | $$  \\ $$| $$     | $$   | $$| $$  \\ $$| $$      | $$  | $$   | $$    | $$  | $$  \\ $$| $$$$| $$\n" +
                "| $$$$$$$/| $$$$$$$$      | $$$$$$$/| $$$$$  |  $$ / $$/| $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$ $$ $$\n" +
                "| $$__  $$| $$__  $$      | $$__  $$| $$__/   \\  $$ $$/ | $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$  $$$$\n" +
                "| $$  \\ $$| $$  | $$      | $$  \\ $$| $$       \\  $$$/  | $$  | $$| $$      | $$  | $$   | $$    | $$  | $$  | $$| $$\\  $$$\n" +
                "| $$  | $$| $$  | $$      | $$  | $$| $$$$$$$$  \\  $/   |  $$$$$$/| $$$$$$$$|  $$$$$$/   | $$   /$$$$$$|  $$$$$$/| $$ \\  $$\n" +
                "|__/  |__/|__/  |__/      |__/  |__/|________/   \\_/     \\______/ |________/ \\______/    |__/  |______/ \\______/ |__/  \\__/\n" +
                "                                                                                                                           \n" +
                "                                                                                                                           \n" +
                "                                                                                                                           \n");

        Menu.menuGeral();

    }

}