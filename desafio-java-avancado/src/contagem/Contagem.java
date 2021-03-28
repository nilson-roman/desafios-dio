package contagem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Contagem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        Locale.setDefault(new Locale("en", "US"));

        ArrayList<Integer> lista = new ArrayList<Integer>();

        int n = sc.nextInt();
        while (n > 0) {
            lista.add(sc.nextInt());
            n--;
        }

        SortedMap<Integer, Integer> variavel = new TreeMap<>();
        lista.forEach(id -> variavel.compute(id, (k, v) -> (v == null ? 1 : v + 1)));

        variavel.entrySet().forEach(entry -> {
            System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
        });

        sc.close();
    }
}