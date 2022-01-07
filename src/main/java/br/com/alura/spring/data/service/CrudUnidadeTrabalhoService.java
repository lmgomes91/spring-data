package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository, FuncionarioRepository funcionarioRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner, int action){
        switch (action) {
            case 1 -> salvar(scanner);
            case 2 -> listar(scanner);
            case 3 -> atualizar(scanner);
            case 4 -> listarPorId(scanner);
            case 5 -> deletar(scanner);
            case 6 -> adicionaFuncionario(scanner);
            default -> System.out.println("Opção inválida");
        }
    }

    public void salvar(Scanner scanner){
        System.out.println("Descricao da unidade: ");
        String descricao = scanner.next();

        System.out.println("Descricao da unidade: ");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");

    }

    public void listar(Scanner scanner){
        ArrayList<UnidadeTrabalho> unidadeTrabalho = (ArrayList<UnidadeTrabalho>) unidadeTrabalhoRepository.findAll();
        System.out.println(unidadeTrabalho.toString());
    }

    public void atualizar(Scanner scanner){
        System.out.println("Descricao da unidade: ");
        String descricao = scanner.next();

        System.out.println("Descricao da unidade: ");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Atualizado");
    }

    public void listarPorId(Scanner scanner){
        System.out.println("Id da unidade: ");
        int id = scanner.nextInt();

        Optional<UnidadeTrabalho> unidadeTrabalho = unidadeTrabalhoRepository.findById(id);

        System.out.println(unidadeTrabalho.toString());
    }

    public void deletar(Scanner scanner){
        System.out.println("Id da unidade: ");
        int id = scanner.nextInt();

        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado");
    }

    public void adicionaFuncionario(Scanner scanner){
        System.out.println("Id da unidade: ");
        int idUnidade = scanner.nextInt();

        Optional<UnidadeTrabalho> unidadeTrabalho = unidadeTrabalhoRepository.findById(idUnidade);
        if(unidadeTrabalho.isEmpty()){
            System.out.println("Cargo inváldo");
            return;
        }

        System.out.println("Id do funcionario: ");
        int idFuncionario = scanner.nextInt();

        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        if(funcionario.isEmpty()){
            System.out.println("Cargo inváldo");
            return;
        }

        unidadeTrabalho.get().getFuncionarios().add(funcionario.get());
        unidadeTrabalhoRepository.save(unidadeTrabalho.get());

        funcionario.get().getUnidadesTrabalho().add(unidadeTrabalho.get());
        funcionarioRepository.save(funcionario.get());
    }
}
