public class TestRunnable implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 10; i ++) {

            char character = (char)('!' + i);
            String stars = "*".repeat(i + 1);


            System.out.println(character + stars + character);
        }
    }

    public static void main(String[] args){
        Thread thread = new Thread(new TestRunnable());
        thread.start();
    }
}
