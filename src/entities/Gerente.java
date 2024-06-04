package entities;

public class Gerente extends Funcionario {

    private double bonus;
    private String departamento;

    Gerente(String nome, String email, double salario, String cpf, double bonus, String departamento) {
        super(nome, email, salario, cpf);
        this.bonus = bonus;
        this.departamento = departamento;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalarioComBonus() {
        return this.salario += (this.salario/100)* this.bonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nBonus: %.2f"
                + "\nDepartamento: %s"
                + "\nSalario total: %.2f", this.bonus, this.departamento, getSalarioComBonus());
    }
}
