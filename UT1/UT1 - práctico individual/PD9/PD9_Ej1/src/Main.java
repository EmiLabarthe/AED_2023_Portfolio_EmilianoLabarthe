public class Main {
    public static void main(String[] args) {

        System.out.println(factorial(9));
    }

    public static int factorial(int num) {
        int producto = num;
        int i;
        for(i = (num - 1); i >= 1; i--) {
            producto = producto * i;
        }
        return producto;
    }
}