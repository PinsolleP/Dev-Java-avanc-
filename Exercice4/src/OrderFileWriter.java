import java.io.FileWriter;
import java.io.IOException;

public class OrderFileWriter {

    public void write(Order order, int orderNumber) throws IOException {

        FileWriter writer = new FileWriter("orders.txt", true);

        writer.write("*****Résumé de la commande N°" + orderNumber + " *****\n");

        for (MenuItem item : order.getItems()){
            writer.write(item.getName() + "\n");
        }

        writer.write("\n");

        writer.close();
    }
}
