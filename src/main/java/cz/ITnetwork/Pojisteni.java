package cz.ITnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pojisteni {
    private static final List<Pojistenci> pojistenci = new ArrayList<>();

    static {
        pojistenci.add(new Pojistenci("Jan", "Novák", 35, "+420123456789", "221187782142"));
        pojistenci.add(new Pojistenci("Marie", "Svobodová", 45, "+420987654321", "876456269915"));
        pojistenci.add(new Pojistenci("Petr", "Dvořák", 28, "+420111222333", "563186377267"));
        pojistenci.add(new Pojistenci("Eva", "Kovářová", 55, "+420555666777", "467487817494"));
        pojistenci.add(new Pojistenci("Lukáš", "Novotný", 40, "+420999888777", "648902536255"));
    }

    public void pridatPojisteneho(Scanner scanner) {
        String krestniJmeno;
        String prijmeni;

        do {
            System.out.println("Zadejte křestní jméno:");
            krestniJmeno = scanner.nextLine();
            if (krestniJmeno.trim().isEmpty()) {
                System.out.println("Křestní jméno nesmí být prázdné. Zkuste to prosím znovu.");
            }
        } while (krestniJmeno.trim().isEmpty());

        do {
            System.out.println("Zadejte příjmení:");
            prijmeni = scanner.nextLine();
            if (prijmeni.trim().isEmpty()) {
                System.out.println("Příjmení nesmí být prázdné. Zkuste to prosím znovu.");
            }
        } while (prijmeni.trim().isEmpty());

        System.out.println("Zadejte věk:");
        int vek = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadejte telefonní číslo:");
        String telCislo = scanner.nextLine();

        Random random = new Random();
        int randomNumber;
        StringBuilder cisloPojistence = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            randomNumber = random.nextInt(10);
            cisloPojistence.append(randomNumber);
        }
        System.out.println("Číslo pojištěnce: " + cisloPojistence);

        pojistenci.add(new Pojistenci(krestniJmeno, prijmeni, vek, telCislo, cisloPojistence.toString()));

        System.out.println("Data byla uložena. Pokračujte stisknutím klávesy enter.");
        scanner.nextLine();
    }

    public void vypsatVsechnyPojistene(Scanner scanner) {
        if (pojistenci.isEmpty()) {
            System.out.println("Nejsou evidováni žádní pojištění.");
        } else {
            for (Pojistenci pojistenec : pojistenci) {
                System.out.println(pojistenec);
            }
        }
        System.out.println("Pro pokračování stiskněte klávesu enter.");
        scanner.nextLine();
    }

    public void vyhledatPojisteneho(Scanner scanner) {
        System.out.println("Chcete vyhledat pojištěného podle:");
        System.out.println("1 - Jména a příjmení");
        System.out.println("2 - Čísla pojištěnce");
        int volba = Integer.parseInt(scanner.nextLine());
        switch (volba) {
            case 1:
                String jmeno;
                String prijmeni;

                do {
                    System.out.println("Zadejte křestní jméno:");
                    jmeno = scanner.nextLine();
                    if (jmeno.trim().isEmpty()) {
                        System.out.println("Křestní jméno nesmí být prázdné. Zkuste to prosím znovu.");
                    }
                } while (jmeno.trim().isEmpty());

                do {
                    System.out.println("Zadejte příjmení:");
                    prijmeni = scanner.nextLine();
                    if (prijmeni.trim().isEmpty()) {
                        System.out.println("Příjmení nesmí být prázdné. Zkuste to prosím znovu.");
                    }
                } while (prijmeni.trim().isEmpty());

                vyhledatPojistenehoPodleJmena(jmeno, prijmeni);
                break;
            case 2:
                System.out.println("Zadejte číslo pojištěnce:");
                String cislo = scanner.nextLine();
                vyhledatPojistenehoPodleCisla(cislo);
                break;
            default:
                System.out.println("Neplatná volba.");
        }
    }

    private void vyhledatPojistenehoPodleJmena(String jmeno, String prijmeni) {
        boolean nalezen = false;
        for (Pojistenci pojistenec : pojistenci) {
            if (pojistenec.getKrestniJmeno().equalsIgnoreCase(jmeno) && pojistenec.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println(pojistenec);
                nalezen = true;
            }
        }
        if (!nalezen) {
            System.out.println("Pojištěnec s tímto jménem a příjmením nebyl nalezen.");
        }
    }

    private void vyhledatPojistenehoPodleCisla(String cislo) {
        boolean nalezen = false;
        for (Pojistenci pojistenec : pojistenci) {
            if (pojistenec.getCisloPojistence().equals(cislo)) {
                System.out.println(pojistenec);
                nalezen = true;
            }
        }
        if (!nalezen) {
            System.out.println("Pojištěnec s tímto číslem pojištěnce nebyl nalezen.");
        }
    }
}