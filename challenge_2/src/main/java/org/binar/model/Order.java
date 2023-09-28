package org.binar.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.calculateSubtotal();
        }
        return total;
    }

    public int calculateQty() {
        int qty = 0;
        for (Item item: items) {
            qty += item.getQuantity();
        }
        return qty;
    }
}
