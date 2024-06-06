package entities;

public class Gerente extends Funcionario {

    // Atributos privados da classe Gerente
    private double bonus; // Bônus do gerente
    private String departamento; // Departamento do gerente
    private int mesesExperienciaGerencial; // Meses de experiência gerencial do gerente

    // Construtor que inicializa um Gerente com nome, email, salário, CPF, bônus, departamento e meses de experiência gerencial
    public Gerente(String nome, String email, double salario, String cpf, double bonus, String departamento, int mesesExperienciaGerencial) {
        super(nome, email, salario, cpf);
        this.bonus = bonus;
        this.departamento = departamento;
        this.mesesExperienciaGerencial = mesesExperienciaGerencial;
    }

    // Sobrescrita do método toString para incluir os atributos específicos de Gerente


    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getMesesExperienciaGerencial() { return this.mesesExperienciaGerencial;}

    public void setMesesExperienciaGerencial(int mesesExperienciaGerencial) { this.mesesExperienciaGerencial = mesesExperienciaGerencial;}

    // Método para calcular o salário total com bônus
    public double getSalarioComBonus() {
        return this.salario += (this.salario/100)* this.bonus;
    }

    // Sobrescrita do método toString para incluir os atributos específicos de Gerente
    @Override
    public String toString() {
        return super.toString() + String.format("\nBonus: %.2f"
                + "\nDepartamento: %s"
                + "\nSalario total: %.2f", this.bonus, this.departamento, getSalarioComBonus());
    }
}
