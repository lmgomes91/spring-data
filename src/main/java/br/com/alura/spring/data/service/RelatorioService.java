package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private Boolean system = true;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Escolha a opção: ");
            System.out.println("0 - Sair ");
            System.out.println("1 - Buscar funcionario por nome: ");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscarFuncionarioNome(scanner);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void buscarFuncionarioNome(Scanner scanner){
        System.out.println("Nome do funcionario: ");
        String nome = scanner.next();

        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);

        System.out.println(funcionarios.toArray());

    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner){
        System.out.println("Nome do funcionario: ");
        String nome = scanner.next();

        System.out.println("Data contratacao do funcionario: ");
        String data = scanner.next();
        LocalDate dataFormatada = LocalDate.parse(data, formatter);

        System.out.println("Salario do funcionario: ");
        float salario = scanner.nextFloat();

        List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, dataFormatada);
    }

    private void pesquisaFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
        System.out.println(list.toString());
    }
}
