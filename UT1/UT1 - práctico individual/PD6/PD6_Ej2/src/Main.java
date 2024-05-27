import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void leerEntradaArchivo(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

        String linea1 = reader.readLine();
        String linea2 = reader.readLine();
        String linea3 = reader.readLine();
        int linea1int = Integer.parseInt(linea1); float linea2float = Float.parseFloat(linea2);
        int cociente = (int) (linea2float / linea1int);
        float resultado = linea1int + linea2float;
        reader.close();
        System.out.println("El entero leído es: " + linea1);
        System.out.println("El número de punto flotante es: " + linea2);
        System.out.println("La cadena leída es ¨" + linea3 + "¨");
        System.out.println("¡Hola " + linea3 + "! La suma de " + linea1 + " y " + linea2 + " es " + resultado );
        System.out.println("La división entera de " + linea2 + " y " + linea1 + " es " + cociente + " y su resto es " + linea2float % linea1int );
    }

    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el radio de su circunferencia: ");
        int radio = scanner.nextInt();
        scanner.close();
        double area = (radio * radio) * 3.14;
        double perimetro = (radio * 2) * 3.14;

        System.out.println("El área de su círcunferencia es " + area + " y su perímetro es " + perimetro);
    }
    public static void main(String[] args) throws IOException {

        leerEntradaArchivo("src/archivo.txt");
        System.out.println("\n Parte B) \n");
        leerEntradaStdin();

    }
}