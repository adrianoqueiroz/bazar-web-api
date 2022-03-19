package com.bazarweb.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Employee {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name = "employee_id_generator", sequenceName = "employee_id_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String sexo;
    private String email;
    private String usuario;
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private List<Sale> sales;
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profile profileId;

}
