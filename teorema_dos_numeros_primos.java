import java.util.Random;
public class teorema_dos_numeros_primos {
    public static long modularPow(long base, long exponent, long modulus) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
    }
    public static boolean millerRabin(long n, int k) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        int r = 0;
        long d = n - 1;
        while (d % 2 == 0) {
            r++;
            d /= 2;
        }
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            long a = random.nextInt((int) (n - 3)) + 2;
            long x = modularPow(a, d, n);
            if (x == 1 || x == n - 1) {
                continue;
            }
            boolean isWitness = false;
            for (int j = 0; j < r - 1; j++) {
                x = modularPow(x, 2, n);
                if (x == n - 1) {
                    isWitness = true;
                    break;
                }
            }
            if (!isWitness) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        long num = 1000000007;
        int k = 5;
        if (millerRabin(num, k)) {
            System.out.println(num + " é provavelmente primo");
        } else {
            System.out.println(num + " é composto");
        }
    }
}

