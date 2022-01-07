package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner, int action){
        switch (action) {
            case 1 -> salvar(scanner);
            case 2 -> listar(scanner);
            case 3 -> atualizar(scanner);
            case 4 -> listarPorId(scanner);
            case 5 -> deletar(scanner);
            default -> System.out.println("Opção inválida");
        }
    }

    public void salvar(Scanner scanner){
        System.out.println("Nome do funcionario: ");
        String nome = scanner.next();

        System.out.println("CPF do funcionario: ");
        String cpf = scanner.next();

        System.out.println("Salario do funcionario: ");
        float salario = scanner.nextFloat();

        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        Optional<Cargo> cargo = cargoRepository.findById(id);

        if(cargo.isEmpty()){
            System.out.println("Cargo inváldo");
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setCargo(cargo.get());
        funcionario.setDataContratacao(new Date());

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");

    }

    public void listar(Scanner scanner){
        ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) funcionarioRepository.findAll();
        System.out.println(funcionarios.toString());
    }

    public void atualizar(Scanner scanner){
        System.out.println("Nome do funcionario: ");
        String nome = scanner.next();

        System.out.println("CPF do funcionario: ");
        String cpf = scanner.next();

        System.out.println("Salario do funcionario: ");
        float salario = scanner.nextFloat();

        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        Optional<Cargo> cargo = cargoRepository.findById(id);

        if(cargo.isEmpty()){
            System.out.println("Cargo inváldo");
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setCargo(cargo.get());
        funcionario.setDataContratacao(new Date());

        funcionarioRepository.save(funcionario);

        System.out.println("Atualizado");
    }

    public void listarPorId(Scanner scanner){
        System.out.println("Id do funcionario: ");
        int id = scanner.nextInt();

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        System.out.println(funcionario.toString());
    }

    public void deletar(Scanner scanner){
        System.out.println("Id do funcionario: ");
        int id = scanner.nextInt();

        funcionarioRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
