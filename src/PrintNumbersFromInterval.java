import java.util.Arrays;
import java.util.Scanner;

public class PrintNumbersFromInterval {
    private static int[] array() {
        System.out.println("Введите начальное значение интервала");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите конечное значение интервала");
        int lastNumber = new Scanner(System.in).nextInt();
        System.out.println("Первое число включается в интервал?");
        int arrayLength = lastNumber - firstNumber + 1;
        String answerAboutFirstNumber = new Scanner(System.in).nextLine();
        if (answerAboutFirstNumber.equalsIgnoreCase("нет")) {
            arrayLength--;
        }
        System.out.println("Второе число включается в интервал?");
        String answerAboutLastNumber = new Scanner(System.in).nextLine();
        if (answerAboutLastNumber.equalsIgnoreCase("нет")) {
            arrayLength--;
        }
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = lastNumber - i;
        }
        Arrays.sort(array);
        return array;
    }

    private static int[] arrayForPrint(int[] array) {
        int numberOfOddNumbers = 0;
        for (int i : array) {
            if (i % 2 != 0) {
                numberOfOddNumbers++;
            }
        }
        if (numberOfOddNumbers % 5 != 0) {
            numberOfOddNumbers += 5 - (numberOfOddNumbers % 5);
        }
        int[] arrayForPrint = new int[numberOfOddNumbers];
        int count = 0;
        for (int j : array) {
            if (j % 2 != 0) {
                arrayForPrint[count] = j;
                count++;
            }
        }
        return arrayForPrint;
    }

    private static void print(int[] array) {
        int count = 1;
        for (int i : array) {
            System.out.printf("%3d,", i);

            if (count % 5 == 0) {
                System.out.println();
            }
            count++;
        }
    }

    public static void start() {
        print(arrayForPrint(array()));
    }
}
