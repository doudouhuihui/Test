import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Item> delayQueue = new DelayQueue<>();
        new Thread(()->{
            delayQueue.offer(new Item("first", 1000));
            delayQueue.offer(new Item("second", 1300));
            delayQueue.offer(new Item("third", 2000));
            delayQueue.offer(new Item("zero", 0));
        }).start();

        for(;;) {
            Item item = delayQueue.take();
            System.out.println(item);
        }
        /**
         *
         */
    }
}


class Item implements Delayed{

    private long now  = System.currentTimeMillis();
    private long time ;
    private String name;

    public Item(String name, long time){
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Item{" +
                "time=" + time +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((now+time)-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
