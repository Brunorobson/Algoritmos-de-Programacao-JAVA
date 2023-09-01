public class algoritmo_de_exponenciacao_rapida {

    public static long fastExponentiation(long base, long exponent, Long modulus) {
        if (exponent == 0) {
            return 1;
        } else if (exponent % 2 == 0) {
            long halfResult = fastExponentiation(base, exponent / 2, modulus);
            if (modulus == null) {
                return halfResult * halfResult;
            } else {
                return (halfResult * halfResult) % modulus;
            }
        } else {
            long halfResult = fastExponentiation(base, (exponent - 1) / 2, modulus);
            if (modulus == null) {
                return base * halfResult * halfResult;
            } else {
                return (base * halfResult * halfResult) % modulus;
            }
        }
    }

    public static void main(String[] args) {
        long base = 2;
        long exponent = 10;
        long result = fastExponentiation(base, exponent, null);
        System.out.println(base + "^" + exponent + " = " + result);
    }
}
