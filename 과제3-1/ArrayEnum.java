import java.util.Locale;
import java.util.Scanner;

public class ArrayEnum {

    enum Command
    {
        ADD,
        LIST,
        SUM,
        SRTA,
        SRTD,
        QUIT,
        INVALID;

        private Command()
        {

        }
    }

    enum Order
    {
        ASC,
        DSC;

        private Order()
        {

        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] values = new int[100];
        int index = 0;
        while (true)
        {
            final Command command = getCommand(scanner);
            if (command == Command.QUIT)
            {
                System.out.println("Bye!");
                break;
            }

            switch (command)
            {
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case SUM:
                    print(sumList(values, index));
                    break;

                case LIST:
                    printList(values, index);
                    break;

                case SRTA:
                    printList(sort(values, index, Order.ASC), index);
                    break;

                case SRTD:
                    printList(sort(values, index, Order.DSC), index);
                    break;

                case INVALID:
                    System.out.println("Invalid Command");
                    break;

                default:
                    throw new RuntimeException("default case");
            }
        }

        scanner.close();
    }

    private static Command getCommand(Scanner scanner)
    {
        try
        {
            String cmd = scanner.next();
            return Command.valueOf(cmd.toUpperCase(Locale.ROOT));
        }
        catch (IllegalArgumentException ex)
        {
            return Command.INVALID;
        }
    }
    private static int getValue(Scanner scanner)
    {
        return Integer.parseInt(scanner.next());
    }
    private static int sumList(int[] values, int length)
    {
        int sum = 0;
        for (int i = 0; i < length; i++)
        {
            sum += values[i];
        }
        return sum;
    }
    private static void print(int value)
    {
        System.out.println(String.valueOf(value));
    }
    private static void printList(int[] values, int length)
    {
        String message = "";
        for (int i = 0; i < length; i++)
        {
            message += String.valueOf(values[i]);
            message += " ";
        }

        message = message.trim();
        System.out.println(message);
    }

    private static int[] sort(int[] original, int length, Order order)
    {
        int[] copy = new int[length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        for (int i = 0; i < copy.length-1; i++)
        {
            int targetIndex = i;
            for (int j = i+1; j < copy.length; j++)
            {
                int targetValue = copy[targetIndex];
                int candidateValue = copy[j];

                if (order == Order.ASC ? candidateValue < targetValue : candidateValue > targetValue)
                {
                    targetIndex = j;
                }
            }

            if (targetIndex != i)
            {
                int temp = copy[targetIndex];
                copy[targetIndex] = copy[i];
                copy[i] = temp;
            }
        }

        return copy;
    }
}