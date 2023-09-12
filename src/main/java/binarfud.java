// import library
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class binarfud {
    public static void main(String[] args) {
        // define variable
        int num;
        int case1Quantity = 0;
        int case2Quantity = 0;
        int case3Quantity = 0;
        int case4Quantity = 0;
        int case5Quantity = 0;

        // Create Scanner object for input user
        Scanner s = new Scanner(System.in);

        // do looping with do-while
        do {
            // call displayMainMenu
            displayMainMenu();
            System.out.print("=> ");
            // Read the next integer from the screen
            num = s.nextInt();

            switch (num) {
                case 1 -> {
                    System.out.println("""
                            ====================
                            Berapa Pesanan Anda
                            ====================
                            """
                    );
                    System.out.println("Nasi Goreng\t|\t15.000");
                    System.out.println("input 0 untuk kembali");
                    System.out.print("qty => ");
                    int qty = s.nextInt();
                    if (qty != 0) { // if equal to zero, program will go to mainmenu
                        case1Quantity += qty; // Accumulate the quantity for Nasi Goreng
                    }
                }
                case 2 -> {
                    System.out.println("""
                            ====================
                            Berapa Pesanan Anda
                            ===================="""
                    );
                    System.out.println("Mie Goreng\t|\t13.000");
                    System.out.println("input 0 untuk kembali");
                    System.out.print("qty => ");
                    int qty = s.nextInt();
                    if (qty != 0) {
                        case2Quantity += qty;
                    }
                }
                case 3 -> {
                    System.out.println("""
                            ====================
                            Berapa Pesanan Anda
                            ===================="""
                    );
                    System.out.println("Nasi + Ayam\t|\t18.000");
                    System.out.println("input 0 untuk kembali");
                    System.out.print("qty => ");
                    int qty = s.nextInt();
                    if (qty != 0) {
                        case3Quantity += qty;
                    }
                }
                case 4 -> {
                    System.out.println("""
                            ====================
                            Berapa Pesanan Anda
                            ===================="""
                    );
                    System.out.println("Es Teh Manis\t|\t3.000");
                    System.out.println("input 0 untuk kembali");
                    System.out.print("qty => ");
                    int qty = s.nextInt();
                    if (qty != 0) {
                        case4Quantity += qty;
                    }
                }
                case 5 -> {
                    System.out.println("""
                            ====================
                            Berapa Pesanan Anda
                            ===================="""
                    );
                    System.out.println("Es Jeruk\t|\t5.000");
                    System.out.println("input 0 untuk kembali");
                    System.out.print("qty => ");
                    int qty = s.nextInt();
                    if (qty != 0) {
                        case5Quantity += qty;
                    }
                }
                case 99 -> processPayment(case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity, s);
                default -> System.out.println("Tidak ada yang cocok!\n");
            }
        } while (num != 0);
    }

    public static void displayMainMenu(){
        System.out.println("=====================================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("=====================================");
        System.out.println("Silahkan pilih makanan:");

        final String[] menuItems = {
                "Nasi Goreng\t|\t15.000",
                "Mie Goreng\t|\t13.000",
                "Nasi + Ayam\t|\t18.000",
                "Es Teh Manis\t|\t3.000",
                "Es Jeruk\t\t|\t5.000"
        };

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }

        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
    }


    public static int calculateTotalQty(int case1Quantity, int case2Quantity, int case3Quantity, int case4Quantity, int case5Quantity) {
        int totalQty;
        totalQty = case1Quantity + case2Quantity + case3Quantity + case4Quantity + case5Quantity;
        return totalQty;
    }

    public static int calculateTotalBill(int case1Quantity, int case2Quantity, int case3Quantity, int case4Quantity, int case5Quantity) {
        int total = 0;

        // Calculate the total bill based on item quantities and prices
        total += (15000 * case1Quantity);
        total += (13000 * case2Quantity);
        total += (18000 * case3Quantity);
        total += (3000 * case4Quantity);
        total += (5000 * case5Quantity);
        return total;
    }

    public static void processPayment(int case1Quantity, int case2Quantity, int case3Quantity, int case4Quantity, int case5Quantity, Scanner s) {
        System.out.println("""
                ==============================
                Konfirmasi Pembayaran
                ==============================
                """
        );

        // Display the ordered items and quantities
        // there are checking conditional with "if"
        // if zero, don't show anythings
        if (case1Quantity > 0) {
            System.out.println("Nasi Goreng\t\t\t" + case1Quantity + "\t\t" + (15000 * case1Quantity));
        }
        if (case2Quantity > 0) {
            System.out.println("Mie Goreng\t\t\t" + case2Quantity + "\t\t" + (13000 * case2Quantity));
        }
        if (case3Quantity > 0) {
            System.out.println("Nasi + Ayam\t\t\t" + case3Quantity + "\t\t" + (18000 * case3Quantity));
        }
        if (case4Quantity > 0) {
            System.out.println("Es Teh Manis\t\t" + case4Quantity + "\t\t" + (3000 * case4Quantity));
        }
        if (case5Quantity > 0) {
            System.out.println("Es Jeruk\t\t\t" + case5Quantity + "\t\t" + (5000 * case5Quantity));
        }

        // calculate totalQty and totalBill, call the method
        int totalQty = calculateTotalQty(
                case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity);
        int totalBill = calculateTotalBill(
                case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity);
        if (totalBill > 0) {
            System.out.println("------------------------------+");
            System.out.println("Total\t\t\t\t" + totalQty + "\t\t" + totalBill + "\n");
        }

        System.out.println("1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi\n");
        System.out.print("=> ");
        int case99 = s.nextInt();
        if (case99 == 1) {
            System.out.println("Total Pembayaran: " + totalBill);
            // Generate payment receipt as a .txt file
            generateReceipt(case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity);
            // Reset quantities after payment
            // resetQuantities(new int[]{case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity});
            System.exit(0);
        } else if (case99 == 2) {
            // if user choose 2
        } else if (case99 == 0) {
            System.exit(0);
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public static void generateReceipt(int case1Quantity, int case2Quantity, int case3Quantity, int case4Quantity, int case5Quantity) {
        try {
            FileWriter writer = new FileWriter("payment_receipt.txt");

            writer.write("====================\n");
            writer.write("BinarFud\n");
            writer.write("====================\n\n");
            writer.write("Terima kasih sudah memesan di BinarFud\n\n");
            writer.write("Di bawah ini adalah pesanan anda\n\n");

            if (case1Quantity > 0) {
                writer.write("Nasi Goreng\t\t\t" + case1Quantity + "\t\t" + (15000 * case1Quantity) + "\n");
            }
            if (case2Quantity > 0) {
                writer.write("Mie Goreng\t\t\t" + case2Quantity + "\t\t" + (13000 * case2Quantity) + "\n");
            }
            if (case3Quantity > 0) {
                writer.write("Nasi + Ayam\t\t\t" + case3Quantity + "\t\t" + (18000 * case3Quantity) + "\n");
            }
            if (case4Quantity > 0) {
                writer.write("Es Teh Manis\t\t" + case4Quantity + "\t\t" + (3000 * case4Quantity) + "\n");
            }
            if (case5Quantity > 0) {
                writer.write("Es Jeruk\t\t\t" + case5Quantity + "\t\t" + (5000 * case5Quantity) + "\n");
            }

            int totalQty = calculateTotalQty(case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity);
            double totalBill = calculateTotalBill(case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity);
            if (totalBill > 0) {
                writer.write("------------------------------+\n");
                writer.write("Total\t\t\t\t" + totalQty + "\t\t" + totalBill + "\n\n");
            }

            writer.write("Pembayaran : BinarCash\n\n");
            writer.write("====================\n");
            writer.write("Simpan struk ini sebagai bukti pembayaran\n");
            writer.write("====================");
            writer.close();

            System.out.println("Payment receipt saved as payment_receipt.txt\n\n");
        } catch (IOException e) {
            System.err.println("Error writing payment receipt to file.");
        }
    }
}
