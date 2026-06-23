package uhu;

public class Funcionario {
	
	private String nome;
	private String cargo;
	private double salario;
	private int horasTrabalhadas;

	public String getNome() {
		return nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public double getSalario() {
		return salario;
	}
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public double mostrarSalario() {
	return salario;
	}
}
