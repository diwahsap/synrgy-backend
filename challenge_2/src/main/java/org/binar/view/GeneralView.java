package org.binar.view;

import org.binar.utils.Constant;

public class GeneralView {
    public void showWelcomeMessage(){
        System.out.println(Constant.LINE_30C);
        System.out.println("Selamat datang di Binarfud");
        System.out.println(Constant.LINE_30C);
    }

    public void showOrderMenu(){
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke Menu Utama");
        System.out.println("O. Keluar Aplikasi");
    }

    public void showExitMessage() {
        System.out.println("Terima kasih! Selamat tinggal.");
    }

}