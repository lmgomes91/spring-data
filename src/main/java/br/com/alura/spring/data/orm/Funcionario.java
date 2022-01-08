package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Float salario;
    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;
    @ManyToOne
    @JoinColumn(name = "cargos_id")
    private Cargo cargo;
    @ManyToMany
//    @Column(name = "unidades_trabalho")
    @JoinTable(
            name = "unidades_funcionarios",
            joinColumns = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "unidade_trabalho_id"))
    private List<UnidadeTrabalho> unidadesTrabalho = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<UnidadeTrabalho> getUnidadesTrabalho() {
        return unidadesTrabalho;
    }

    public void setUnidadesTrabalho(List<UnidadeTrabalho> unidadesTrabalho) {
        this.unidadesTrabalho = unidadesTrabalho;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidadesTrabalho=" + unidadesTrabalho +
                '}';
    }
}
