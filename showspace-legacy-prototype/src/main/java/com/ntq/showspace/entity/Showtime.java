package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.compositekey.ShowtimeId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "showtime")
public class Showtime extends BaseEntity {

    @EmbeddedId
    private ShowtimeId id;

    @MapsId("scheduleId")
    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    @JsonIgnore
    private Schedule schedule;

    @MapsId("screenId")
    @ManyToOne
    @JoinColumn(name = "screen_id", insertable = false, updatable = false)
    @JsonIgnore
    private Screen screen;

    @Column
    private String format;

    @OneToMany(mappedBy = "showtime")
    private Set<ShowtimeSeat> showtimeSeats = new HashSet<>();
}
