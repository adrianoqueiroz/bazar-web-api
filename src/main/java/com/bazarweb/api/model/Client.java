package com.bazarweb.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Client {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_generator")
    @SequenceGenerator(name = "client_id_generator", sequenceName = "client_id_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String sexo;
    private String email;
    private Date dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Sale> sales;

}
