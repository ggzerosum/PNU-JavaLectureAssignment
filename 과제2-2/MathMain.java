import java.util.Arrays;
import java.util.Scanner;

public class MathMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        System.out.printf(String.format("Enter N: \n"));

        //String arrayPrint = "";

        int inputNumber = 1;
        int[] inputs = new int[count];
        for (int i = 0; i < count; i++)
        {
            inputs[i] = inputNumber;
            //arrayPrint += String.format("%d ", inputNumber);

            inputNumber++;
        }
        //arrayPrint = arrayPrint.trim();
        //System.out.println(arrayPrint);

        int max = getMax(inputs);
        System.out.printf("Max element : %d in %s%n", max, Arrays.toString(inputs));

        int min = getMin(inputs);
        System.out.printf("Min element : %d in %s%n", min, Arrays.toString(inputs));

        scanner.close();
    }

    private static int getMax(int[] inputs)
    {
        int maxIndex = 0;
        for (int i = 1; i < inputs.length; i++)
        {
            int max = inputs[maxIndex];
            int current = inputs[i];

            if (current > max)
                maxIndex = i;
        }

        return inputs[maxIndex];
    }
    private static int getMin(int[] inputs)
    {
        int minIndex = 0;
        for (int i = 1; i < inputs.length; i++)
        {
            int min = inputs[minIndex];
            int current = inputs[i];

            if (current < min)
                minIndex = i;
        }

        return inputs[minIndex];
    }
}