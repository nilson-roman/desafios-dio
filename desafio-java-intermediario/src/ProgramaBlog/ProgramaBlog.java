package ProgramaBlog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class ProgramaBlog {
    static final int MAX_CHAR = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        //insira sua solução aqui
        while (true) {
            line = br.readLine()
                    .trim()
                    .toLowerCase()
                    .replaceAll("\n", " ")
                    .replaceAll("\t", " ");
            if(line.equals(".")) break;
            if(line.length() <= 0) continue;
            int maxLength = (line.length() <= MAX_CHAR) ? line.length() : MAX_CHAR;
            line = line.substring(0, maxLength);
            StringTokenizer st = new StringTokenizer(line);
            List<String> palavras = new ArrayList<>();

            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                palavras.add(token);
            }

            TreeMap <Character, String> palavrasAbreviadas = abreviadorMelhorPalavra(palavras);
            abreviador(palavras, palavrasAbreviadas);
        }
    }

    public static  TreeMap<Character, String> abreviadorMelhorPalavra(List<String> palavras) {
        HashMap<String, Integer> melhorPalavraAbreviada = new HashMap<>();
        TreeMap<Character, String> abreviados = new TreeMap<>();
        for (String palavra: palavras) {
            if (melhorPalavraAbreviada.containsKey(palavra)) continue;
            if (palavra.length() > 2) {
                melhorPalavraAbreviada.put(palavra, (palavra.length() - 2) * (Collections.frequency(palavras, palavra)));
            }
        }
        while (true) {
            List<String> key = melhorPalavraAbreviada.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == Collections.max(melhorPalavraAbreviada.values()))
                    .map(e -> e.getKey())
                    .collect(Collectors.toList());
            melhorPalavraAbreviada.remove(key.get(0));
            if (!abreviados.containsKey(key.get(0).charAt(0))) {
                abreviados.put(key.get(0).charAt(0), key.get(0));
            }
            if (melhorPalavraAbreviada.isEmpty()) break;
        }
        return  abreviados;
    }

    public static void abreviador(List<String> palavras, TreeMap<Character, String> palavrasAbreviadas){
        StringBuilder texto = new StringBuilder();
        for (String palavra: palavras){
            if (palavra.equals(palavrasAbreviadas.get(palavra.charAt(0)))){
                texto.append(palavra.charAt(0));
                texto.append(". ");
            }else{
                texto.append(palavra);
                texto.append(" ");
            }
        }
        texto.setLength(texto.length() - 1);
        System.out.println(texto);
        System.out.println(palavrasAbreviadas.size());
        palavrasAbreviadas.forEach((k, v) -> System.out.println(k + ". = " + v));
    }
 }