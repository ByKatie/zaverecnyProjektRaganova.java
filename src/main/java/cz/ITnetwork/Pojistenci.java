package cz.ITnetwork;

public class Pojistenci {
    private final String krestniJmeno;
    private final String prijmeni;
    private final int vek;
    private final String telCislo;
    private final String cisloPojistence;

    public Pojistenci(String krestniJmeno, String prijmeni, int vek, String telCislo, String cisloPojistence) {
        this.krestniJmeno = krestniJmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
        this.cisloPojistence = cisloPojistence;
    }

    public String getKrestniJmeno() {
        return krestniJmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public String getCisloPojistence() {
        return cisloPojistence;
    }

    @Override
    public String toString() {
        return "Pojištěnec:\n" +
                "Křestní jméno: " + krestniJmeno + '\n' +
                "Příjmení: " + prijmeni + '\n' +
                "Věk: " + vek + '\n' +
                "Telefonní číslo: " + telCislo + '\n' +
                "Číslo pojištěnce: " + cisloPojistence + '\n';
    }
}