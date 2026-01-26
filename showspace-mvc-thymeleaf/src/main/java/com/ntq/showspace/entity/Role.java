package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_role")
    @SequenceGenerator(name = "sequence_role")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
