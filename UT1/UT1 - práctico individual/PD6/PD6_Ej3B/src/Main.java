import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

       transformarT9Texto("src/Entrada.txt");
    }

    public static void transformarT9Texto(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String rutaSalida = "src/Salida.txt";
        FileWriter fileWriter = new FileWriter(rutaSalida);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() > 0) {
                for (int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case 'A':
                            writer.write("2");
                            break;
                        case 'B':
                            writer.write("22");
                            break;
                        case 'C':
                            writer.write("222");
                            break;
                        case 'D':
                            writer.write("3");
                            break;
                        case 'E':
                            writer.write("33");
                            break;
                        case 'F':
                            writer.write("333");
                            break;
                        case 'G':
                            writer.write("4");
                            break;
                        case 'H':
                            writer.write("44");
                            break;
                        case 'I':
                            writer.write("444");
                            break;
                        case 'J':
                            writer.write("5");
                            break;
                        case 'K':
                            writer.write("55");
                            break;
                        case 'L':
                            writer.write("555");
                            break;
                        case 'M':
                            writer.write("6");
                            break;
                        case 'N':
                            writer.write("66");
                            break;
                        case 'O':
                            writer.write("666");
                            break;
                        case 'P':
                            writer.write("7");
                            break;
                        case 'Q':
                            writer.write("77");
                            break;
                        case 'R':
                            writer.write("777");
                            break;
                        case 'S':
                            writer.write("7777");
                            break;
                        case 'T':
                            writer.write("8");
                            break;
                        case 'U':
                            writer.write("88");
                            break;
                        case 'V':
                            writer.write("888");
                            break;
                        case 'W':
                            writer.write("9");
                            break;
                        case 'X':
                            writer.write("99");
                            break;
                        case 'Y':
                            writer.write("999");
                            break;
                        case 'Z':
                            writer.write("9999");
                            break;
                        case ' ':
                            writer.write("0");
                            break;
                        case '.':
                            writer.write("1");
                            break;

                        default:
                            writer.write("Inserte un caracter");
                    }
                }
            }
        }
        writer.close();
        reader.close();
    }
}