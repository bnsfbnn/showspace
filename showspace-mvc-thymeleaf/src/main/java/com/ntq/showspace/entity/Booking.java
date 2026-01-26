package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_booking")
    @SequenceGenerator(name = "sequence_booking")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumns({
        @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id"),
        @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    })
    private Showtime showtime;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<ShowtimeSeat> showtimeSeats;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(name = "booking_code")
    private String bookingCode;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;
} 