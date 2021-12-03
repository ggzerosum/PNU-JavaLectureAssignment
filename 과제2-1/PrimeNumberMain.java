import java.util.Scanner;

public class PrimeNumberMain {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int iterateCount = Integer.parseInt(scanner.next());
        //System.out.println(String.format("Enter a number: %d", iterateCount));
        System.out.println(String.format("Enter a number:"));

        for (int i = 2; i <= iterateCount; i++)
        {
            PrintPrimesLessThan(i);
        }
    }

    private static void PrintPrimesLessThan(int number)
    {
        // 2를 초과하는 모든 짝수는 소수가 아니기 때문에 어떠한 수까지의 모든 소수의 갯수는 절반보다 작을 수 밖에 없습니다.
        int[] primes = new int[(int)Math.ceil((float)number / 2f)];
        int range = GetPrimes(number, primes);
        if (range <= 0)
            return;

        String text = String.format("Prime Numbers less than or equal to %d", number);
        text += " = [";
        for (int i = 0; i < range; i++)
        {
            text += String.format("%d, ", primes[i]);
        }

        //", " 두 문자를 제거하는 단순한 방법
        text = text.substring(0, text.length()-2);
        text += "]";

        System.out.println(text);
    }

    private static int GetPrimes(int number, int[] primes)
    {
        if (number == 0 || number == 1)
            return 0;

        if (number == 2)
        {
            primes[0] = 2;
            return 1;
        }

        primes[0] = 2;
        primes[1] = 3;

        if (number <= 4)
        {
            return 2;
        }

        // 어떠한 수가 소수이려면, 자신 이하의 모든 소수로 나누어떨어지면 안됩니다.
        // 그리고, 어떠한 수의 제곱근까지만 판별하면 그 수가 소수임을 확인할 수 있습니다.
        int primeValidIndex = 1;
        for (int candidate = 4; candidate <= number; candidate++)
        {
            boolean isPrime = true;
            for (int i = 0; primes[i] * primes[i] <= candidate; i++)
            {
                int prime = primes[i];
                if (candidate % prime == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                primeValidIndex = primeValidIndex + 1;
                primes[primeValidIndex] = candidate;
            }
        }

        return primeValidIndex + 1;
    }

    // 연습용 코드
    private boolean IsPrime(int number)
    {
        if (number == 1)
            return false;

        // 2는 소수입니다
        if (number == 2)
            return true;

        // 2보다 큰 수 짝수는 1, 자기자신 그리고 2를 약수로 가지기 때문에 소수가 아닙니다.
        if ((number % 2) == 0)
            return false;

        // 2 이상의 수 중, 소수는 항상 홀수입니다. 따라서 3부터 시작합니다.
        // 어떠한 수의 제곱근까지의 수로 나누어떨어지지않는다면 그 수는 소수입니다.
       for (int i = 3; i * i <= number; i+=2)
        {
            if (number % i == 0)
                return false;
        }

       return true;
    }
}