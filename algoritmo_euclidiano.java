public class algoritmo_euclidiano {

    public static int euclideanAlgorithm(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int[] extendedEuclideanAlgorithm(int a, int b) {
        if (a == 0) {
            return new int[]{b, 0, 1};
        }
        int[] result = extendedEuclideanAlgorithm(b % a, a);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];
        int x = y1 - (b / a) * x1;
        int y = x1;
        return new int[]{gcd, x, y};
    }

    public static int modularInverse(int a, int m) {
        int[] result = extendedEuclideanAlgorithm(a, m);
        int gcd = result[0];
        int x = result[1];
        int y = result[2];
        if (gcd != 1) {
            throw new ArithmeticException("Inverse doesn't exist");
        }
        return (x + m) % m;
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        System.out.println("MDC de " + a + " e " + b + ": " + euclideanAlgorithm(a, b));

        int c = 7;
        int m = 11;
        int inverse = modularInverse(c, m);
        System.out.println("Inverso modular de " + c + " mod " + m + ": " + inverse);
    }
}
