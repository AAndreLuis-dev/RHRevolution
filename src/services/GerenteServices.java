package services;

import collections.GerenteDB;
import entities.Gerente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GerenteServices {

    // Método para cadastrar um gerente fornecendo diretamente o objeto Gerente
    public static void cadastroGerente(Gerente gerente) {
        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes
        gerenteDB.add(gerente); // Adiciona o gerente ao banco de dados
    }

    // Método para cadastrar um gerente solicitando dados do usuário
    public static void cadastroGerente() {

        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes
        // Exibe o cabeçalho do cadastro de gerente
        System.out.println("===========================");
        System.out.println("  CADASTRO DE GERENTE  ");
        System.out.println("===========================");

        // Solicita os dados do gerente
        System.out.println("Digite o nome do gerente");
        String nome = input.nextLine();

        System.out.println("Digite o email do gerente");
        String email = input.nextLine();

        System.out.println("Digite o salario do gerente");
        double salario = Double.parseDouble(input.nextLine()); // Consome a linha pendente

        System.out.println("Digite o CPF do gerente");
        String cpf = input.nextLine();

        System.out.println("Digite o bonus do gerente");
        double bonus = Double.parseDouble(input.nextLine()); // Consome a linha pendente

        System.out.println("Digite os meses de experiência gerencial do gerente");
        int mesesExperienciaGerencial = Integer.parseInt(input.nextLine());

        System.out.println("Digite a data de contratação (dd/mm/yyyy)");
        String dataContratado = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataContratadoLocalDate = null;
        dataContratadoLocalDate = LocalDate.parse(dataContratado, formatter);

        // Adiciona o novo gerente ao banco de dados
        gerenteDB.add(new Gerente(nome, email, salario, cpf, bonus, mesesExperienciaGerencial, dataContratadoLocalDate));
    }

    // Método para mostrar todos os gerentes cadastrados
    public static void mostrarGerentes() {
        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes
        // Itera sobre todos os gerentes e exibe seus detalhes
        for (Gerente gerente : gerenteDB.getGerentes()){
            System.out.println("=====================================");
            System.out.println(gerente.toString(1)); // Exibe os detalhes do gerente
            System.out.println("=====================================");
        }
    }

    // Método para alterar os dados de um gerente
    public static void alterarGerente() {
        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes
        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho da modificação de gerentes
        System.out.println("============================");
        System.out.println("     MODIFICAR GERENTES     ");
        System.out.println("============================");

        // Solicita o CPF do gerente a ser alterado
        System.out.println("Digite o cpf do gerente que deseja fazer alterações.");
        String cpfProcura = input.next();

        // Procura o gerente pelo CPF
        for (Gerente gerente : gerenteDB.getGerentes()){

            if (gerente.getCPF().equals(cpfProcura)){
                System.out.println("GERENTE ENCONTRADO!");
                input.nextLine(); // Adicionado para consumir o delimitador(Estava pulando o primeiro input do
                // nome)

                // Solicita e atualiza os dados do gerente
                System.out.printf("\nDigite o nome caso queira alterar (atual: %s) ", gerente.getNome());
                String nome = input.nextLine();
                if (!nome.isEmpty())
                    gerente.setNome(nome);

                System.out.printf("\nDigite o email caso queira alterar (atual: %s) ", gerente.getEmail());
                String email = input.nextLine();
                if (!email.isEmpty())
                    gerente.setEmail(email);

                System.out.printf("\nDigite o salario caso queira alterar (atual: %.2f) ", gerente.getSalario());
                String entrada = input.nextLine();
                if (!entrada.isEmpty()) {
                    double salario = Double.parseDouble(entrada);
                    if (salario != 0.0 && salario > 0)
                        gerente.setSalario(salario);
                }

                System.out.printf("\nDigite o cpf caso queira alterar (atual: %s) ", gerente.getCPF());
                String cpf = input.nextLine();
                if (!cpf.isEmpty())
                    gerente.setCPF(cpf);

                System.out.printf("\nDigite o tempo de trabalho caso queira alterar (atual: %d) ", gerente.getMesesTrabalho());
                String line = input.nextLine();
                if (!line.isEmpty()) {
                    int mesesTrabalho = Integer.parseInt(line);
                    if (mesesTrabalho > 0)
                        gerente.setDataContratado(mesesTrabalho);
                }

                System.out.printf("\nDigite os meses de experiência gerencial caso queira alterar (atual: %d) ", gerente.getMesesExperienciaGerencial());
                String meses = input.nextLine();
                if (!meses.isEmpty()) {
                    int mesesExperienciaGerencial = Integer.parseInt(meses);
                    if (mesesExperienciaGerencial > 0)
                        gerente.setMesesExperienciaGerencial(mesesExperienciaGerencial);

                }
            }
        }
    }

    // Método para remover um gerente
    public static void removerGerente(){
        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes
        Gerente gerenteRemover = null; // Inicializa a variável do gerente a ser removido

        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Exibe o cabeçalho da remoção de gerente
        System.out.println("============================");
        System.out.println("     REMOVER GERENTE     ");
        System.out.println("============================");

        // Solicita o CPF do gerente a ser removido
        System.out.println("Digite o CPF do gerente que deseja remover.");
        String cpfProcura = input.next();

        // Procura o gerente pelo CPF
        for (Gerente gerente : gerenteDB.getGerentes()){
            if (gerente.getCPF().equals(cpfProcura)){
                gerenteRemover = gerente; // Define o gerente a ser removido
                break;
            }
        }

        if (gerenteRemover != null) { // Verifica se o gerente foi encontrado

            System.out.println("Gerente encontrado! Deseja realmente remover? (s/n)");
            String confirmacao = input.next();

            if (confirmacao.equalsIgnoreCase("s")) {
                GerenteDB.remove(gerenteRemover); // Remove o gerente do banco de dados
                System.out.println("Gerente removido com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }

        }
    }

    // Método para buscar um gerente pelo CPF
    public static void buscarGerente(){
        GerenteDB gerenteDB = GerenteDB.getInstance(); // Obtém a instância do banco de dados de gerentes

        Scanner input = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário

        // Solicita o CPF do gerente a ser buscado
        System.out.println("Digite o CPF do gerente que deseja buscar.");
        String cpfProcura = input.next();

        // Procura o gerente pelo CPF
        for (Gerente gerente : gerenteDB.getGerentes()){
            if (gerente.getCPF().equals(cpfProcura)){
                System.out.println("============================");
                System.out.println(gerente.toString()); // Exibe os detalhes do gerente
                System.out.println("============================");
            }
        }

    }
}
