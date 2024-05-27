
/*
 *
 * Ejercicio 2 de PD4 - Emiliano Labarthe
 *
 */
public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }

    static class Rectangle{
        public int width;
        public int height;
        public Rectangle(){}

        public int area() {
            return width*height;
        }
    }
}
