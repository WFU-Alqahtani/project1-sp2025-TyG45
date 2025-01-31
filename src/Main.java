//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Setup the store and get available items
        Item[] storeItems = setupStore();

        // Create the shopping cart from command line arguments
        ArrayList<Item> cartItems = createCart(args, storeItems);

        // Print the receipt
        printReceiptInOrder(cartItems);

        // Empty the cart in reverse order
        emptyCartReverseOrder(cartItems);
    }

    // Method to setup the store and return an array of Items
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Bananas", 1.5);
        store[1] = new Item("Apple", 0.5);
        store[2] = new Item("Bread", 2.0);
        store[3] = new Item("Milk", 3.0);
        store[4] = new Item("Eggs", 2.5);
        return store;
    }

    // Method to create the shopping cart from command line arguments
    public static ArrayList<Item> createCart(String[] args, Item[] storeItems) {
        ArrayList<Item> cartItems = new ArrayList<>();

        // Process all command line arguments
        for (int i = 0; i < args.length; i++) {
            try {
                int index = Integer.parseInt(args[i]) - 1; // Convert to zero-based index
                if (index >= 0 && index < storeItems.length) {
                    Item item = storeItems[index];
                    cartItems.add(item); // Add the item to the cart
                    System.out.println("Added " + item.getItemName() + " to the cart. Price: $" + item.getItemPrice());
                } else {
                    System.out.println("Invalid item index: " + (index + 1)); // Show the original index
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }

        return cartItems; // Return the list of items in the cart
    }

    // Method to print the receipt in order
    public static void printReceiptInOrder(ArrayList<Item> cartItems) {
        double subtotal = 0.0;

        System.out.println("\nReceipt");
        System.out.println("=========================");
        System.out.println("Item                Price");

        for (Item item : cartItems) {
            System.out.printf("%-20s %.1f\n", item.getItemName(), item.getItemPrice());
            subtotal += item.getItemPrice();
        }

        double salesTax = subtotal * 0.05; // 5% sales tax
        double total = subtotal + salesTax;

        System.out.printf("=========================\n");
        System.out.printf("(a) Subtotal: %.1f\n", subtotal);
        System.out.printf("(b) Sales Tax: 5%%\n");
        System.out.printf("(c) Total: %.3f\n", total);
    }

    // Method to empty the cart in reverse order
    public static void emptyCartReverseOrder(ArrayList<Item> cartItems) {
        System.out.println("\nRemoving all items from the cart in \"Last In First Out\" order...");
        while (!cartItems.isEmpty()) {
            Item lastItem = cartItems.remove(cartItems.size() - 1); // Remove the last item
            System.out.println("Removing: " + lastItem.getItemName());
        }
        System.out.println("Cart has been emptied.");
    }
}









