package com.bazarweb.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Profile {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_id_generator")
    @SequenceGenerator(name = "profile_id_generator", sequenceName = "profile_id_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileId")
    private List<Employee> employees;
}
