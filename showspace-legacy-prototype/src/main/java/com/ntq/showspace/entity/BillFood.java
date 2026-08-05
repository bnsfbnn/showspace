package com.ntq.showspace.entity;

import com.ntq.showspace.entity.base.BaseEntity;
import com.ntq.showspace.entity.compositekey.BillFoodId;
import jakarta.persistence.*;

@Entity
@Table(name = "bill_food")
public class BillFood extends BaseEntity {

    @EmbeddedId
    private BillFoodId id;

    @MapsId("billId")
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @MapsId("foodId")
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private Integer quantity;
}
