package entities;

public class Gerente extends Funcionario {

    private double bonus;
    private String departamento;
    private int mesesExperienciaGerencial;

    public Gerente(String nome, String email, double salario, String cpf, double bonus, String departamento, int mesesExperienciaGerencial) {
        super(nome, email, salario, cpf);
        this.bonus = bonus;
        this.departamento = departamento;
        this.mesesExperienciaGerencial = mesesExperienciaGerencial;
    }

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
