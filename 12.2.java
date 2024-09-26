import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FizzBuzz {
    private int n;
    private int current = 1;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() {
        while (current <= n) {
            synchronized (this) {
                if (current > n) break;
                if (current % 3 == 0 && current % 5 != 0) {
                    queue.offer("fizz");
                    current++;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void buzz() {
        while (current <= n) {
            synchronized (this) {
                if (current > n) break;
                if (current % 5 == 0 && current % 3 != 0) {
                    queue.offer("buzz");
                    current++;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        while (current <= n) {
            synchronized (this) {
                if (current > n) break;
                if (current % 3 == 0 && current % 5 == 0) {
                    queue.offer("fizzbuzz");
                    current++;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void number() {
        while (current <= n || !queue.isEmpty()) {
            synchronized (this) {
                if (queue.isEmpty() && current <= n) {
                    if (current % 3 != 0 && current % 5 != 0) {
                        System.out.println(current);
                        current++;
                    }
                    notifyAll();
                } else {
                    String result = queue.poll();
                    if (result != null) {
                        System.out.println(result);
                    }
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread fizzThread = new Thread(fizzBuzz::fizz);
        Thread buzzThread = new Thread(fizzBuzz::buzz);
        Thread fizzbuzzThread = new Thread(fizzBuzz::fizzbuzz);
        Thread numberThread = new Thread(fizzBuzz::number);

        fizzThread.start();
        buzzThread.start();
        fizzbuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzbuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
