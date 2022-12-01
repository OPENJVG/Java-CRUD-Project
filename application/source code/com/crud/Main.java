/*
PROGRAM CRUD JAVA
OPEN SOURCE SOFTWARE
MADE WITH INTELLIJ IDEA
VERSION 1.0.0
*/

package com.crud;

import java.io.*;
import java.lang.String;
import java.util.Scanner;
import crud.lib.operasi;
import crud.lib.libcrud;

public class Main {
    public static void main(String[] args) throws IOException {
        char opsi;
        boolean lanjut = true;
        Scanner input = new Scanner(System.in);

        while (lanjut) {
            operasi.bersihkanLayar();
            System.out.println("=======================================================");
            System.out.println("          DATABASE PERPUSTAKAAN JAVA                   ");
            System.out.println("=======================================================");
            System.out.println("1. Tampilkan data");
            System.out.println("2. Cari data");
            System.out.println("3. Tambah data");
            System.out.println("4. Ubah data");
            System.out.println("5. Hapus data");
            System.out.println("6. Keluar");
            System.out.print("Opsi: ");
            opsi = input.next().charAt(0);

            if ((opsi == '1') || (opsi == 'a') || (opsi == 'A')) {
                libcrud.tampilkanData();
            } else if ((opsi == '2') || (opsi == 'b') || (opsi == 'B')) {
                libcrud.cariData(input);
            } else if ((opsi == '3') || (opsi == 'c') || (opsi == 'C')) {
                libcrud.tambahData();
            } else if ((opsi == '4') || (opsi == 'd') || (opsi == 'D')) {
                libcrud.ubahData();
            } else if ((opsi == '5') || (opsi == 'e') || (opsi == 'E')) {
                libcrud.hapusData(input);
            } else if ((opsi == '6') || (opsi == 'f') || (opsi == 'F')) {
                return;
            } else {
                System.out.println("Masukkan input yang ada!");
            }

            lanjut = operasi.lanjutkan(input);
        }
        input.close();
    }
}