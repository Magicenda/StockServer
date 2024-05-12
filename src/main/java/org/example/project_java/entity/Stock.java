package org.example.project_java.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "stock")
    @JsonIgnore
    private List<Accounting> accountings;
}
