package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {

    // Atributos privados e protegidos da classe Funcionario
    private int id = 0;
    protected String nome;
    protected String email;
    protected double salario;
    protected String cpf;
    protected LocalDate dataContratado;

    static int proximoId; // Contador estático para gerar IDs únicos para os funcionários

    // Construtor que inicializa um Funcionario com nome, email, salário e CPF
    public Funcionario(String nome, String email, double salario, String cpf) {
        this.id = proximoId; // Atribui o valor de proximoId ao id do funcionário
        proximoId++; // Incrementa proximoId para o próximo funcionário
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;
        this.dataContratado = LocalDate.now();
    }


    // Métodos getter e setter para acessar e modificar os atributos do funcionário


    public Funcionario(String nome, String email, double salario, String cpf, LocalDate dataContratado) {
        this.id = proximoId;
        proximoId++;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cpf = cpf;
        this.dataContratado = dataContratado;
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

    public int getMesesTrabalho() {
        return (int) ChronoUnit.MONTHS.between(this.dataContratado, LocalDate.now());
    }

    public void setDataContratado(String dataContratado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        this.dataContratado = LocalDate.parse(dataContratado, formatter);
    }

    public void setDataContratado(int mesesTrabalho) {
        this.dataContratado = LocalDate.now().minusMonths(mesesTrabalho);
    }


    public String getDataContratado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return this.dataContratado.format(formatter);
    }

    // Método toString que retorna uma string formatada com o nome, email e CPF do funcionário
    public String toString(int numero) {
        return String.format("\nNome: %s"
                + "\nemail: %s"
                + "\nCPF: %s", this.nome, this.email, this.cpf);
    }

    // Método toString que retorna uma string formatada com todos os atributos do funcionário
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return String.format("\nID: %d"
                + "\nNome: %s"
                + "\nemail: %s"
                + "\nsalario: %.2f"
                + "\nCPF: %s"
                + "\nMeses Trabalhado: %d"
                + "\nData contratado: %s", this.id, this.nome, this.email, this.salario, this.cpf, getMesesTrabalho(), this.dataContratado.format(formatter));
    }

}
