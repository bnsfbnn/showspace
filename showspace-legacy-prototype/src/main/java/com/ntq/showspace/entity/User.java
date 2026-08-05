package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.enums.MembershipLevel;
import com.ntq.showspace.entity.enums.SignupType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user")
    @SequenceGenerator(name = "sequence_user")
    private Long id;

    @Column()
    private String username;

    @Column()
    private String email;

    @Column()
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column()
    private String phone;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "signup_type")
    @Enumerated(EnumType.STRING)
    private SignupType signupType;

    @Column(name = "member_ship_level")
    @Enumerated(EnumType.STRING)
    private MembershipLevel membershipLevel;

    private Boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Bill> bills = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();
}
