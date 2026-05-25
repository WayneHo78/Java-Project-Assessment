import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem implements InventoryOperations {
    private List<InventoryItem> inventory;

    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();
        system.interactiveMenu();
    }

    public void interactiveMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("=== Inventory Management System ===");
            System.out.println("[1] Add Item");
            System.out.println("[2] View Items");
            System.out.println("[3] Update Item Quantity");
            System.out.println("[4] Delete Item");
            System.out.println("[0] Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addItemPrompt(scanner);
                    break;
                case "2":
                    readItems();
                    break;
                case "3":
                    updateItemPrompt(scanner);
                    break;
                case "4":
                    deleteItemPrompt(scanner);
                    break;
                case "0":
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));

        scanner.close();
    }

    private void addItemPrompt(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        InventoryItem newItem = new InventoryItem(name, price, quantity);
        addItem(newItem);
    }

    private void updateItemPrompt(Scanner scanner) {
        System.out.print("Enter item name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        updateItem(name, newQuantity);
    }

    private void deleteItemPrompt(Scanner scanner) {
        System.out.print("Enter item name to delete: ");
        String name = scanner.nextLine();
        deleteItem(name);
    }

    @Override
    public void addItem(InventoryItem item) {
        inventory.add(item);
        System.out.println("Item added: " + item);
    }

    @Override
    public void readItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            System.out.println("Current Inventory:");
            for (InventoryItem item : inventory) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void updateItem(String name, int newQuantity) {
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(newQuantity);
                System.out.println("Updated item: " + item);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    @Override
    public void deleteItem(String name) {
        InventoryItem toRemove = null;
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            inventory.remove(toRemove);
            System.out.println("Deleted item: " + toRemove);
        }
    }
}
    