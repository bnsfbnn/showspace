package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.StatusSeat;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "showtime_seat",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"seat_id", "schedule_id", "room_id"})
        }
)
public class ShowtimeSeat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_showtime_seat")
    @SequenceGenerator(name = "sequence_showtime_seat")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id"),
            @JoinColumn(name = "room_id", referencedColumnName = "room_id")})
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    @Enumerated(EnumType.STRING)
    private StatusSeat status;

    private Double price;

    @OneToMany(mappedBy = "showtimeSeat", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetails = new HashSet<>();
}