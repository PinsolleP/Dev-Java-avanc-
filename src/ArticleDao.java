import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * DAO permettant de gérer les articles dans la base de données.
 *
 * <p>Cette classe assure la communication entre les objets {@link Article}
 * et la table {@code t_articles} de la base de données.</p>
 */

public class ArticleDao {
    /**
     * Crée un nouvel article dans la base de données.
     *
     * @param article article à enregistrer
     * @throws SQLException si une erreur survient lors de l'accès à la base de données
     */
    public void create(Article article) throws SQLException {
        String sql = """
                INSERT INTO t_articles(Description, Brand, UnitaryPrice)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, article.getDescription());
            statement.setString(2, article.getBrand());
            statement.setFloat(3, article.getPrice());

            statement.executeUpdate();
        }
    }
    /**
     * Recherche un article à partir de son identifiant.
     *
     * @param id identifiant de l'article recherché
     * @return l'article trouvé, ou {@code null} s'il n'existe pas
     * @throws SQLException si une erreur survient lors de l'accès à la base de données
     */
    public Article findById(int id) throws SQLException {
        String sql = """
                SELECT IdArticle, Description, Brand, UnitaryPrice
                FROM t_articles
                WHERE IdArticle = ?
                """;

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return new Article(
                            resultSet.getInt("IdArticle"),
                            resultSet.getString("Description"),
                            resultSet.getString("Brand"),
                            resultSet.getFloat("UnitaryPrice")
                    );
                }
            }
        }
        return null;
    }
    /**
     * Récupère tous les articles présents dans la base de données.
     * @return liste contenant tous les articles
     * @throws SQLException si une erreur survient lors de l'accès à la base de données
     */
    public List<Article> findAll() throws SQLException{

        String sql = """
                SELECT IdArticle, Description, Brand, UnitaryPrice
                FROM t_articles
                """;

        List<Article> articles = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){

                Article article = new Article(
                        resultSet.getInt("IdArticle"),
                        resultSet.getString("Description"),
                        resultSet.getString("Brand"),
                        resultSet.getFloat("UnitaryPrice")
                );

                articles.add(article);
            }
        }
        return articles;
    }
    /**
     * Modifie un article existant dans la base de données.
     * @param article article contenant les nouvelles informations
     * @throws SQLException si une erreur survient lors de l'accès à la base de données
     */
    public void update(Article article) throws SQLException{

        String sql = """
                UPDATE t_articles
                SET Description = ?, Brand = ?, UnitaryPrice = ?
                WHERE Id_articles = ?
                """;

        try (Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, article.getDescription());
            statement.setString(2, article.getBrand());
            statement.setFloat(3, article.getPrice());
            statement.setInt(4, article.getIdentifiant());

            statement.executeUpdate();
        }

    }

    public void delete(int id){

    }
}
