package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_category")
    @SequenceGenerator(name = "sequence_category")
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies = new HashSet<>();
}
