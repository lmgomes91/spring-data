package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService CargoService;
	private final CrudFuncionarioService FuncionarioService;
	private final CrudUnidadeTrabalhoService CrudUnidadeTrabalhoService;
	private final RelatorioService RelatorioService;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService CargoService, CrudFuncionarioService FuncionarioService, CrudUnidadeTrabalhoService CrudUnidadeTrabalhoService, RelatorioService RelatorioService){
		this.CargoService = CargoService;
		this.FuncionarioService = FuncionarioService;
		this.CrudUnidadeTrabalhoService = CrudUnidadeTrabalhoService;
		this.RelatorioService = RelatorioService;
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
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatorios");

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

				CrudUnidadeTrabalhoService.inicial(scanner, action);
			} else if (action == 3) {
				System.out.println("1 - Salvar");
				System.out.println("2- Listar todos");
				System.out.println("3 - Atualizar um cargo");
				System.out.println("4 - Listar um por id cargo");
				System.out.println("5 - Excluir um por id cargo");

				action = scanner.nextInt();

				FuncionarioService.inicial(scanner, action);
			} else if (action == 4) {
//				System.out.println("1 - Salvar");
//				System.out.println("2- Listar todos");
//				System.out.println("3 - Atualizar um cargo");
//				System.out.println("4 - Listar um por id cargo");
//				System.out.println("5 - Excluir um por id cargo");

				action = scanner.nextInt();

				RelatorioService.inicial(scanner);
			} else {
				system = false;
			}

		}

	}
}
