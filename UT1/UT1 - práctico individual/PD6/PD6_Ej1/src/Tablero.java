public class Tablero {
    public static void ImprimirTablero(int base, int altura){
        if(base > 0 && altura > 0){
            int impresionH = 1;
            int impresionB = 1;
            while(impresionH <= altura) {
                while(impresionB <= base) {
                    System.out.print("X ");
                    impresionB += 1;
                }
                System.out.print("\n");
                impresionH += 1;
                impresionB = 1;
            }
        }
    }
    public static void main(String[] args) {
        ImprimirTablero(3,3);
    }
}