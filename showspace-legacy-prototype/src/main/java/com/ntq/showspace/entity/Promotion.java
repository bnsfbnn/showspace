package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.StatusPromotion;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotion")
public class Promotion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_promotion")
    @SequenceGenerator(name = "sequence_promotion")
    private Long id;

    private String info;

    @Column(name = "image_prom")
    private String imageUrl;

    private Double discount;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @Column(name = "end_datetime")
    private LocalDateTime endDateTime;

    @Column(name = "promotion_status")
    @Enumerated(EnumType.STRING)
    private StatusPromotion statusPromotion;

    @OneToMany(mappedBy = "promotion")
    private Set<Bill> bills = new HashSet<>();

}
