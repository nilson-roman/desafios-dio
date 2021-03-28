package ProgramaConjuntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgramaConjuntos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //insira sua solução aqui

        Integer qtdPalavras = Integer.valueOf(br.readLine());

        while (true) {
            if (qtdPalavras == 0) break;
            List<String> conjunto = new ArrayList<>();

            for (int i = 0; i < qtdPalavras; i++) {
                String palavra = br.readLine().toLowerCase();
                conjunto.add(palavra);
            }

            Collections.sort(conjunto);

            if (verificarConjunto(conjunto)){
                System.out.println("Conjunto Bom");
            }else {
                System.out.println("Conjunto Ruim");
            };
            qtdPalavras = Integer.valueOf(br.readLine());
        }
    }

    private static boolean verificarConjunto(List<String> palavras) {

        List<String> conjuntoRuim = new ArrayList<>();
        for (int i = 0; i < palavras.toArray().length; i++){
            String palavra = palavras.get(i);
            List<String> compararPalavras = new ArrayList<>(palavras);
            compararPalavras.remove(i);

            for (String palavraComparar : compararPalavras){
                if(palavraComparar.startsWith(palavra)){
                    conjuntoRuim.add(palavra);
                    return conjuntoRuim.isEmpty();
                }
            }
        }
        return conjuntoRuim.isEmpty();
    }
}