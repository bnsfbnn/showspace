package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_review")
    @SequenceGenerator(name = "sequence_review")
    private Long id;

    @Column(name = "number_star")
    private Integer numberStar;

    @Column(name = "number_like")
    private Integer numberLike;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
