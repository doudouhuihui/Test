package multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Add10KTest {
   static int count;
   static AtomicInteger atomicInteger = new AtomicInteger();

    private static void add10k(){
        for(int i = 0; i < 5000; i++){
            count = atomicInteger.incrementAndGet();
//           synchronized (Add10KTest.class){count++;}
        }
    }

    private static void testAdd10k() throws InterruptedException {
        Thread t1 = new Thread(()->{Add10KTest.add10k();});
        Thread t2 = new Thread(()->{Add10KTest.add10k();});
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Add10KTest.testAdd10k();
        System.out.println(Add10KTest.count);
    }
}
