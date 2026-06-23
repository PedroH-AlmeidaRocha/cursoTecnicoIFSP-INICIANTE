package uhu;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		FuncionarioHorista f2 = new FuncionarioHorista();
		Scanner in = new Scanner(System.in);
		int num;
		
		
		System.out.println(" digite 1 para mensalista e 2 para horista");
		num=in.nextInt();
		
		
		if (num==1){
			System.out.println("Digite seu salario");
			f.setSalario(in.nextInt());
			System.out.println(f.mostrarSalario());	
		}else if(num==2) {
			System.out.println("Digite seu salario");
			f2.setSalario(in.nextInt());
			
			System.out.println("Digite seu nome");
			f2.setNome(in.next());
		
			System.out.println("Digite seu cargo");
			f2.setCargo(in.next());
			
			System.out.println("Quantas horas trabalhadas?");
			f2.setHorasTrabalhadas(in.nextInt());
			
			System.out.println("Seu salário é de: "+ f2.mostrarSalario());
		
		}
	
	
		in.close();
	}
}
