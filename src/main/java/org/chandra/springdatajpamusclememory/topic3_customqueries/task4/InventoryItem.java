package org.chandra.springdatajpamusclememory.topic3_customqueries.task4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inventory_items")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String category;
    private int quantity;
    private double unitPrice;
    private String supplier;

    public InventoryItem(String itemName, String category, int quantity, double unitPrice, String supplier) {
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }
}
