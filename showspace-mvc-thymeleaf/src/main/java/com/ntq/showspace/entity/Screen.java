package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.RoomStatus;
import com.ntq.showspace.entity.enums.RoomType;
import com.ntq.showspace.entity.enums.ScreenSize;
import jakarta.persistence.*;

@Entity
@Table(name = "screen")
public class Screen extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_screen")
    @SequenceGenerator(name = "sequence_screen")
    private Long id;

    private String name;

    @Column(name = "seat_numbers")
    private Integer seatNumbers;

    @Enumerated(EnumType.STRING)
    @Column(name = "screen_size")
    private ScreenSize screenSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status")
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    private CinemaLocation cinemaLocation;

//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
//    private Set<Seat> seats = new HashSet<>();
//
//    @OneToMany(mappedBy = "room")
//    private Set<Showtime> showtimes = new HashSet<>();

}
