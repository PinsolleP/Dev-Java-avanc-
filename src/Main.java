import java.sql.SQLException;
import java.util.List;


public class Main {
    /**
     * Point d'entrée de l'application.
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args){

        try {
            ArticleDao articleDao = new ArticleDao();

            List<Article> articles = articleDao.findAll();

            System.out.println("=== LISTE DES ARTICLES ===");

            for (Article article : articles){
                System.out.println(article);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
