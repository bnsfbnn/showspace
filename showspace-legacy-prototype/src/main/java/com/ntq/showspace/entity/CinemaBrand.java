package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinema_brand")
public class CinemaBrand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cinema_brand")
    @SequenceGenerator(name = "sequence_cinema_brand")
    private Long id;

    private String name;

    private String hotline;

    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private Set<CinemaLocation> cinemaLocations = new HashSet<>();
}
