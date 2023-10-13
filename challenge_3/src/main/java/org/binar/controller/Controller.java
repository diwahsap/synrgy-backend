package org.binar.controller;

import org.binar.model.Item;
import org.binar.model.Order;
import org.binar.service.GenerateReceipt;
import org.binar.view.ItemsView;
import org.binar.view.OrderView;
import org.binar.view.GeneralView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<Item> menu;
    private Order order;
    private GeneralView generalView;

    public Scanner sc = new Scanner(System.in);

    public Controller() {
        menu = new ArrayList<>();
        order = new Order();
        generalView = new GeneralView();

        initializeMenu();
    }

    private void initializeMenu() {
        // Initialize the menu items
        menu.add(new Item("Nasi Goreng", 15000, 0));
        menu.add(new Item("Mie Goreng", 13000, 0));
        menu.add(new Item("Nasi + Ayam", 18000, 0));
        menu.add(new Item("Es Teh Manis", 3000, 0));
        menu.add(new Item("Es Jeruk", 5000, 0));
    }

    public void start() {
        int choice;
        do {
            choice = home();
            try {
                switch (choice) {
                    case 1, 2, 3, 4, 5 -> processMenuItem(choice);
                    case 99 -> {
                        choice = checkout();
                        choice = checkoutMenu(choice);
                    }
                    case 0 -> generalView.showExitMessage();
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa bilangan bulat (integer).");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 0);
    }

    private int home() {
        generalView.showWelcomeMessage();
        return ItemsView.showItems(menu);
    }

    private void processMenuItem(int choice) {
        int quantity = inputQty(choice);
        checkQty(quantity);

        if (choice <= menu.size()) {
            Item selected = menu.get(choice - 1);
            checkOrderRepeat(selected, quantity);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private int inputQty(int choice) {
        ItemsView.showQuantityMsg();
        ItemsView.showItemDetails(menu.get(choice - 1));
        return ItemsView.inputQty();
    }

    private void checkQty(int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Minimal 1 jumlah pesanan!");
        }
    }

    private int checkout() {
        OrderView.showOrder(order);
        generalView.showOrderMenu();
        return ItemsView.inputUser();
    }

    private int checkoutMenu(int choice) {
        if (choice == 1) {
            GenerateReceipt.generateReceipt(order);
            System.out.println("Berhasil cetak struk!");
            choice = 0;
        } else if (choice == 2) {
            System.out.println("Kembali ke menu sebelumnya!");
        } else if (choice == 0) {
            choice = 0;
        }
        return choice;
    }

    private void checkOrderRepeat(Item selected, int quantity) {
        boolean itemInOrder = false;
        for (Item orderItem : order.getItems()) {
            if (orderItem.getName().equals(selected.getName())) {
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                itemInOrder = true;
                break;
            }
        }

        if (!itemInOrder) {
            selected.setQuantity(quantity);
            order.addItem(selected);
        }
    }
}
