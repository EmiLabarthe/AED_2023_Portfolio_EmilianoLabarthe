public class Main {
    public static void main(String[] args) {
        NumberHolder holder = new NumberHolder();
        holder.anInt = 10;
        holder.aFloat = 10.2F;
        System.out.println(holder.aFloat);
        System.out.println(holder.anInt);
    }
    static class NumberHolder {
        public int anInt;
        public float aFloat;
    }
}