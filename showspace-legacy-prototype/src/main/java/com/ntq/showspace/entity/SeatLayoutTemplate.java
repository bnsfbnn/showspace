package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "screen_layout_template")
public class SeatLayoutTemplate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_screen_layout_template")
    @SequenceGenerator(name = "sequence_screen_layout_template")
    private Long id;

    @Column(name = "number_seat_rows")
    private Integer seatRowNumbers;

    @Column(name = "number_seat_columns")
    private Integer seatColumnNumbers;

    @Column(name = "aisle_position")
    private Integer aislePosition;

    @Column(name = "aisle_width")
    private Integer aisleWidth;

    @Column(name = "aisle_height")
    private Integer aisleHeight;
}
