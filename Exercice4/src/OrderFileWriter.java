import java.io.FileWriter;
import java.io.IOException;

public class OrderFileWriter {

    public void write(Order order) throws IOException {

        FileWriter writer = new FileWriter("orders.txt");

        writer.write("Test commande\n");

        writer.close();
    }
}
