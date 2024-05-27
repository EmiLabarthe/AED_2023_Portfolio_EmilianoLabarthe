import java.lang.reflect.Array;

/*
 *
 * En este programa, se buscará multiplicar dos vectores. Para multiplicarlos,
 * se realiza la multiplicación de los valores que estén en el mismo index.
 * Para poder realizarse la multiplicación, los vectores deben tener el mismo largo
 * y los números deben ser de tipo int.
 * Si las condiciones no se cumplen, el programa arrojará una exception.
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int[] vectorA = new int[]{2, 4};
        int[] vectorB = new int[]{4, 2};
        int[] result =multiVectores(vectorA, vectorB);
        System.out.println(result[0] + " , " + result[1]);
    }
    public static int[] multiVectores(int[] vector1, int[] vector2) throws Exception {
        if(vector1.length == vector2.length) {
            int[] resultado = new int[vector1.length];
            for(int i = 0; i < vector1.length; i++) {
                resultado[i] = vector1[i] * vector2[i];
            }
            return resultado;
        }
        else {
            throw (new Exception("Los vectores deben tener el mismo largo y ser de números enteros."));
        }
    }
}