# Challenge 1 - BinarFud
[![Screen-Shot-2023-09-13-at-01-17-29.png](https://i.postimg.cc/T3jvGzBf/Screen-Shot-2023-09-13-at-01-17-29.png)](https://postimg.cc/0zNB0B8B)
## Challenge Description
Ini merupakan tantangan pertama yang saya selesaikan di SYNRGY Academy. Saya membuat program BinarFud, aplikasi untuk pemesanan makanan. Challenge kali ini menitikberatkan pada pemahaman dasar mengenai Java, seperti Java Introduction, Data Types and Variables, Operator, Conditional & Looping, Programming Algorithm, dan Standard Class.
Berikut adalah beberapa poin yang ada dalam program ini,
```
1. Membuat program pemesanan makanan online
2. Fitur program berupa dapat menampilkan detail pesanan yang mencangkup harga, jumlah pesanan dan variasi pesanan
3. Output program dapat mengeluarkan file berekstensi text yang berisikan struk pembelian makanan
4. Push hasil program pada GitHub
```

## Program Structure
```
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── binarfud.java
    │   └── resources
    └── test
        └── java
```
Kode utama yang digunakan pada challenge kali ini terletak pada folder `src/main/binarfud.java`. Untuk menjalankan program, dapat dilakukan dengan command `java binarfud.java
`.

## Code Snippet - Main Method
```
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
                // body
            }
            case 3 -> {
                // body
            }
            case 4 -> {
                // body
            }
            case 5 -> {
                // body
            }
            case 99 -> processPayment(case1Quantity, case2Quantity, case3Quantity, case4Quantity, case5Quantity, s);
            default -> System.out.println("Tidak ada yang cocok!\n");
        }
    } while (num != 0);
}
```

## Future Improvements
Karena ini program pertama saya menggunakan Java, banyak hal yang masih bisa ditingkatkan. Berikut beberapa peningkatan yang bisa dilakukan,
1. Gunakan konsep Dry Code sebaik mungkin. Terdapat banyak redudansi pada kode di atas.
2. Pada pemilihan makanan, bisa menggunakan konsep OOP atau menggunakan ArrayList sehingga kode lebih rapi.
3. Ada `cheat` yang digunakan, yaitu pada method `processPayments`. Karena tidak bisa mengubah nilai variabel qty kembali ke nol, maka sementara program akan diberhentikan ketika user memilih `konfirmasi dan bayar`. (hehe, tapi tidak melanggar apapun)
4. Tambahkan error handling.



