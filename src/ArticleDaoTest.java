import java.sql.SQLException;
import java.util.List;

/**
 * Classe permettant de tester les opérations CRUD de {@link ArticleDao}.
 */

public class ArticleDaoTest {
    /**
     * Point d'entrée du programme de test.
     *
     * @param args arguments de la ligne de commande
     */


    public static void main(String[] args) {
/*
        try {
            ArticleDao articleDao = new ArticleDao();

            System.out.println("=== TEST CREATE ===");

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



            System.out.println("\n=== TEST FIND BY ID ===");

            Article articleTrouve = articleDao.findById(1);

            if (articleTrouve != null) {
                System.out.println("Article trouvé : " + articleTrouve);
            } else {
                System.out.println("Aucun article trouvé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



            System.out.println("\n=== TESt FIND ALL ===");

            List<Article> articles = articleDao.findAll();

            for (Article article : articles){
                System.out.println(article);
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }

            System.out.println("\n=== TEST UPDATE ===");

            Article article = articleDao.findById(13);

            if (article != null) {

                article.setDescription("Test java modifié");
                article.setBrand("NouvelleBrand");
                article.setPrice(30.0f);

                articleDao.update(article);

                System.out.println("Article modifié : " + article);

            } else {
                System.out.println("Article introuvable.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            System.out.println("\n=== TEST DELETE ===");

            articleDao.delete(13);

            System.out.println("Article 13 supprimé.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }*/
        Article article = new Article("Test", "TestBrand", 20.0f);
        try {
            article.setPrice(-10.0f);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
