import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static int POT_SIZE;
    public static int SPACE_AROUND_POT;
    public static int SAVAGES_AMOUNT;

    public static void main(String[] args) {
        initInputData();
        ExecutorService executorService = Executors.newFixedThreadPool(SAVAGES_AMOUNT);

        for (int i = 0; i < SAVAGES_AMOUNT; i++) {
            executorService.execute(new Savage());
        }

        executorService.shutdown();
    }

    private static void initInputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во дикарей:");
        SAVAGES_AMOUNT = scanner.nextInt();

        System.out.println("Введите кол-во вместимой еды в горшке:");
        POT_SIZE = scanner.nextInt();
        Food.init(POT_SIZE);

        System.out.println("Введите кол-во мест вокруг горшка");
        SPACE_AROUND_POT = scanner.nextInt();

        if (SPACE_AROUND_POT > POT_SIZE) {
            SPACE_AROUND_POT = POT_SIZE;
        }
    }
}
