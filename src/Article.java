public class Article {
    private int identifiant;
    private String description;
    private String brand;
    private float price;

    public Article(int identifiant, String description, String brand, float price) {
        this.identifiant = identifiant;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public Article(String description, String brand, float price){
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif.");
        }
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString(){
        return "Article{" +
                "identifiant=" + identifiant +
                ", description ='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
