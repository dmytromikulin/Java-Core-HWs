class TimeDisplay {

    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            int secondsElapsed = 0;
            try {
                while (true) {
                    System.out.println("Минуло " + secondsElapsed + " секунд");
                    Thread.sleep(1000);
                    secondsElapsed++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread messageThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        timeThread.start();
        messageThread.start();
    }
}
