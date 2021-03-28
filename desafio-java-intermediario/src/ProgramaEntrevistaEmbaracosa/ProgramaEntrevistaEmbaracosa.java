package ProgramaEntrevistaEmbaracosa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramaEntrevistaEmbaracosa {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;

        while ((linha = br.readLine()) != null) {
            String palavra = linha;
            List<String> subString = gerarSubStrings(palavra);
            List<String> palavraSemUltimaRepeticao = palavraRepetidaMaisDeUmaVez(palavra, subString);

            if(palavraSemUltimaRepeticao.size() > 0){
                for (String wordRepeated : palavraSemUltimaRepeticao) {
                    System.out.println(wordRepeated);
                }
            }else{
                System.out.println(palavra);
            }

        }
    }

    private static List<String> palavraRepetidaMaisDeUmaVez(String palavra, List<String> subStrings){
        List<String> list = new ArrayList<>();

        for (String subword : subStrings) {
            if(palavra.endsWith(subword) && verificadorSufixo(palavra, subword) > 1){
                list.add(palavra.substring(0, palavra.length() - subword.length()));
            }
        }

        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    private static int verificadorSufixo(String palavra, String sufixo){
        int ocorrencias = 0;
        String palavraParaRemoverSufixo = palavra;
        while (palavraParaRemoverSufixo.endsWith(sufixo)){
            ocorrencias++;
            palavraParaRemoverSufixo = palavraParaRemoverSufixo.substring(0, palavraParaRemoverSufixo.length() - sufixo.length());
        }
        return ocorrencias;
    }

    public static  List<String> gerarSubStrings(String palavra){
        List<String> subString = new ArrayList<>();

        for (int tamString = 1; tamString <= palavra.length(); tamString++){ // tamanho da subString
            StringBuilder sb = new StringBuilder();

            for(int iniString = 0; iniString <= palavra.length() - tamString; iniString++ ){ // index do inicio da subString
                int ultimaPosString = iniString + tamString - 1; // index da última posição da subString

                for(int k = iniString; k <= ultimaPosString; k++){
                    sb.append(palavra.charAt(k));
                }
                if(!subString.contains(sb.toString())){
                    subString.add(sb.toString());
                }
                sb.setLength(0);
            }
        }
        return subString;
    }
}