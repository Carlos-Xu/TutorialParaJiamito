package tutorial_threads;

public class Test {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Worker worker1 = new Worker(counter);
        Worker worker2 = new Worker(counter);
        Worker worker3 = new Worker(counter);

        Thread thread1 = new Thread(worker1);
        thread1.start();
        Thread thread2 = new Thread(worker2);
        thread2.start();
        Thread thread3 = new Thread(worker3);
        thread3.start();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println();

            synchronized (counter) {
                counter.notifyAll();
            }
        }
    }
}

class Counter {
    private int count = 0;

    public Counter() {
    }

    public void increment() {
        count++;
    }

    public int currentCount() {
        return count;
    }
}

class Worker implements Runnable {

    Counter counter;

    Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) {
                counter.increment();
            }
            System.out.println("Current count: " + counter.currentCount() + " on thread" + Thread.currentThread().getName());

            synchronized (counter) {
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}