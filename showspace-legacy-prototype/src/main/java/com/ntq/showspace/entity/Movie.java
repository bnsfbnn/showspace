package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.StatusMovie;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_movie")
    @SequenceGenerator(name = "sequence_movie")
    private Long id;

    private String name;

    private String summary;

    @Column(name = "description_long")
    private String descriptionLong;

    private String director;

    @Column(name = "age_limit")
    private Integer ageLimit;


    private Integer duration;

    @Column(name = "release_date")
    private LocalDate releasedDate;

    private String language;

    @Column(name = "trailer_url")
    private String trailerUrl;

    @Column(name = "movie_status")
    @Enumerated(EnumType.STRING)
    private StatusMovie status;

    @Column(name = "image_small")
    private String imageSmallUrl;

    @Column(name = "image_large")
    private String imageLargeUrl;

    @OneToMany(mappedBy = "movie")
    private Set<Schedule> schedules;

    @ManyToMany()
    @JoinTable(
            name = "category_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new HashSet<>();
}
