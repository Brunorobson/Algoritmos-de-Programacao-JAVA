public class teorema_chines_do_resto {

    public static long[] extendedGCD(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }
        long[] result = extendedGCD(b, a % b);
        long gcd = result[0];
        long x1 = result[1];
        long y1 = result[2];
        long x = y1;
        long y = x1 - (a / b) * y1;
        return new long[]{gcd, x, y};
    }

    public static long chineseRemainderTheorem(long[] remainders, long[] moduli) {
        long M = 1;
        for (long m : moduli) {
            M *= m;
        }

        long x = 0;
        for (int i = 0; i < remainders.length; i++) {
            long mi = M / moduli[i];
            long[] result = extendedGCD(mi, moduli[i]);
            long yi = result[2];
            x += remainders[i] * mi * yi;
            x %= M;
        }

        return x;
    }

    public static void main(String[] args) {
        long[] remainders = {2, 3, 2};
        long[] moduli = {3, 5, 7};
        long result = chineseRemainderTheorem(remainders, moduli);
        System.out.println("The solution x is: " + result);
    }
}

