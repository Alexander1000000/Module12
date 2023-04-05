package Timer;

public class Timer {

        public static void main(String[] args) {
            TimerThread timer = new TimerThread();
            timer.start();

            ReminderThread reminder = new ReminderThread();
            reminder.start();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timer.interrupt();
            reminder.interrupt();

            }
    }

    class TimerThread extends Thread {
        private int seconds = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                seconds++;
                System.out.println("Прошло " + seconds + " секунд");
            }
        }
    }

    class ReminderThread extends Thread {
        private int count = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
                count++;
                System.out.println("Прошло уже " + count * 5 + " секунд");
            }
        }
    }