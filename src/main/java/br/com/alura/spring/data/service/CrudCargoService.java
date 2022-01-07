package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCargoService {
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
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
        System.out.println("Descricao do cargo: ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Salvo");

    }

    public void listar(Scanner scanner){
        ArrayList<Cargo> cargos = (ArrayList<Cargo>) cargoRepository.findAll();
        System.out.println(cargos.toString());
    }

    public void atualizar(Scanner scanner){
        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        System.out.println("Descricao do cargo: ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);

        System.out.println("Atualizado");
    }

    public void listarPorId(Scanner scanner){
        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        Optional<Cargo> cargo = cargoRepository.findById(id);

        System.out.println(cargo.toString());
    }

    public void deletar(Scanner scanner){
        System.out.println("Id do cargo: ");
        int id = scanner.nextInt();

        cargoRepository.deleteById(id);
        System.out.println("Deletado");
    }
}
