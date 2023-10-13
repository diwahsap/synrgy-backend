import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.binar.model.Item;

public class ItemTest {
    @Test
    public void testGetName() {
        Item item = new Item("Test Item", 10.0, 1);
        assertEquals("Test Item", item.getName());
    }

    @Test
    public void testGetPrice() {
        Item item = new Item("Test Item", 10.0, 1);
        assertEquals(10.0, item.getPrice(), 0.0);
    }

    @Test
    public void testGetQuantity() {
        Item item = new Item("Test Item", 10.0, 1);
        assertEquals(1, item.getQuantity());
    }
}