import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {

    public static void main(String[] args) {
        Thread thread = new Thread(new MonRunnable(1000));

        thread.start();
    }

    private static class MonRunnable implements Runnable {

        private long delai;

        public MonRunnable(long delai) {
            this.delai = delai;
        }

        @Override
        public void run() {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            while(true) {
                try {
                    Thread.sleep(delai);
                    System.out.println("\r" + df.format(new Date()));
                    System.out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
