import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleDao {

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

    public List<Article> findAll(){

    }

    public void update(Article article){

    }

    public void delete(int id){

    }
}
