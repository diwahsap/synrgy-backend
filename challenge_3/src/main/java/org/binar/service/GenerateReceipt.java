package org.binar.service;

import org.binar.model.Item;
import org.binar.model.Order;
import org.binar.utils.Constant;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateReceipt {
    private GenerateReceipt(){}

    public static void generateReceipt(Order order){
        try (FileWriter writer = new FileWriter("payment_receipt.txt")){
            writer.write(Constant.LINE_30C + Constant.NEW_LINE);
            writer.write("BinarFud" + Constant.NEW_LINE);
            writer.write(Constant.LINE_30C + Constant.NEW_LINE);
            writer.write("Terima kasih sudah memesan di BinarFud" + Constant.NEW_LINE);
            writer.write("Di bawah ini adalah pesanan anda" + Constant.NEW_LINE);

            List<Item> items = order.getItems();

            for (Item item : items) {
                writer.write(item.getName() + " - " +
                        item.getQuantity() + " - " +
                        item.calculateSubtotal() +
                        Constant.NEW_LINE);
            }

            writer.write(Constant.LINE_30C + Constant.NEW_LINE);
            writer.write(Constant.STRIP_30C + "+" + Constant.NEW_LINE);
            writer.write("Total" + " - " +
                    order.calculateQty() + " - " +
                    order.calculateTotal() +
                    Constant.NEW_LINE);

            writer.write("Pembayaran : BinarCash" + Constant.NEW_LINE + Constant.NEW_LINE);
            writer.write(Constant.LINE_30C + Constant.NEW_LINE);
            writer.write("Simpan struk ini sebagai bukti pembayaran" + Constant.NEW_LINE);
            writer.write(Constant.LINE_30C);

        } catch (IOException e) {
            System.out.println("Error writing payment receipt to file.");
        }
    }
}
