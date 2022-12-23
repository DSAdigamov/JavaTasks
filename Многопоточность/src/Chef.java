import java.util.concurrent.atomic.AtomicBoolean;

public class Chef {

    public static final int COOKING_SPEED = 8000;

    public static final AtomicBoolean isSleeping = new AtomicBoolean(true);

    public static void cook() throws InterruptedException {
        System.out.println("Шеф начал готовку.. Блюдо будет готово через " + COOKING_SPEED/1000 + " секунд");

        Thread.sleep(COOKING_SPEED/1000);
        Food.amount.set(Main.POT_SIZE);

        System.out.println("Шеф приготовил блюда!");
        isSleeping.compareAndSet(false, true);
    }
}
