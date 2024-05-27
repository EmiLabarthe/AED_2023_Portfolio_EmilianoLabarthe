import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        transformarTextoT9("src/entrada.txt");
    }

    public static void transformarTextoT9(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String rutaSalida = "src/salida.txt";
        FileWriter fileWriter = new FileWriter(rutaSalida);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String line;
        while((line = reader.readLine()) != null) {
            switch(line.charAt(0)){
                case '1':
                    writer.write(".");
                    break;
                case '2':
                    switch (line.length()) {
                        case 1:
                            writer.write("A");
                            break;
                        case 2:
                            writer.write("B");
                            break;
                        case 3:
                            writer.write("C");
                            break;
                    }
                    break;
                case '3':
                    switch (line.length()) {
                        case 1:
                            writer.write("D");
                            break;
                        case 2:
                            writer.write("E");
                            break;
                        case 3:
                            writer.write("F");
                            break;
                    }
                    break;
                case '4':
                    switch (line.length()) {
                        case 1:
                            writer.write("G");
                            break;
                        case 2:
                            writer.write("H");
                            break;
                        case 3:
                            writer.write("I");
                            break;
                    }
                    break;
                case '5':
                    switch (line.length()) {
                        case 1:
                            writer.write("J");
                            break;
                        case 2:
                            writer.write("K");
                            break;
                        case 3:
                            writer.write("L");
                            break;
                    }
                    break;
                case '6':
                    switch (line.length()) {
                        case 1:
                            writer.write("M");
                            break;
                        case 2:
                            writer.write("N");
                            break;
                        case 3:
                            writer.write("O");
                            break;
                    }
                    break;
                case '7':
                    switch (line.length()) {
                        case 1:
                            writer.write("P");
                            break;
                        case 2:
                            writer.write("Q");
                            break;
                        case 3:
                            writer.write("R");
                            break;
                        case 4:
                            writer.write("S");
                            break;
                    }
                    break;
                case '8':
                    switch (line.length()) {
                        case 1:
                            writer.write("T");
                            break;
                        case 2:
                            writer.write("U");
                            break;
                        case 3:
                            writer.write("V");
                            break;
                    }
                    break;
                case '9':
                    switch (line.length()) {
                        case 1:
                            writer.write("W");
                            break;
                        case 2:
                            writer.write("X");
                            break;
                        case 3:
                            writer.write("Y");
                            break;
                        case 4:
                            writer.write("Z");
                            break;
                    }
                    break;
                case '0':
                    writer.write(" ");
                    break;
                default:
                    writer.write("Tiene que ser un número");
            }
        }
        writer.close();
        reader.close();
    }
}