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
        return items.stream()
                    .filter(item -> item.getQuantity() > 0)
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
    }

    public int calculateQty() {
        return items.stream()
                    .filter(item -> item.getQuantity() > 0)
                    .mapToInt(Item::getQuantity)
                    .sum();
    }
}
