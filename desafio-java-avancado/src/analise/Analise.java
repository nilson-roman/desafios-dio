package analise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analise {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int qtdLeitura = 5;

        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numeros.add(leitor.nextInt());
        }

        long pares = numeros.stream().filter(elemento -> elemento % 2 == 0).count();
        long impares = numeros.stream().filter(elemento -> elemento % 2 != 0).count();
        long positivos = numeros.stream().filter(elemento -> elemento > 0).count();
        long negativos = numeros.stream().filter(elemento -> elemento < 0).count();

        System.out.println(pares + " valor(es) par(es)");
        System.out.println(impares + " valor(es) impar(es)");
        System.out.println(positivos + " valor(es) positivo(s)");
        System.out.println(negativos + " valor(es) negativo(s)");
    }
}
