package uhu;

public class FuncionarioHorista extends Funcionario {
	@Override
	public double mostrarSalario() {
		return (getSalario()) * (getHorasTrabalhadas());
	}
}
