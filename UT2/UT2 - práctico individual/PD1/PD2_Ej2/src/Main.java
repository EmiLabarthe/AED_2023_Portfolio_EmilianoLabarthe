import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("numeros.txt"));

        String quantity = reader.readLine();
        int N = Integer.parseInt(quantity);
        int i = 1;
        int[] arreglo = new int[N];
        int lineToInt;
        
        int contador = 0;
        for(i = 1; i <= N - 1; i++) {
            String line = reader.readLine();
            lineToInt = Integer.parseInt(line);
            arreglo[i] = lineToInt;

            for(int j = N-1; j >= i + 1; j--) {

                if(arreglo[j] < arreglo[j-1]) {
                    int highValue = arreglo[j-1];
                    int lowValue = arreglo[j];
                    arreglo[j] = (char) highValue;
                    arreglo[j-1] = (char) lowValue;
                    contador++;
                    System.out.println(arreglo[j]);
                }
            }
        }
        System.out.println(contador);
    }
}