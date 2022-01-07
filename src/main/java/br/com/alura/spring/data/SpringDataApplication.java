package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService CargoService;
	private final CrudFuncionarioService FuncionarioService;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService CargoService, CrudFuncionarioService FuncionarioService){
		this.CargoService = CargoService;
		this.FuncionarioService = FuncionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		while (system){
			System.out.println("Qual acao voce quer tomar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");

			int action = scanner.nextInt();

			if(action == 1){
				System.out.println("1 - Salvar");
				System.out.println("2- Listar todos");
				System.out.println("3 - Atualizar um cargo");
				System.out.println("4 - Listar um por id cargo");
				System.out.println("5 - Excluir um por id cargo");

				action = scanner.nextInt();

				CargoService.inicial(scanner, action);
			} else if (action == 2) {
				System.out.println("1 - Salvar");
				System.out.println("2- Listar todos");
				System.out.println("3 - Atualizar um cargo");
				System.out.println("4 - Listar um por id cargo");
				System.out.println("5 - Excluir um por id cargo");

				action = scanner.nextInt();

				FuncionarioService.inicial(scanner, action);
			} else {
				system = false;
			}

		}

	}
}
