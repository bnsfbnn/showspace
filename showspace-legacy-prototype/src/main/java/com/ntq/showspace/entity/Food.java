package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_food")
    @SequenceGenerator(name = "sequence_food")
    private Long id;

    private String name;

    private double price;

    private int stock;

    @Column(name = "image_food")
    private String imageUrl;

    private String description;

    @OneToMany(mappedBy = "food")
    private Set<BillFood> billFoods = new HashSet<>();
}
