import java.util.Random;
import java.util.Scanner;
import java.util.random.*;


public class RandomNumber {
    public static void startGame() {
        System.out.println("Игра начинается!");
        int hiddenNumber = randomNumber();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Можете начать отгадывать число");
        int statement = scanner.nextInt();
        while (statement != hiddenNumber) {
            if (statement > hiddenNumber) {
                System.out.printf("%d больше того, что загадал компьютер%n", statement);
                statement = scanner.nextInt();
            } else {
                System.out.printf("%d меньше того, что загадал компьютер%n", statement);
                statement = scanner.nextInt();
            }
        }
        System.out.println("Вы победили!");
        System.out.println("Хотите снова сыграть?");
        scanner.nextLine();
        if (scanner.nextLine().equalsIgnoreCase("да")) {
            startGame();
        } else {

        }

    }

    private static int randomNumber() {
        System.out.println("Компьютер загадывает число...");
        int random = new Random().nextInt(101);
        System.out.println(random);
        return random;
    }
}
