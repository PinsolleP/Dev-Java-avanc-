import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){

        String url = "jdbc:mariadb://localhost:3306/shop";
        String user = "root";
        String password = "Pinsolle40!";

        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );
            String sql = "SELECT * FROM t_articles";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("IdArticle");
                String description = resultSet.getString("Description");
                String brand = resultSet.getString("Brand");
                float price = resultSet.getFloat("UnitaryPrice");

                Article article = new Article (
                        id,
                        description,
                        brand,
                        price
                );

                System.out.println(article);
            }

            connection.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
