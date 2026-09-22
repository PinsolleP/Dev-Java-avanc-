import java.util.Date;

public class Exercice2 {
    public static void main(String[] args) {
        Date date = null;
        Date today = new Date();

        try {
            System.out.println(date.getClass().getName());
        } catch (NullPointerException e) {
            System.out.println(Date.class.getName());
        }

        System.out.println(today.getClass().getName());
    }
}

