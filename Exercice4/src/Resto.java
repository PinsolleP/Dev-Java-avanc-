import java.util.ArrayList;
import java.util.Scanner;

/**
 * BaseTP2Resto
 * programme simule la prise d'une commande dans un resto en ligne par exemple avec choix d'entrées, plats, 
 * accompagnements, boissons et desserts 
 *
 * @author El babili - 2021	
 *
 */

public class Resto {
    public static final MenuItem[] STARTERS = 	{
            new MenuItem("salade", 5.50),
            new MenuItem("soupe",4.50),
            new MenuItem("quiche", 6.00)
    };

    public static final MenuItem [] DISHES = 	{
            new MenuItem("poulet", 10.00),
            new MenuItem("boeuf",12.00),
            new MenuItem("poisson", 11.00),
            new MenuItem("végétarien",9.00),
            new MenuItem("vegan", 9.00)
    };

    public static final MenuItem [] SIDE_DISHES = 	{
            new MenuItem("riz", 3.00),
            new MenuItem("pates",3.00),
            new MenuItem("frites", 3.50),
            new MenuItem("légumes", 3.50)
    };

    public static final MenuItem [] DRINKS = 	{
            new MenuItem("eau plate", 2.00),
            new MenuItem("eau gazeuse",2.00),
            new MenuItem("soda", 3.00),
            new MenuItem("vin", 5.00)
    };

    public static final MenuItem[] DESSERTS = 	{
            new MenuItem("tarte maison", 5.00),
            new MenuItem("mousse au chocolat",5.00),
            new MenuItem("tiramisu", 6.00)
    };

    public static void main(String[] args) {
        System.out.println("bonjour, combien de menus souhaitez vous ?");
        Scanner scan = new Scanner(System.in);
        int nbMenu;
        while(scan.hasNextInt() == false)	scan.next();
        nbMenu = scan.nextInt();

        for(int i = 0 ; i < nbMenu ; i ++) {
            Order order = new Order();
            System.out.println("Commande numéro " + (i+1));
            MenuItem item = getInfos(scan,STARTERS);
            order.addItem(item);

            item = getInfos(scan,DISHES);
            order.addItem(item);

            item = getInfos(scan,SIDE_DISHES);
            order.addItem(item);

            item = getInfos(scan,DRINKS);
            order.addItem(item);

            item = getInfos(scan,DESSERTS);
            order.addItem(item);

            System.out.println("Résumé de la commande "+(i+1));
            System.out.println(order);    //ici on pourrait stocker la commande en base par exemple
            System.out.println("Prix total : " + order.getTotalPrice() + " €");
            System.out.println();			//avant de passer à la suivante

        }
        scan.close();
    }
    public static MenuItem getInfos(Scanner scan, MenuItem[] menu) {
        displayTable(menu);

        System.out.println("Quel élément souhaitez vous  ? [saisir le chiffre correspondant]");

        int choice = scan.nextInt();

        return menu[choice - 1];
    }
    public static void displayTable(MenuItem [] table) {
        for(int i = 0 ; i < table.length ; i++) {
            System.out.print("[" + (i + 1) + " - "
                    + table[i].getName().toUpperCase()
                    + " - " + table[i].getPrice() + " €]");
        }
        System.out.println();
    }
}