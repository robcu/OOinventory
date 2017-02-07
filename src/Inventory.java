import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<clothingItem> inventory = new ArrayList();

    public static void processInventory() throws Exception{

        while(true) {
            switch(getMenuOption()) {
                case 1:
                    addToInventory();
                    break;
                case 2:
                    removeFromInventory();
                    break;
                case 3:
                    changeInventory();
                    break;
                case 4:
                    printInventory();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Integer getMenuOption() {
        System.out.println("Inventory Options:");
        System.out.println("[1] - Add a new item");
        System.out.println("[2] - Remove an item");
        System.out.println("[3] - Modify an item's quantity");
        System.out.println("[4] - Print inventory");

        return Integer.parseInt(scanner.nextLine());
    }

    static void addToInventory() throws Exception{

        inventory.add(createItem());
    }

    static void removeFromInventory(){
        System.out.println("Enter the number of the item you wish to remove:");
        inventory.remove(Integer.parseInt(scanner.nextLine()));
    }

    static void changeInventory(){
        System.out.println("Enter the number of the item, the quantity of which you wish to change:");
        Integer key = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.println("Enter the new quantity:");
        clothingItem tobeModified = new clothingItem(inventory.get(key).name, Integer.parseInt(scanner.nextLine()), inventory.get(key).category);
        inventory.set(key, tobeModified);
    }

    static void printInventory(){

        System.out.println("[Index] - Name - Quantity - Category");
        int i = 1;
        for (clothingItem item: inventory){
            System.out.printf("[%d]    %s    %d    %s\n",i, item.name, item.quantity, item.category);
            i++;
        }
        System.out.println("\n");

    }

    static clothingItem createItem() throws Exception{

        System.out.println("Enter the name of the item you wish to create:");

        String name = scanner.nextLine();
        int quantity = 0;

        System.out.println("Choose the new item's category:");
        System.out.println("[1] - Shorts");
        System.out.println("[2] - Pants");
        System.out.println("[3] - Shirt");
        System.out.println("[4] - Sweater");
        System.out.println("[5] - Hat");

        switch(Integer.parseInt(scanner.nextLine())){
            case 1:
                Shorts shorts = new Shorts(name, quantity);
                return shorts;
            case 2:
                Pants pants = new Pants(name, quantity);
                return pants;
            case 3:
                Shirt shirt = new Shirt(name, quantity);
                return shirt;
            case 4:
                Sweater sweater = new Sweater(name, quantity);
                return sweater;
            case 5:
                Hat hat = new Hat(name, quantity);
                return hat;
            default:
                throw new Exception("Invalid category choice.");
        }
    }
}
