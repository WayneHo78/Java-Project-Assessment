public class InventoryItem {
    private String name;
    private double price;
    private int quantity;

    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
