package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

    // As duas queries abaixo são equivalentes
    List<Funcionario> findByNameAndSalarioGreaterThanAndDataContratacao(String nome, Float Salario, Date DataContratacao);
    @Query("SELECT f FROM Funcionario f " +
            "WHERE f.nome = :nome " +
            "AND f.salario >= :salario" +
            "AND f.dataContratacao = :dataContratacao")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Float salario, LocalDate dataContratacao);

    @Query(value = "SELECT * FROM funcionaros f WHERE f.data_contratacao > = :data",
            nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

}
