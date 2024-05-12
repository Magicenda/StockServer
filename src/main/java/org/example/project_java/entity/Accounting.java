package org.example.project_java.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accounting")
public class Accounting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberOfItemsSold")
    private Integer count;

    @Column(name = "defective")
    private Integer defective ;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    private Stock stock;
}
