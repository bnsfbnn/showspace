package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinema_location")
public class CinemaLocation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cinema_location")
    @SequenceGenerator(name = "sequence_cinema_location")
    private Long id;

    private String name;

    @Column(name = "room_image")
    private String imageUrl;

    private String address;

    private String hotline;

    private String description;

    private Integer rating;

    @OneToMany(mappedBy = "branch")
    private Set<Screen> screens = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    private CinemaBrand cinemaBrand;

}
