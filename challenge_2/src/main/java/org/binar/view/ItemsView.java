package org.binar.view;

import org.binar.model.Item;
import org.binar.utils.Constant;

import java.util.List;
import java.util.Scanner;

public class ItemsView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputUser() {
        System.out.print("=> ");
        return scanner.nextInt();
    }

    public static int showItems(List<Item> items) {
        System.out.println("Daftar Menu:");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rp " + item.getPrice());
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        return inputUser();
    }

    public static void showItemDetails(Item item) {
        System.out.println(item.getName() + " | Rp " + item.getPrice());
    }

    public static void showQuantityMsg(){
        System.out.println(Constant.LINE_30C);
        System.out.println("Berapa pesanan anda?");
        System.out.println(Constant.LINE_30C);
    }

    public static int inputQty() {
        System.out.print("qty => ");
        return scanner.nextInt();
    }
}
