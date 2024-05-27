public class Main {
    public static void main(String[] args) {

        System.out.println(isPrime(7));
    }
    public static boolean isPrime(long n) {
        boolean prime = true;
        long i = 3;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                prime = false;
                int im = 1;
                int sumImpares = 0;
                while (im < n) {
                    sumImpares += im;
                    im += 2;
                }
                System.out.println("La suma de los impares previos es: " + sumImpares);
                break;
            }
            i += 2;
        }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            int p = 0;
            int sumPares = 0;
            while(p < n) {
                sumPares += p;
                p += 2;
            }
            System.out.println("La suma de los pares previos es: " + sumPares);
            return true;
        } else {
            int im = 1;
            int sumImpares = 0;
            while(im < n) {
                sumImpares += im;
                im += 2;
            }
            System.out.println("La suma de los impares previos es: " + sumImpares);
            return false;
        }
    }

}