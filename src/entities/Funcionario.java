package entities;

public class Funcionario {

    private int id = 0;
    protected String nome;
    protected String email;
    protected double salario;
    protected String cpf;
    protected int mesesTrabalho;

    static int proximoId;

    public Funcionario(String nome, String email, double salario, String cpf) {
        this.id = proximoId;
        proximoId++;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;

    }

    public Funcionario(String nome, String email, double salario, String cpf, int mesesTrabalho) {
        this.id = proximoId;
        proximoId++;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;
        this.mesesTrabalho = mesesTrabalho;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email = email;}

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) { this.cpf = cpf; }

    public double getSalario() {return this.salario;}

    public void setSalario(double salario) {this.salario = salario;}

    public int getMesesTrabalho() {return this.mesesTrabalho;}

    public void setMesesTrabalho(int mesesTrabalho) {this.mesesTrabalho = mesesTrabalho;}

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
                + "\nCPF: %s"
                + "\nMeses Trabalhado: %d", this.id, this.nome, this.email, this.salario, this.cpf, this.mesesTrabalho);
    }

}
