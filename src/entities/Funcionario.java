package entities;

public class Funcionario {

    private int id = 0;
    protected String nome;
    protected String email;
    protected double salario;
    protected String cpf;

    static int proximoId;

    Funcionario(String nome, String email, double salario, String cpf) {
        this.id = proximoId;
        proximoId++;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;

    }


    public String getCPF() {
        return this.cpf;
    }


    public String toString(int numero) {
        return String.format("\nNome: %s"
                + "\nemail: %s"
                + "\nCPF: %s", this.nome, this.email, this.cpf);
    }

    public String toString() {
        return String.format("\nID: %d"
                + "\nNome: %s"
                + "\nemail: %s"
                + "\nsalario: %.2f"
                + "\nCPF: %s", this.id, this.nome, this.email, this.salario, this.cpf);
    }

}
