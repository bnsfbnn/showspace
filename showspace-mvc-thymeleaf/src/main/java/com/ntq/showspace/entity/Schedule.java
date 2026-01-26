package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_schedule")
    @SequenceGenerator(name = "sequence_schedule")
    private Long id;

    private LocalDate date;

    @Column(name = "time_start")
    private LocalTime timeStart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private Set<Showtime> showtimes = new HashSet<>();
}
