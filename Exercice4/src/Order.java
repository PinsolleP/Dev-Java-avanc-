import java.util.ArrayList;

public class Order {

    private ArrayList<MenuItem> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public double getTotalPrice(){
        double total = 0;

        for (MenuItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString(){
        return items.toString();
    }

}
