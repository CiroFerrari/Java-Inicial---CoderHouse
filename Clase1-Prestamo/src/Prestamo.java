public class Prestamo {
    public static void main(String[] args) {
        float capital = 1000;
        float interes = 0.5f;
        int meses = 12;
        double total;

        total = capital + capital * interes * meses / 12;

        System.out.println(total);
    }
}
