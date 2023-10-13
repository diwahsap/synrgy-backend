package org.binar.view;

import org.binar.model.Item;
import org.binar.model.Order;
import org.binar.utils.Constant;

import java.util.List;

public class OrderView {
    private OrderView(){}
    public static void showOrder(Order order) {
        System.out.println(Constant.LINE_30C);
        System.out.println("Konfirmasi dan Pembayaran");
        System.out.println(Constant.LINE_30C);
        List<Item> items = order.getItems();
        for (Item item : items) {
            System.out.println(item.getName() + " - " +
                    item.getQuantity() + " - " +
                    item.calculateSubtotal());
        }
        System.out.println(Constant.STRIP_30C  + "+");
        System.out.println("Total"+ " - " +
                order.calculateQty() + " - " +
                order.calculateTotal());
    }
}
