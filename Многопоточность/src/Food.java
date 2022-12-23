import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Food {
    public static AtomicInteger amount;

    public static AtomicBoolean isEmpty = new AtomicBoolean(false);

    public static void init(int startAmount) {
        amount = new AtomicInteger(startAmount);
    }
}
