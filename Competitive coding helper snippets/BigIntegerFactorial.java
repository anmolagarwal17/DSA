import java.math.BigInteger;

class Main {
    static BigInteger factorial(int n)
    {
        BigInteger factorial = new BigInteger(String.valueOf(BigInteger.ONE));

        for (int i = 2; i <= n; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));

        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(1000));
    }
}