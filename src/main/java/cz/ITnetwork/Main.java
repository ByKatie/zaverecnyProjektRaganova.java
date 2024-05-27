package cz.ITnetwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pojisteni pojisteniService = new Pojisteni();

        System.out.println("-------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("-------------------------");
        System.out.println("\n");

        boolean konec = false;
        while (!konec) {
            System.out.println("Zvolte si operaci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            int volbaOperace = Integer.parseInt(scanner.nextLine());
            switch (volbaOperace) {
                case 1:
                    pojisteniService.pridatPojisteneho(scanner);
                    break;
                case 2:
                    pojisteniService.vypsatVsechnyPojistene(scanner);
                    break;
                case 3:
                    pojisteniService.vyhledatPojisteneho(scanner);
                    break;
                case 4:
                    konec = true;
                    System.out.println("Děkuji za použití programu.");
                    break;
                default:
                    System.out.println("Neplatná volba, zvolte znovu.");
            }
        }
    }
}