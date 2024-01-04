package tutorial_threads;

public class Semaphore implements Runnable {

    private Direction currentDirection = Direction.NS;

    private synchronized void changeState() {
        currentDirection = currentDirection == Direction.NS ? Direction.EO : Direction.NS;
        System.out.println("Semaforo cambiado. Nueva dirección: " + currentDirection.spasnishName());
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(Constants.TIEMPOCAMBIOSEMAFORO);
                changeState();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
