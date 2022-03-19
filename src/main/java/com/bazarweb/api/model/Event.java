package com.bazarweb.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Event {

    private static final long serialVersionUID = 1L;
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_generator")
    @SequenceGenerator(name = "event_id_generator", sequenceName = "event_id_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private List<Sale> sales;

}
