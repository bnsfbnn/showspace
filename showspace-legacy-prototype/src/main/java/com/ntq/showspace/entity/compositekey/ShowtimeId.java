package com.ntq.showspace.entity.compositekey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ShowtimeId implements Serializable {

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "screen_id")
    private Long screenId;
}
