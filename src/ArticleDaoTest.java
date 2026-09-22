import java.sql.SQLException;
/**
 * Classe permettant de tester les opérations CRUD de {@link ArticleDao}.
 */

public class ArticleDaoTest {
    /**
     * Point d'entrée du programme de test.
     *
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args){

        try {
            ArticleDao articleDao = new ArticleDao();

            Article article = new Article(
                    "Test Java",
                    "TestBrand",
                    25.50f
            );

            articleDao.create(article);

            System.out.println("Article créé !");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
