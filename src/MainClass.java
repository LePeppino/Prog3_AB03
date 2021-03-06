/*
 * Titel: Programmieren 3, AB03
 * Autor: Giuseppe Buccellato
 * Semester: SoSe2020
 */


import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ringbuffer... Enter max capacity: ");
        int capIn = scanner.nextInt();
        Ringpuffer<String> ringpuffer = new Ringpuffer<>(0,0,0, capIn);
        System.out.println("Ringbuffer capacity is now " + ringpuffer.getCapacity());

        int choice = 0;
        while(choice != 9) {
            System.out.println("\nChoose what happens if ringbuffer capacity is reached:" +
                    "\n(1) overwrite existing elements" +
                    "\n(2) take no new element" +
                    "\n(3) automatically increase capacity by defined amount" +
                    "\n(4) set new capacity of ringbuffer" +
                    "\n(9) exit menu...");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    ringpuffer.enableOverwrite();
                    System.out.println("Enabled overwriting elements at max capacity.");
                    break;
                case 2:
                    ringpuffer.disableNewElements();
                    System.out.println("Not taking new elements at max capacity.");
                    break;
                case 3:
                    ringpuffer.autoIncreaseCap();
                    System.out.println("Enabled increasing max capacity.");
                    break;
                case 4:
                    System.out.print("Set new capacity... Enter new max capacity: ");
                    capIn = scanner.nextInt();
                    ringpuffer.changeCapacity(capIn);
                    break;
                case 9:
                    System.out.println("Exiting...\n");
                    break;
                default:
                    System.out.println("Please select an option from above!");
            }
        }

        ringpuffer.addToRing("ok");
        ringpuffer.addToRing("hallo");
        ringpuffer.addToRing("what");
        ringpuffer.addToRing("Welt");
        ringpuffer.addToRing("oh");
        ringpuffer.addToRing("damn");
        ringpuffer.addToRing("klo");
        ringpuffer.addToRing("pop");

        ringpuffer.getPosition();
        ringpuffer.getNoOfElements();

        ringpuffer.readLikeFIFO();
        ringpuffer.readLikeLIFO();
    }
}
