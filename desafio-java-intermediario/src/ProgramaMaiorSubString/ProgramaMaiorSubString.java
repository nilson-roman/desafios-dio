package ProgramaMaiorSubString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProgramaMaiorSubString {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String firstWord;
        String secondWord; //declare suas variaveis aqui
        String biggestWord;
        String smallestWord;

        while (( firstWord = in.readLine()) != null) { // complete seu código
            secondWord = in.readLine();
            if (secondWord == null  ) {
                break;
            } else {
                biggestWord = firstWord.length() > secondWord.length() ? firstWord : secondWord;
                smallestWord = biggestWord.equals(firstWord) ? secondWord : firstWord;
            }

            int minLength = smallestWord.length();
            int maxS = 0;

            for (int i = 0; i < smallestWord.length(); i++) {
                for (int j = 0; j < i + 1; j++) {
                    String aux = smallestWord.substring(j, minLength - i + j);
                    int aux2 = minLength - i + j;
                    if (biggestWord.contains(smallestWord.substring(j, minLength - i + j))) {
                        maxS = (minLength - i) > maxS ? minLength - i : maxS;
                    }
                }
            }
            out.println(maxS);
            out.flush();
        }
        out.close();
    }
}
