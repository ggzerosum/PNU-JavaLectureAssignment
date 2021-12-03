import java.util.Locale;
import java.util.Scanner;

public class StringSetManager {

    enum StringCommand
    {
        ADD,
        SORT,
        REMOVE,
        CLEAN,
        QUIT,
        INVALID
    }

    enum Order
    {
        ASC,
        DESC
    }

    private static String[] stringSet = new String[100];
    private static int size = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true)
        {
            final StringCommand command = getCommand(scanner);
            if (command == StringCommand.QUIT)
            {
                System.out.println("BYE!");
                break;
            }

            switch (command)
            {
                case ADD:
                    add(stringSet, getString(scanner));
                    break;

                case SORT:
                    sort(stringSet, getOrder(scanner));
                    break;

                case REMOVE:
                    remove(stringSet, getString(scanner));
                    break;

                case CLEAN:
                    clear(stringSet);
                    break;

                case INVALID:
                    System.out.println("INVALID");
                    break;

                default:
                    throw new RuntimeException("default case");
            }

            print(stringSet);
        }

        scanner.close();
    }

    private static StringCommand getCommand(Scanner scanner)
    {
        try
        {
            String cmd = getString(scanner);
            return StringCommand.valueOf(cmd.toUpperCase(Locale.ROOT));
        }
        catch (IllegalArgumentException ex)
        {
            return StringCommand.INVALID;
        }
    }

    private static String getString(Scanner scanner)
    {
        return scanner.next();
    }


    private static void add(String[] stringSet, String string)
    {
        if (Has(stringSet, string))
            return;

        stringSet[size] = string;
        size++;
    }

    private static boolean Has(String[] stringSet, String string)
    {
        for (int i = 0; i < size; i++)
        {
            if (stringSet[i].equals(string))
                return true;
        }

        return false;
    }

    private static void remove(String[] stringSet, String string)
    {
        int pivot = -1;
        for (int i = 0; i < size; i++)
        {
            // Pivot을 발견하면 무조껀 좌측으로 모든 요소를 밉니다.
            if (pivot >= 0)
            {
                stringSet[i-1] = stringSet[i];
            }
            // pivot이 음수인 경우에만 이 케이스에 진입합니다.
            else if (stringSet[i].equals(string))
            {
                pivot = i;
            }
        }

        if (pivot >= 0)
        {
            stringSet[size-1] = "";
            size--;
        }
    }
    private static void clear(String[] stringSet)
    {
        for (int i = 0; i < size; i++)
        {
            stringSet[i] = "";
        }

        size = 0;
    }

    private static void print(String[] stringSet)
    {
        String output = "";
        for (int i = 0; i < size; i++)
        {
            output += stringSet[i];
            if (i < size-1)
                output += ", ";
        }

        System.out.println(String.format("Element Size:%d, Values = [%s]", size, output));
    }

    private static void sort(String[] stringSet, Order order)
    {
        for (int i = 0; i < size-1; i++)
        {
            int refreshIndex = i;
            for (int j = i+1; j < size; j++)
            {
                String target = stringSet[refreshIndex];
                String candidate = stringSet[j];
                int comp = candidate.compareTo(target);

                boolean doRefresh = order == Order.ASC ? comp <= 0 : comp >= 0;
                if (doRefresh)
                {
                    refreshIndex = j;
                }
            }

            if (refreshIndex != i)
            {
                String temp = stringSet[i];
                stringSet[i] = stringSet[refreshIndex];
                stringSet[refreshIndex] = temp;
            }
        }
    }

    private static Order getOrder(Scanner scanner)
    {
        String cmd = getString(scanner);
        return Order.valueOf(cmd.toUpperCase(Locale.ROOT));
    }
}