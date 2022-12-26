import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, Solver> solverHashMap = Map.of(
            "1", new BisectionMethod(),
            "2", new SecantMethod()
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите функцию для решения уравнения:\n" +
                "1 - Метод деления отрезка пополам\n" +
                "2 - Метод хорд\n" +
                "3 - Метод касательных");
        String chosenMethod = scanner.nextLine();

        System.out.println("Введите начало отрезка:");
        double a = scanner.nextDouble();

        System.out.println("Введите конец отрезка:");
        double b = scanner.nextDouble();

        System.out.println("Введите точность:");
        double accuracy = scanner.nextDouble();

        solverHashMap.get(chosenMethod).solve(a, b, accuracy);
    }
}
