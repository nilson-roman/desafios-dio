package divisores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Divisores {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        br.close();


        int n = -1;
        List<Integer> numeros = Arrays.asList(a, b, c, d);

        for (int i = Collections.max(numeros); i > 0; i--) {
            if ((i % a) == 0 && !((i % b) == 0) && (c % i) == 0 && !((d % i) == 0)) {
                n = i;
            }
        }

        System.out.println(n);
    }
}