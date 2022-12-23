import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Savage implements Runnable {

    private static Semaphore semaphore;

    private static final AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;

    private static final int EATING_TIME = 3000;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Savage() {
        if (semaphore == null) {
            semaphore = new Semaphore(Main.SPACE_AROUND_POT, false);
        }

        this.id = idCounter.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Savage{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        semaphore.acquireUninterruptibly();

        try {
            eat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        semaphore.release(1);
    }

    public void eat() throws InterruptedException {
        if (Food.amount.decrementAndGet() >= 0) {
            System.out.println("Дикарь(" + id + ") начинает есть -->");

            Thread.sleep(EATING_TIME);

            System.out.println("Дикарь(" + id + ") поел✅");
        } else {
            wakeUpChef();

            System.out.println("Дикарь(" + id + ") ждет пока шеф приготовить еду..");
            Thread.sleep(Chef.COOKING_SPEED + 1000); //На секунду дольше чем готовит шеф;

            eat();
        }

    }

    public void wakeUpChef() throws InterruptedException {
        if (Chef.isSleeping.compareAndSet(true, false)) {
            System.out.println("Дикарь(" + id + ") будит шефа!");
            Chef.cook();
        }
    }
}
