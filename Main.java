import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Clasa de baza pentru Simboluri
class Simboluri {
    // Metoda pentru a afișa un mesaj generic
    void afisareMesaj() {
        System.out.println("clasa Simboluri");
    }
}

// Clasa extinsă care va folosi clasa Simboluri
class Litere extends Simboluri {
    // Suprascrierea metodei afisareMesaj din clasa de baza
    @Override
    void afisareMesaj() {
        System.out.println("Acesta este un mesaj specific din clasa Litere");
    }

    // Metoda pentru a cauta un subsir dupa un anumit sablon cu expresii regulate
    void cautaSubsir(String text, String sablon) {
        Pattern pattern = Pattern.compile(sablon);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Metoda nesuprascrisa");
            System.out.println("Am gasit subsirul \"" + matcher.group() + "\" la pozitia " + matcher.start());
        }
    }

    // Supraincarcarea metodei pentru a adauga functii suplimentare
    void cautaSubsir(String text, String sablon, boolean ignoraCase) {
        if (ignoraCase) {
            Pattern pattern = Pattern.compile(sablon, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("Metoda suprascrisa");
                System.out.println("Am gasit subsirul \"" + matcher.group() + "\" la pozitia " + matcher.start());
            }
        } else {
            cautaSubsir(text, sablon);
        }
    }

    // Supraincarcarea metodei pentru a adauga alte functii suplimentare
    void cautaSubsir(String text, String sablon, boolean ignoraCase, boolean gasesteToate) {
        if (gasesteToate) {
            Pattern pattern = Pattern.compile(sablon);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("Metdoda suprascrisa cu ignoreCase");
                System.out.println("Am gasit subsirul \"" + matcher.group() + "\" la pozitia " + matcher.start());
            }
        } else {
            cautaSubsir(text, sablon, ignoraCase);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crearea obiectului clasa Litere folosind clasa Simboluri
        Litere litere = new Litere();

        // Apelarea metodei afisareMesaj din clasa Litere
        litere.afisareMesaj();

        // Citirea textului de la utilizator
        System.out.print("Introduceti textul: ");
        String text = scanner.nextLine();

        // Citirea sablonului de la utilizator
        System.out.print("Introduceti sablonul: ");
        String sablon = scanner.nextLine();

        // Apelarea metodei de cautare a subsirului cu expresii regulate
        litere.cautaSubsir(text, sablon);

        // Apelarea metodei supraincarcate pentru a cauta subsirul ignorand case-sensitive
        litere.cautaSubsir(text, sablon, true);

        // Apelarea metodei supraincarcate pentru a cauta toate aparitiile subsirului
        litere.cautaSubsir(text, sablon, true, true);

        // Inchiderea scanner-ului
        scanner.close();
    }
}
