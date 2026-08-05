package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.StatusBill;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_bill")
    @SequenceGenerator(name = "sequence_bill")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_bill")
    private StatusBill statusBill;

    @Column(name = "bill_code")
    private String billCode;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new HashSet<>();

    @OneToMany(mappedBy = "bill")
    private Set<BillFood> billFoods = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}