package com.esensesoftware.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DynamicUpdate
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;

    @Column(name = "ITEM_TYPE")
    private String itemType;

    @Column(name = "ITEM_PRICE")
    private Double itemPrice;

    @Column(name = "ITEM_QUANTITY")
    private Integer itemQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}//Item
