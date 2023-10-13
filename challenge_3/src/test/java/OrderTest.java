import org.binar.model.Order;
import org.binar.model.Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Pizza", 10.0, 2);
        order.addItem(item);
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void testCalculateTotal() {
        Item item1 = new Item("Pizza", 10.0, 2);
        Item item2 = new Item("Burger", 5.0, 3);
        order.addItem(item1);
        order.addItem(item2);
        assertEquals(35.0, order.calculateTotal());
    }

    @Test
    public void testCalculateQty() {
        Item item1 = new Item("Pizza", 10.0, 2);
        Item item2 = new Item("Burger", 5.0, 3);
        order.addItem(item1);
        order.addItem(item2);
        assertEquals(5, order.calculateQty());
    }
}