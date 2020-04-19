/*
 * Titel: Programmieren 3, AB03
 * Autor: Giuseppe Buccellato
 * Semester: SoSe2020
 */

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ringpuffer Test... Enter max capacity: ");
        int capIn = scanner.nextInt();
        Ringpuffer ringpuffer = new Ringpuffer(0,0,0, capIn);


    }
}
