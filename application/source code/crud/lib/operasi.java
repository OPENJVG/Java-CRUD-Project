package crud.lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class operasi {
    public static void bersihkanLayar() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        }
        catch (Exception e) {
            System.err.println("Tidak bisa bersihkan layar");
        }
    }
    public static boolean cekDatabase() {
        try {
            FileReader fileReader = new FileReader("database.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if ((bufferedReader.readLine()) == null) {
                return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public static boolean lanjutkan(Scanner input) {
        boolean isLanjut;
        char yesOrNo;
        while (true) {
            System.out.print("Lanjut?(y/t): ");
            yesOrNo = input.next().charAt(0);
            if (yesOrNo == 'y' || yesOrNo == 'Y') {
                isLanjut = true;
                break;
            }
            else if (yesOrNo == 't' || yesOrNo == 'T') {
                isLanjut = false;
                break;
            }
        }
        return isLanjut;
    }
}