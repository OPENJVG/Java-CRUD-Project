package crud.lib;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class libcrud {
    public static void tampilkanData() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean cekDatabase = operasi.cekDatabase();
        if (cekDatabase) {
            System.out.println("================== TAMPILKAN DATA ==================");
            fileReader = new FileReader("database.txt");
            bufferedReader = new BufferedReader(fileReader);
            String data = bufferedReader.readLine();
            int index = 1;

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| No | Tahun | Penulis                          | Penerbit           | Judul Buku                                              |");
            while (data != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
                System.out.printf("| %-2d | %-5s | %-32s | %-18s | %-56s|\n", index, stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
                data = bufferedReader.readLine();
                index++;
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            fileReader.close();
            bufferedReader.close();
        } else {
            System.err.println("Database tidak ada!");
        }
    }
    public static void cariData(Scanner input) throws IOException {
        boolean cekDatabase = operasi.cekDatabase();
        if (cekDatabase) {
            int bukuKeberapa;
            System.out.print("Buku ke berapa yang anda cari?: ");
            bukuKeberapa = input.nextInt();

            FileReader fileReader = new FileReader("database.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int jumlahDataBuku = 0;
            String data = bufferedReader.readLine();

            System.out.println("================== CARI DATA ==================");
            while (data != null) {
                StringTokenizer dataBuku = new StringTokenizer(data, ",");
                jumlahDataBuku++;
                if (jumlahDataBuku == bukuKeberapa) {
                    System.out.println("Tahun terbit : " + dataBuku.nextToken());
                    System.out.println("Penulis      : " + dataBuku.nextToken());
                    System.out.println("Penerbit     : " + dataBuku.nextToken());
                    System.out.println("Judul buku   : " + dataBuku.nextToken());
                    return;
                } else {
                    data = bufferedReader.readLine();
                }
            }

            System.out.println("Buku yang anda cari tidak ada");

            fileReader.close();
            bufferedReader.close();
        }
        else {
            System.err.println("Database tidak ada!");
        }
    }
    public static void tambahData() throws IOException {
        boolean cekDatabase = operasi.cekDatabase();
        if (cekDatabase) {
            Scanner input = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("database.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String judulBuku;
            String penulis;
            String penerbit;
            String tahunTerbit;
            String dataBuku;

            System.out.println("================== TAMBAH DATA ==================");
            System.out.print("Judul buku   : ");
            judulBuku = input.nextLine();
            System.out.print("Penulis      : ");
            penulis = input.nextLine();
            System.out.print("Penerbit     : ");
            penerbit = input.nextLine();
            System.out.print("Tahun terbit : ");
            tahunTerbit = input.nextLine();
            dataBuku = tahunTerbit + ',' + penulis + ',' + penerbit + ',' + judulBuku;

            bufferedWriter.newLine();
            bufferedWriter.write(dataBuku);
            bufferedWriter.flush();

            fileWriter.close();
            bufferedWriter.close();
        }
        else {
            Scanner input = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("database.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String judulBuku;
            String penulis;
            String penerbit;
            String tahunTerbit;
            String dataBuku;

            System.out.println("================== TAMBAH DATA ==================");
            System.out.print("Judul buku   : ");
            judulBuku = input.nextLine();
            System.out.print("Penulis      : ");
            penulis = input.nextLine();
            System.out.print("Penerbit     : ");
            penerbit = input.nextLine();
            System.out.print("Tahun terbit : ");
            tahunTerbit = input.nextLine();
            dataBuku = tahunTerbit + ',' + penulis + ',' + penerbit + ',' + judulBuku;

            bufferedWriter.write(dataBuku);
            bufferedWriter.flush();

            fileWriter.close();
            bufferedWriter.close();
        }
    }
    public static void ubahData() throws IOException {
        Scanner inputLokal = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        File database = new File("database.txt");
        FileReader fileReader = new FileReader(database);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        File temp = new File("temp.txt");
        FileWriter fileWriter = new FileWriter(temp);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        FileReader bacaJumlah = new FileReader(database);
        BufferedReader bacaJumlahBuffer = new BufferedReader(bacaJumlah);

        int jumlahData = 0;
        String dataJumlah = bacaJumlahBuffer.readLine();

        while (dataJumlah != null) {
            jumlahData++;
            dataJumlah = bacaJumlahBuffer.readLine();
        }

        bacaJumlah.close();
        bacaJumlahBuffer.close();

        System.out.println("================== UBAH DATA ==================\n");
        tampilkanData();
        System.out.print("Index buku yang akan diupdate: ");
        int indexUpdate = inputLokal.nextInt();

        String data = bufferedReader.readLine();
        int index = 0;

        while (data != null) {
            index++;

            if (index == indexUpdate) {
                StringTokenizer dataBuku = new StringTokenizer(data, ",");
                System.out.println("========== Data yang akan diubah ==========");
                System.out.println("Tahun terbit : " + dataBuku.nextToken());
                System.out.println("Penulis      : " + dataBuku.nextToken());
                System.out.println("Penerbit     : " + dataBuku.nextToken());
                System.out.println("Judul buku   : " + dataBuku.nextToken());
                dataBuku = new StringTokenizer(data, ",");
                String[] komponen = {"Tahun terbit", "Penulis", "Penerbit", "Judul buku"};
                String[] dataTemp = new String[4];
                for (int i = 0; i < komponen.length; i++) {
                    String original = dataBuku.nextToken();
                    System.out.printf("Apakah anda ingin merubah %-12s (true/false) : ", komponen[i]);
                    boolean opsiUbah = inputLokal.nextBoolean();
                    if (opsiUbah) {
                        System.out.printf("Masukkan %-12s : ", komponen[i]);
                        dataTemp[i] = inputString.nextLine();
                    } else {
                        dataTemp[i] = original;
                    }
                }
                bufferedWriter.write(dataTemp[0] + "," + dataTemp[1] + "," + dataTemp[2] + "," + dataTemp[3]);
            }
            else {
                bufferedWriter.write(data);
                if (!(index == jumlahData)) {
                    bufferedWriter.newLine();
                }
            }

            data = bufferedReader.readLine();
        }

        bufferedWriter.flush();

        System.gc();
        fileReader.close();
        bufferedReader.close();
        fileWriter.close();
        bufferedWriter.close();

        database.delete();
        temp.renameTo(database);
    }
    public static void hapusData(Scanner input) throws IOException {
        File database = new File("database.txt");
        FileReader fileDatabase = new FileReader(database);
        BufferedReader bufferedDatabase = new BufferedReader(fileDatabase);
        File fileTemp = new File("temp.txt");
        FileWriter fileBaru = new FileWriter(fileTemp);
        BufferedWriter bufferedTemp = new BufferedWriter(fileBaru);

        FileReader jumlahBaris = new FileReader(database);
        BufferedReader jumlah = new BufferedReader(jumlahBaris);
        String dataJumlah = jumlah.readLine();

        int jumlahData = 0;

        while (dataJumlah != null) {
            jumlahData++;
            dataJumlah = jumlah.readLine();
        }

        jumlahBaris.close();
        jumlah.close();

        String data = bufferedDatabase.readLine();
        StringTokenizer dataBuku;
        int indexHapus;
        int index = 1;

        System.out.println("================== HAPUS DATA ==================");
        System.out.print("Index yang akan dihapus: ");
        indexHapus = input.nextInt();
        while (data != null) {
            dataBuku = new StringTokenizer(data, ",");
            boolean isHapus = false;
            if (index == indexHapus) {
                System.out.println("Data yang akan dihapus: ");
                System.out.println("Tahun terbit : " + dataBuku.nextToken());
                System.out.println("Penulis      : " + dataBuku.nextToken());
                System.out.println("Penerbit     : " + dataBuku.nextToken());
                System.out.println("Judul buku   : " + dataBuku.nextToken());
                System.out.print("Apakah anda ingin menghapus data ini?(true/false): ");
                isHapus = input.nextBoolean();
            }
            if (isHapus) {
                System.out.println("Data berhasil dihapus");
            }
            else {
                bufferedTemp.write(data);
                if (!(index >= jumlahData)) {
                    bufferedTemp.newLine();
                }
            }
            data = bufferedDatabase.readLine();
            index++;
        }
        bufferedTemp.flush();
        System.gc();
        fileDatabase.close();
        bufferedDatabase.close();
        fileBaru.close();
        bufferedTemp.close();

        database.delete();
        fileTemp.renameTo(database);
    }
}