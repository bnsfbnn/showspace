package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.TypeSeat;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seats")
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_seat")
    @SequenceGenerator(name = "sequence_seat")
    private Long id;

    @Column(name = "row_name")
    private String rowName;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "row_screen_label")
    private String rowScreenLabel;

    @Column(name = "column_screen_label")
    private String columnScreenLabel;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_seat")
    private TypeSeat typeSeat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Screen screen;

    @OneToMany(mappedBy = "seat")
    private Set<ShowtimeSeat> showtimeSeats = new HashSet<>();
}
