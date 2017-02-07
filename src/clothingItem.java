import java.lang.reflect.Type;

public class clothingItem {

    String name;
    String category;
    Integer quantity;

    public clothingItem(){}

    public clothingItem(String name, Integer quantity, String category){
        this.category = category;
        this.name = name;
        this.quantity = quantity;
    }
}