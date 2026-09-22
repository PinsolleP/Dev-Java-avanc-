import java.sql.Connection;


public class Main {

    public static void main(String[] args){

        try {
            Connection connection = Database.getConnection();

            System.out.println("Connexion réussie !");

            connection.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
