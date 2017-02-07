import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap userDatabase = new HashMap();


    static User user = new User();

    public static void main(String[] args) throws Exception{

        while (!user.loggedIn) {
            user.verifyUser();
        }

        Inventory.processInventory();
    }
}